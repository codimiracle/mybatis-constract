package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.response.contract.Filter;
import com.codimiracle.web.response.contract.Page;
import com.codimiracle.web.response.contract.PageSlice;
import com.codimiracle.web.response.contract.Sorter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
}