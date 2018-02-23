package com.anywell.ssh.dao;

import java.util.List;

import com.anywell.ssh.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {
	
	public List<BaseDict> findAllData(String type_code);

}
