package com.bananealcanws.dao;

import java.util.List;

public interface IDao<T> {

	public T getById(String id) throws Exception;

	public List<T> searchByName(String name) throws Exception;

	public List<T> getAll() throws Exception;

	public boolean create(T t) throws Exception;

	public boolean remove(String id) throws Exception;

	public boolean update(T t) throws Exception;
}
