package com.qa.ims;

import java.util.List;

public interface Dao<T> {
	List<T> readAll();
	
	void create(T t);
	
	void update(T t, String field, String newValue);
	
	void delete(T t);
}
