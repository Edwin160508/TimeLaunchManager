package com.edinnov.api.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends EntityClass {
	
	private static final long serialVersionUID = 9107211411610350651L;
	private Long id;
	private String companyName;
	private String cnpj;
	private Date creationDate;
	private Date updateDate;
	private List<Employee> employees;
	
	public Company() {}
	
	@PreUpdate
	public void preUpdate() {
		this.updateDate = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		this.creationDate = atual;
		this.updateDate = atual;
	}

	@Override
	public String toString() {
		return "Company [id=" + this.id + ", companyName=" + this.companyName + ", cnpj=" + this.cnpj + ", creationDate="
				+ this.creationDate + ", updateDate=" + this.updateDate + "]";
	}
	
	//GET E SET
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="company_name", nullable=false)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="cnpj", nullable=false)
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Column(name="creation_date", nullable=false)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column(name="update_date", nullable=false)
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@OneToMany(mappedBy="company", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
		
	
}
