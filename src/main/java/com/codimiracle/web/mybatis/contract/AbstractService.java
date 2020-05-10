package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.PageSlice;
import com.codimiracle.web.mybatis.contract.annotation.LogicDelete;
import com.codimiracle.web.mybatis.contract.annotation.LogicDeletedDate;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

/**
 * Service layer abstract service with Primary key type K and Entity type T
 * the interface is base of <a href="https://github.com/lihengming/spring-boot-api-project-seed">spring-boot-api-project-seed</a> repo
 *
 * @author Codimiracle
 */
public abstract class AbstractService<K, T> extends PageSliceExtractor implements Service<K, T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[1];
    }

    @Override
    public void save(T model) {
        mapper.insertSelective(model);
    }

    @Override
    public void save(List<T> models) {
        mapper.insertList(models);
    }

    @Override
    public void deleteById(K id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public void deleteByIdLogically(K id) {
        try {
            T model = modelClass.newInstance();
            Field[] declaredFields = modelClass.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(Id.class)) {
                    field.setAccessible(true);
                    field.set(model, id);
                }
                if (field.isAnnotationPresent(LogicDelete.class)) {
                    field.setAccessible(true);
                    field.set(model, true);
                }
                if (field.isAnnotationPresent(LogicDeletedDate.class)) {
                    field.setAccessible(true);
                    field.set(model, new Date());
                }
            }
            update(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T findById(K id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public PageSlice<T> findAll(Page page) {
        return extractPageSlice(mapper.selectAll(page));
    }
}
