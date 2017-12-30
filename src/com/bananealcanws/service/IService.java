package com.bananealcanws.service;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public interface IService<T> {
	T getById(@Context UriInfo params) throws Exception;

	List<T> searchByName(@Context UriInfo params) throws Exception;

	List<T> getAll() throws Exception;

	Response create(T t) throws Exception;

	Response remove(String idJson) throws Exception;

	Response update(T t) throws Exception;
}
