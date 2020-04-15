package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.response.contract.Filter;
import com.codimiracle.web.response.contract.Page;
import com.codimiracle.web.response.contract.Sorter;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DummyMapper extends Mapper<Dummy> {
    default List<Dummy> selectAll(Filter filter, Sorter sorter, Page page) {
        throw new UnsupportedOperationException();
    }
}
