package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.PageSlice;
import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service layer base interface with Primary key type K and Entity type T
 * the interface is base of <a href="https://github.com/lihengming/spring-boot-api-project-seed">spring-boot-api-project-seed</a> repo
 *
 * @author Codimiracle
 */
public interface Service<K, T> {
    /**
     * save a persistent object.
     *
     * @param entity a persistent object
     */
    void save(T entity);

    /**
     * save a bluk of persistent object
     *
     * @param entities a list of persistent object
     */
    void save(List<T> entities);

    /**
     * delete a persistent object by id
     *
     * @param id persistent object id
     */
    void deleteById(K id);

    /**
     * delete by ids string
     * example: 1,2,3
     * this example will delete the record of id is 1,2 and 3
     *
     * @param ids ids string that is id combine with ','
     */
    void deleteByIds(String ids);

    /**
     * delete by id logically, in database, mark deleted field is true
     *
     * @param id record id
     */
    void deleteByIdLogically(K id);

    /**
     * update a persistent object
     *
     * @param entity a persistent object
     */
    void update(T entity);

    /**
     * retrieve a record by id.
     *
     * @param id the id of record
     * @return a record that id is.
     */
    T findById(K id);

    /**
     * find with tk mybatis @Column name, in database it must be unique.
     *
     * @param fieldName @Column name
     * @param value     the value of column
     * @return a record that column match the value.
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * retrieve all record by id
     * example: 1,2,3
     * this example will return those record which id is 1,2 and 3
     *
     * @param ids ids String each id combine with ','
     * @return a list of record that found
     */
    List<T> findByIds(String ids);

    /**
     * retrieve all match condition records
     *
     * @param condition condition that record should match.
     * @return list of record type T
     */
    List<T> findByCondition(Condition condition);

    /**
     * retrieve all records
     *
     * @return list of record type T
     */
    List<T> findAll();

    /**
     * retrieve all record with pagination
     *
     * @param page record page
     * @return a page slice of all record
     */
    PageSlice<T> findAll(Page page);
}
