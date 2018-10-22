package com.edinnov.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edinnov.api.entities.Company;
import com.edinnov.api.repositories.ICompanyRepository;

@SpringBootApplication
public class TimeLaunchManagerApplication {
	
	@Autowired
	private ICompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(TimeLaunchManagerApplication.class, args);
	}
	
	public CommandLineRunner commandLineRunner() {
		return args ->{
			Company company = new Company();
			company.setCompanyName("InovaçãoInteligentes IT");
			company.setCnpj("74645215000104");
			
			this.companyRepository.save(company);
			
			List<Company> companies = this.companyRepository.findAll();
			
			companies.forEach(System.out::println);
			
		};
	}
}
