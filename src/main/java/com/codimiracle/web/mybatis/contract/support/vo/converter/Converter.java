package com.codimiracle.web.mybatis.contract.support.vo.converter;

public interface Converter<F, T> {
    T convert(F from);
}
