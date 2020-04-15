package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.response.contract.Page;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 *
 */
public interface Mapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
    default T selectById(Object id) {
        return selectByPrimaryKey(id);
    }
    List<T> selectAll(Page page);
}
