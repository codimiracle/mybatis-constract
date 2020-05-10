package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.basic.contract.Page;
import com.codimiracle.web.basic.contract.PageSlice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AbstractServiceTest {

    @Autowired
    private DummyMapper dummyMapper;

    @Autowired
    private DummyService dummyService;

    @Test
    void save() {
        Dummy dummy = new Dummy();
        dummy.setValue("100001001010");
        dummyService.save(dummy);
        Dummy result = dummyMapper.selectById(dummy.getId());
        assertNotNull(dummy.getId());
        assertNotNull(dummy.getValue());
        dummy.setDeleted(false);
        assertEquals(dummy, result);
    }

    @Test
    void saveList() {
        Dummy a = new Dummy();
        a.setId(2000L);
        a.setValue("abc");
        Dummy b = new Dummy();
        b.setId(2001L);
        b.setValue("abcd");
        Dummy c = new Dummy();
        c.setId(2002L);
        c.setValue("abce");
        List<Dummy> dummies = Arrays.asList(a, b, c);
        dummyService.save(dummies);
        List<Dummy> results = dummyMapper.selectByIds(dummies.stream().map(dummy -> dummy.getId().toString()).collect(Collectors.joining(",")));
        for (int i = 0; i < dummies.size(); i++) {
            assertEquals(dummies.get(0), results.get(0));
        }
    }

    @Test
    void deleteById() {
        Dummy dummy = new Dummy();
        dummy.setId(3000L);
        dummy.setValue("111");
        dummyMapper.insert(dummy);
        dummyService.deleteById(dummy.getId());
        assertNull(dummyMapper.selectById(dummy.getId()));
    }

    @Test
    void deleteByIds() {
        Dummy a = new Dummy();
        a.setId(4000L);
        a.setValue("abc");
        Dummy b = new Dummy();
        a.setId(4001L);
        a.setValue("abcd");
        Dummy c = new Dummy();
        a.setId(4002L);
        a.setValue("abce");
        List<Dummy> dummies = Arrays.asList(a, b, c);
        dummyMapper.insertList(dummies);
        dummyService.deleteByIds(dummies.stream().map((dummy -> dummy.getId().toString())).collect(Collectors.joining(",")));
        List<Dummy> results = dummyService.findByIds(dummies.stream().map(dummy -> dummy.getId().toString()).collect(Collectors.joining(",")));
        assertEquals(0, results.size());
    }

    @Test
    void update() {
        final String originalValue = "1000100";
        final String newValue = "1000";
        Dummy dummy = new Dummy();
        dummy.setId(5000L);
        dummy.setValue(originalValue);
        dummyMapper.insert(dummy);
        dummy.setValue(newValue);
        dummyService.update(dummy);
        Dummy result = dummyMapper.selectById(dummy.getId());
        assertNotNull(result);
        assertEquals(newValue, result.getValue());
    }

    @Test
    void findById() {
        Dummy dummy = new Dummy();
        dummy.setId(6000L);
        dummy.setValue("Some value");
        dummyMapper.insert(dummy);
        Dummy result = dummyService.findById(dummy.getId());
        assertEquals(dummy, result);
    }

    @Test
    void findBy() {
        Dummy dummy = new Dummy();
        dummy.setId(7000L);
        dummy.setValue("Other value");
        dummyMapper.insert(dummy);
        Dummy result = dummyService.findBy("id", dummy.getId());
        assertEquals(dummy, result);
    }

    @Test
    void findByIds() {
        Dummy a = new Dummy();
        a.setId(8000L);
        a.setValue("abc");
        Dummy b = new Dummy();
        a.setId(8001L);
        a.setValue("abcd");
        Dummy c = new Dummy();
        a.setId(8002L);
        a.setValue("abce");
        List<Dummy> dummies = Arrays.asList(a, b, c);
        dummyMapper.insertList(dummies);
        List<Dummy> results = dummyService.findByIds(dummies.stream().map(dummy -> dummy.getId().toString()).collect(Collectors.joining(",")));
        for (int i = 0; i < dummies.size(); i++) {
            assertEquals(dummies.get(0), results.get(0));
        }
    }

    @Test
    void findByCondition() {
        List<Dummy> results = dummyService.findByCondition(null);
        assertTrue(results.size() >= 3);
    }

    @Test
    void findAll() {
        List<Dummy> all = dummyService.findAll();
        assertTrue(all.size() >= 3);
    }

    @Test
    void testFindAll() {
        PageSlice<Dummy> all = dummyService.findAll(new Page());
        assertTrue(all.getTotal() >= 3);
    }

    @Test
    void deleteByIdLogically() {
        Dummy dummy = new Dummy();
        dummy.setId(9000L);
        dummy.setValue("abcdefghijklmn");
        dummyMapper.insert(dummy);
        dummyService.deleteByIdLogically(dummy.getId());
        Dummy result = dummyService.findById(dummy.getId());
        assertTrue(result.getDeleted());
        assertNotNull(result.getDeletedAt());

    }
}