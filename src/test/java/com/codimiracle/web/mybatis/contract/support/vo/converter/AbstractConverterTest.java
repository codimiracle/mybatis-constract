package com.codimiracle.web.mybatis.contract.support.vo.converter;

import lombok.Data;
import org.h2.util.ScriptReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractConverterTest {

    private Converter<A, B> converter;

    @Data
    public static class A {
        private String name;
    }
    @Data
    public static class B {
        private String name;
    }

    @BeforeEach
    void setUp() {
        converter = new SimpleConverter<>(A.class, B.class);
    }
    @AfterEach
    void tearDown() {
        converter = null;
    }

    @Test
    void convert() {
        A a = new A();
        a.setName("Helow");
        B b = converter.convert(a);
        assertEquals(a.getName(), b.getName());
    }

    @Test
    void invert() {
        B b = new B();
        b.setName("Helow");
        A a = converter.invert(b);
        assertEquals(b.getName(), a.getName());
    }
}