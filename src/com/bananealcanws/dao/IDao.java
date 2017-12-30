package com.bananealcanws.dao;

import java.util.List;

public interface IDao<T> {

	T getById(String id) throws Exception;

	List<T> searchByName(String name) throws Exception;

	List<T> getAll() throws Exception;

	boolean create(T t) throws Exception;

	boolean remove(String id) throws Exception;

	boolean update(T t) throws Exception;
}
