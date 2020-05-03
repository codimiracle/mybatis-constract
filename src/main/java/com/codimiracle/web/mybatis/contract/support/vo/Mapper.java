package com.codimiracle.web.mybatis.contract.support.vo;

import com.codimiracle.web.basic.contract.Filter;
import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.Sorter;

import java.util.List;

/**
 * mapper with vo support
 * @param <T> po class
 * @param <V> vo class
 */
@org.apache.ibatis.annotations.Mapper
public interface Mapper<T, V> extends com.codimiracle.web.mybatis.contract.Mapper<T> {
    List<V> selectAllIntegrally(Filter filter, Sorter sorter, Page page);

    V selectByIdIntegrally(Object id);
}
