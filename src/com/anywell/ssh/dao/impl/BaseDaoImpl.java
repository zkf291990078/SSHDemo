package com.anywell.ssh.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.anywell.ssh.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;

	public BaseDaoImpl() {
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		T t = getById(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		// TODO Auto-generated method stub
		T t = (T) getHibernateTemplate().get(clazz, id);

		return t;
	}

	@Override
	public Integer findTotalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		dc.setProjection(Projections.rowCount());
		List<Long> countList = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if (countList != null && countList.size() > 0) {
			return countList.get(0).intValue();
		} else {
			return null;
		}
	}

	@Override
	public List findDataByPage(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByCriteria(dc, start, pageSize);
	}

}
