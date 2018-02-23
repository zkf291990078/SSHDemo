package com.anywell.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.ssh.dao.BaseDictDao;
import com.anywell.ssh.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	public List<BaseDict> findAllData(String type_code) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", type_code));
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}
