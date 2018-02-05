package com.chieftain.agency.dao;

import com.chieftain.agency.entity.Entity;

import java.util.List;

public interface Dao<T extends Entity, I> {
	List<T> findAll();

	T find(I id);

	T save(T entity);

	void delete(I id);

	void delete(T entity);
}
