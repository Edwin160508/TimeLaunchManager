package com.edinnov.api.repositories;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edinnov.api.entities.Company;
import com.edinnov.api.entities.Employee;
import com.edinnov.api.enums.ProfileEnum;
import com.edinnov.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
	
	private static final String CNPJ = "74645215000104";
	private static final String CPF = "68481706400";
	private static final Long ID = 1L;
	private Long emplyeeId;
	private Long companyId;
	private List<Employee> employeeList; 
	
	@Autowired
	public IEmployeeRepository employeeRepository;
	
	@Autowired
	public ICompanyRepository companyRepository;
	
	@Test
	public void insertEmplyeeTest() {
		try {
			/*Company*/
			Company company = new Company();
			company.setCompanyName("InovaçãoInteligentes IT");
			company.setCnpj(CNPJ);
			company.prePersist();
			Company companySaved = this.companyRepository.save(company);
			this.companyId = companySaved.getId();
			/*Employee*/
			Employee employee = new Employee();
			employee.setName("Edwin Lima");
			employee.setEmailAddress("edwin.lima@inovacaointeligentes.com.br");
			employee.setPassword(PasswordUtils.generatePasswordBCrypt("123456"));
			employee.setCpf(CPF);
			employee.setTimeValue(new BigDecimal(8.00));
			employee.setDailyQuantityHours(8.0f);
			employee.setLunchQuantityHours(2.0f);
			employee.setProfile(ProfileEnum.ROLE_ADMIN);
			employee.prePersist();						
			employee.setCompany(companySaved);
			Employee emplyeeSaved = this.employeeRepository.save(employee);
			Assert.assertFalse(companySaved == null && emplyeeSaved == null);
		}catch(Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
	}
	
	
}
