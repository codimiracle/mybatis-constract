package com.codimiracle.web.mybatis.contract;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ServiceExceptionTest {

    @Test
    void testCreateWithEmptyConstructor() {
        ServiceException exception = new ServiceException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testCreateWithMessageConstructor() {
        ServiceException exception = new ServiceException("Hello world");
        assertEquals("Hello world", exception.getMessage());
    }

    @Test
    void testCreateWithMessageAndCauseConstructor() {
        Throwable cause = new Throwable();
        ServiceException exception = new ServiceException("Hello world", cause);
        assertEquals("Hello world", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}