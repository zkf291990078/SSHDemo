package com.anywell.ssh.services;

import java.util.List;

import com.anywell.ssh.domain.BaseDict;

public interface BaseDictService {
	
   public List<BaseDict> getBaseDict(String type_code);
}
