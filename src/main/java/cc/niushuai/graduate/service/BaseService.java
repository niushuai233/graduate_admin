package cc.niushuai.graduate.service;

public interface BaseService<T> {
    T addValue(T record, boolean flag, int saveOrUpdate);
}
