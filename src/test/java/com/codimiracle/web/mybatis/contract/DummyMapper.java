package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.Filter;
import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.Sorter;

import java.util.Arrays;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DummyMapper extends Mapper<Dummy> {
    default List<Dummy> selectAll(Filter filter, Sorter sorter, Page page) {
        throw new UnsupportedOperationException();
    }

    default List<Dummy> selectSome(Page page) {
        Dummy dummy1 = new Dummy();
        Dummy dummy2 = new Dummy();
        return Arrays.asList(dummy1, dummy2);
    }
}
