package com.codimiracle.web.mybatis.contract.support.vo;

import com.codimiracle.web.basic.contract.Filter;
import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.Sorter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mapper with vo support
 * @param <T> po class
 * @param <V> vo class
 */
public interface Mapper<T, V> extends com.codimiracle.web.mybatis.contract.Mapper<T> {
    List<V> selectAllIntegrally(@Param("filter") Filter filter, @Param("sorter") Sorter sorter, @Param("page") Page page);

    V selectByIdIntegrally(Object id);
}
