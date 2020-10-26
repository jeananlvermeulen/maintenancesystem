package com.startup.repository;

@Deprecated
public interface IRepository<T,ID> {

    T create(T t);
    T update(T t);
    boolean delete (ID id);
    T read (ID id);
}
