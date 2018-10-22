package com.edinnov.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.edinnov.api.entities.Company;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class CompanyRepositoryTest {
	private static final String CNPJ = "74645215000104";
	private Long companyId;
	private List<Company> companies;
	private List<Company> companiesList;
	
	@Autowired
	public ICompanyRepository companyRepository;
	
	@Test
	public void setUp() {
		try {
			Company company = new Company();
			company.setCompanyName("InovaçãoInteligentes IT");
			company.setCnpj(CNPJ);
			company.prePersist();
			Company companySaved = this.companyRepository.save(company);
			Assert.assertFalse(companySaved == null);
			/*this.companyId = companySaved.getId();
			
			this.companies = this.companyRepository.findAll();
			companies.forEach(System.out::println);
			assertEquals("Lista de empresas são iguais", this.companyRepository.findAll(), companies);*/
		}catch(Exception e) {			
			e.getMessage();
			Assert.assertFalse(companies == null);
		}
	}
	
	/*@After
	public void tearnDown() {
		this.companyRepository.deleteAll();
	}
	
	@Test
	public void findCompanyByCnpjTest() {
		try {
			this.companiesList = (List<Company>) this.companyRepository.findByCnpj(CNPJ);
			companiesList.forEach(item ->{				
				assertEquals(CNPJ, item.getCnpj());
			});
		}catch(Exception e) {
			e.getMessage();
			Assert.assertFalse(companiesList == null);
		}
	}
	
	@Test
	public void findCompanyByIdTest() {
		try {
			List<Company> companiesList = this.companyRepository.findByCompanyId(companyId);
			companiesList.forEach(item ->{
				assertEquals(this.companyId, item.getId());
			});
			
		}catch(Exception e) {
			e.getMessage();
			Assert.assertFalse(companyId == null);						
		}
	}*/
	
}
