package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.PageSlice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PageSliceExtractorTest {

    @Autowired
    private DummyMapper dummyMapper;

    @Autowired
    private DummyService dummyService;

    @Test
    void extractPageSlice() {
        PageSlice<Dummy> slice = new PageSlice<>();
        List list = Arrays.asList(slice);
        PageSlice<Dummy> result = dummyService.extractPageSlice((List<Dummy>) list);
        assertEquals(slice, result);
    }
}