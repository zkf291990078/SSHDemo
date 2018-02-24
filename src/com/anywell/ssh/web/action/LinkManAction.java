package com.anywell.ssh.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.ssh.domain.LinkMan;
import com.anywell.ssh.services.LinkManService;
import com.anywell.ssh.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	private LinkManService ls;
	private Integer currentPage;
	private Integer pageSize;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setLs(LinkManService ls) {
		this.ls = ls;
	}

	public String add() {
//		Customer c = new Customer();
//		c.setCust_id(linkMan.getCust_id());
//		linkMan.setCustomer(c);
//		ls.saveLinkMan(linkMan);
//		return "toList";
		return NONE;
	}

	public String List() {
		DetachedCriteria dCriteria=DetachedCriteria.forClass(LinkMan.class);
		
		PageBean<LinkMan> pageBean = ls.findDataByPage(dCriteria, currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}

}
