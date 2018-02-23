package com.anywell.ssh.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	// 增
	void save(T t);

	// 删
	void delete(T t);

	// 删
	void delete(Serializable id);

	// 改
	void update(T t);

	// 查 根据id查询
	T getById(Serializable id);

	public Integer findTotalCount(DetachedCriteria dc);

	public List findDataByPage(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
