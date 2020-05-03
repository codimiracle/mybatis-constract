package com.codimiracle.web.mybatis.contract.support.vo.converter;

public class SimpleConverter<F, T> extends AbstractConverter<F, T> {
    public SimpleConverter(Class<F> fromBeanClass, Class<T> toBeanClass) {
        super(fromBeanClass, toBeanClass);
    }
}
