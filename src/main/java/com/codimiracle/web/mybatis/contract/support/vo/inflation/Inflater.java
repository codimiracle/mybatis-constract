package com.codimiracle.web.mybatis.contract.support.vo.inflation;

public interface Inflater<T extends Inflatable> {
    void inflate(T inflatingPersistentObject);
}
