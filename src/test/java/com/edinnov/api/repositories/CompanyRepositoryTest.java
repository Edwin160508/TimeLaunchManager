package com.edinnov.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

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
	
	/**Momento quando adiciona empresa
	 * em seguido consulto empresa por CNPJ
	 * realiza comparação da chave primária para confirmar
	 * se são a mesma empresa. **/
	//@Before
	public void setUp() {
		try {
			Company company = new Company();
			company.setCompanyName("InovaçãoInteligentes IT");
			company.setCnpj(CNPJ);
			company.prePersist();
			Company companySaved = this.companyRepository.save(company);
			this.companyId = companySaved.getId();
			Assert.assertFalse(companySaved == null);			
		}catch(Exception e) {			
			e.getMessage();
			Assert.assertFalse(companies == null);
		}
	}
	
	//@Test
	public void findCompanyByCnpjAfterInsertTest() {
		try {
			Company findByCnpj = this.companyRepository.findByCnpj(CNPJ);		
			assertEquals(findByCnpj.getId(), companyId);
		}catch (Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
		
	}	
	
	//@After
	public void tearnDown() {
		try {
			this.companyRepository.deleteAll();
		}catch (Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void listAllCompaniesTest() {
		try {
			this.companiesList = this.companyRepository.findAll();
			companiesList.forEach(item -> {
				System.out.println("Id: "+item.getId()+" Company: "+item.getCompanyName()+" CNPJ: "+item.getCnpj()
				+" Creation Date: "+item.getCreationDate()+" Update Date "+item.getUpdateDate());
			});
			Assert.assertFalse("Nenhum Registro encontrado no banco de dados.", companiesList.size()==0);
		}catch (Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void findCompanyByCnpjTest() {
		try {
			Company company = this.companyRepository.findByCnpj(CNPJ);
			Assert.assertFalse("Empresa não encontrada", company == null);
		}catch (Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
		
	}
	
	@Test
	public void deleteCompanyByCnpjTest() {
		try {
			this.companyRepository.deleteCompanyByCnpj(CNPJ);
			Company company = this.companyRepository.findByCnpj(CNPJ);
			Assert.assertFalse("Empresa não encontrada", company != null);
		}catch(Exception e) {
			e.getMessage();
			Assert.assertFalse(true);
		}
	}
	
	
}
