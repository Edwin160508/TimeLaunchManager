package com.edinnov.api.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.edinnov.api.enums.ProfileEnum;
@Entity
@Table(name = "employee")
public class Employee extends EntityClass{

	
	private static final long serialVersionUID = -4182692147394888731L;
	private Long id;
	private String name;
	private String emailAddress;
	private String password;
	private String cpf;
	private BigDecimal timeValue;
	private Float dailyQuantityHours;
	private Float lunchQuantityHours;
	private ProfileEnum profile;
	private Date creationDate;
	private Date updateDate;
	private Company company;
	private transient List<Launching> launchings;
	
	public Employee() {}
	
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
		return "Employee [id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", password=" + password
				+ ", cpf=" + cpf + ", timeValue=" + timeValue + ", dailyQuantityHours=" + dailyQuantityHours
				+ ", lunchQuantityHours=" + lunchQuantityHours + ", profile=" + profile + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", company=" + company + "]";
	}

	// GET e SET
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email", nullable=false)
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name="password", nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(name="cpf", nullable=false)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name="time_value", nullable=true)
	public BigDecimal getTimeValue() {
		return timeValue;
	}
	public void setTimeValue(BigDecimal timeValue) {
		this.timeValue = timeValue;
	}

	@Column(name="daily_quantity_hours" ,nullable=true)
	public Float getDailyQuantityHours() {
		return dailyQuantityHours;
	}
	public void setDailyQuantityHours(Float dailyQuantityHours) {
		this.dailyQuantityHours = dailyQuantityHours;
	}

	@Column(name="lunch_quantity_hours", nullable=true)
	public Float getLunchQuantityHours() {
		return lunchQuantityHours;
	}
	public void setLunchQuantityHours(Float lunchQuantityHours) {
		this.lunchQuantityHours = lunchQuantityHours;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="profile", nullable=false)
	public ProfileEnum getProfile() {
		return profile;
	}
	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
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

	@ManyToOne(fetch = FetchType.EAGER)
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Launching> getLaunchings() {
		return launchings;
	}
	public void setLaunchings(List<Launching> launchings) {
		this.launchings = launchings;
	}
	
	
	
	
}
