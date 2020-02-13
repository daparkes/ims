package com.qa.ims.persistence.dao;

import java.util.List;

/**
 * Interface for all DAOs specifying CRUD functionality for each.
 * @author Admin
 *
 * @param <T>
 */
public interface Dao<T> {
	List<T> readAll();
	
	T create(T t);
	
	T update(T t);
	
	void delete(Long id);
}
