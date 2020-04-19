package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.Filter;
import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.PageSlice;
import com.codimiracle.web.basic.contract.Sorter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaginatorTest {
    @Resource
    private DummyMapper dummyMapper;

    @Test
    void testPaginator() {
        List dummies = dummyMapper.selectAll(new Page());
        assertDoesNotThrow(() -> {
            PageSlice<Dummy> slice = (PageSlice<Dummy>) dummies.get(0);
            assertNotNull(slice);
        });
    }

    @Test
    void testPaginatorWithError() {
        assertThrows(ServiceException.class, () -> {
            dummyMapper.selectAll(new Filter(), new Sorter(), new Page());
        });
    }

    @Test
    void testOtherPagination() {
        List dummies = dummyMapper.selectSome(new Page());
        assertDoesNotThrow(() -> {
            PageSlice<Dummy> slice = (PageSlice<Dummy>) dummies.get(0);
            assertNotNull(slice);
        });
    }
}