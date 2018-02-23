package com.anywell.ssh.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.anywell.ssh.domain.BaseDict;
import com.anywell.ssh.services.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {

	private BaseDictService bs;
	private String dict_type_code;

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBs(BaseDictService bs) {
		this.bs = bs;
	}

	@Override
	public String execute() throws Exception {
		List<BaseDict> baseDicts = bs.getBaseDict(dict_type_code);
		String dictsStr = JSONArray.fromObject(baseDicts).toString();
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(dictsStr);
		return null;
	}

}
