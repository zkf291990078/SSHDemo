package com.anywell.ssh.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.ssh.domain.Customer;
import com.anywell.ssh.services.CustomerService;
import com.anywell.ssh.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private CustomerService cs;
	private Integer currentPage;
	private Integer pageSize;
	
	//上传的文件会自动封装到File对象
		//在后台提供一个与前台input type=file组件 name相同的属性
		private File photo;
		//在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
		private String photoFileName;
		//在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中 
		private String photoContentType;
//	private Long cust_id;

//	public void setCust_id(Long cust_id) {
//		this.cust_id = cust_id;
//	}

	@Override
	public Customer getModel() {
		return customer;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String list() {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		// 1 调用Service查询分页数据(PageBean)
		PageBean<Customer> pageBean = cs.findPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}

	public String add() {
		if(photo!=null){
			System.out.println("文件名称:"+photoFileName);
			System.out.println("文件类型:"+photoContentType);
			//将上传文件保存到指定位置
			 photo.renameTo(new File("/Users/zkf/Downloads/upload/"+photoFileName));
			}
		
		if (customer.getCust_id() == null) {
			cs.saveCustomer(customer);
		} else {
			cs.updateCustomer(customer);
		}

		return "toList";
	}

	public String edit() {
		Customer c = cs.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", c);
		return "edit";
	}

}
