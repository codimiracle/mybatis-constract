package com.codimiracle.web.mybatis.contract;

/**
 * Service layer exception
 * the interface is base of <a href="https://github.com/lihengming/spring-boot-api-project-seed">spring-boot-api-project-seed</a> repo
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
