package com.codimiracle.web.mybatis.contract.support.vo.converter;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class AbstractConverter<F, T> implements Converter<F, T> {
    protected Class<F> fromBeanClass;
    protected Class<T> toBeanClass;

    public AbstractConverter() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        fromBeanClass = (Class<F>) pt.getActualTypeArguments()[0];
        toBeanClass = (Class<T>) pt.getActualTypeArguments()[1];
    }

    public AbstractConverter(Class<F> fromBeanClass, Class<T> toBeanClass) {
        this.fromBeanClass = fromBeanClass;
        this.toBeanClass = toBeanClass;
    }

    @Override
    public T convert(F from) {
        if (Objects.nonNull(from)) {
            try {
                T toBean = toBeanClass.newInstance();
                BeanUtils.copyProperties(from, toBean);
                return toBean;
            } catch (InstantiationException | IllegalAccessException e) {
                // do you using for public class ?
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public F invert(T to) {
        if (Objects.nonNull(to)) {
            try {
                F fromBean = fromBeanClass.newInstance();
                BeanUtils.copyProperties(to, fromBean);
                return fromBean;
            } catch (InstantiationException | IllegalAccessException e) {
                // do you using for public class ?
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
