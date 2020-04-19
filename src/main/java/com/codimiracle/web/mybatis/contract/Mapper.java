package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.Page;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

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
