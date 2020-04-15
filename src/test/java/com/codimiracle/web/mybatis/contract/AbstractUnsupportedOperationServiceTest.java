package com.codimiracle.web.mybatis.contract;

import com.codimiracle.web.response.contract.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractUnsupportedOperationServiceTest {

    private Object entity;
    private TestService testService;

    @BeforeEach
    void setUp() {
        this.testService = new TestService();
        this.entity = new Object();
    }

    @AfterEach
    void tearDown() {
        this.testService = null;
        this.entity = null;
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.save(this.entity);
        });
    }

    @Test
    void saveList() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.save(Arrays.asList(this.entity));
        });
    }

    @Test
    void deleteById() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.deleteById("test");
        });
    }

    @Test
    void deleteByIds() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.deleteByIds("test1,test2,test3");
        });
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.update(this.entity);
        });
    }

    @Test
    void findById() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.findById("test");
        });
    }

    @Test
    void findBy() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.findBy("field", "test");
        });
    }

    @Test
    void findByIds() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.findByIds("test1,test2,test3");
        });
    }

    @Test
    void findByCondition() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.findByCondition(null);
        });
    }

    @Test
    void findAll() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.findAll();
        });
    }

    @Test
    void findAllWithPage() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Page page = new Page();
            this.testService.findAll(page);
        });
    }

    @Test
    void deleteByIdLogically() {
        assertThrows(UnsupportedOperationException.class, () -> {
            this.testService.deleteByIdLogically("test");
        });
    }

    class TestService extends AbstractUnsupportedOperationService<String, Object> {
    }
}