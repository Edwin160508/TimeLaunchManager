package com.edinnov.api.repositories;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edinnov.api.entities.Company;
import com.edinnov.api.entities.Employee;
import com.edinnov.api.entities.Launching;
import com.edinnov.api.enums.ProfileEnum;
import com.edinnov.api.enums.TypeEnum;
import com.edinnov.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaunchingRepositoryTest {
	private static final Long ID = 1L;
	private static final String CPF = "71342761391";
	private static final String CNPJ_NEW_COMPANY = "54561933000187";
	private Long launchingId;
	private Long emplyeeId;
	private Long companyId;
	
	
	@Autowired
	public ICompanyRepository companyRepository;
	
	@Autowired
	public IEmployeeRepository employeeRepository;
	
	@Autowired
	public ILaunchingRepository launchingRepository;
	
	@Test
	public void insertLaunchingTest() {
		try {
			/*Company*/
			/*Recuperando uma empresa já existente em banco de dados.*/
			//Company company = companyRepository.findByCnpj(CompanyRepositoryTest.CNPJ);				
			/*Employee*/
			/*Criando novo empregado acossiando a empresa*/
			/*Employee employee = new Employee();
			employee.setName("José da Silva");
			employee.setEmailAddress("jose.silva@inovacaointeligentes.com.br");
			employee.setPassword(PasswordUtils.generatePasswordBCrypt("654321"));
			employee.setCpf(CPF);
			employee.setTimeValue(new BigDecimal(8.00));
			employee.setDailyQuantityHours(8.0f);
			employee.setLunchQuantityHours(2.0f);
			employee.setProfile(ProfileEnum.ROLE_ADMIN);
			employee.prePersist();						
			employee.setCompany(company);
			Employee emplyeeSaved = this.employeeRepository.save(employee);*/
			Employee emplyeeSaved = employeeRepository.findByCpf(CPF);
		
			Launching launching = new Launching();
			launching.setDate(new Date());
			launching.setType(TypeEnum.JOB_BEGIN);
			launching.prePersist();
			launching.setEmployee(emplyeeSaved);
			Launching launchingSaved = launchingRepository.save(launching);
		
			Assert.assertFalse("Não foi possível salvar registro.", emplyeeSaved == null && launchingSaved == null);
		}catch (Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
	}
}
