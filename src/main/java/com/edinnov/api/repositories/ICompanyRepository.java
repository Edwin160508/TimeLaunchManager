package com.edinnov.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.edinnov.api.entities.Company;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = ICompanyRepository.COMPANY_BY_ID, 
			    query= "SELECT comp FROM company comp WHERE comp.id = :id"),
	@NamedQuery(name = ICompanyRepository.EXIST_COMPANY_BY_CNPJ, query = "SELECT comp FROM company comp WHERE comp.cnpj =:cnpj"),
	@NamedQuery(name = ICompanyRepository.DELETE_COMPANY_BY_CNPJ, query = "DELETE FROM company WHERE cnpj =:cnpj")
})
public interface ICompanyRepository extends JpaRepository<Company, Long>{
	
	public static final String COMPANY_BY_ID = "ICompanyRepository.findByCompanyId";
	
	public static final String DELETE_COMPANY_BY_CNPJ = "ICompanyRepository.deleteCompanyByCnpj";
	
	public static final String EXIST_COMPANY_BY_CNPJ = "ICompanyRepository.existsByCnpj";
	
	Company getCompanyById(Long id);
	Company findByCnpj(String cnpj);
	void deleteCompanyByCnpj(@Param("cnpj") String cnpj);
	boolean existsByCnpj(@Param("cnpj") String cnpj);
	/*List<Company> findByCompanyId(@Param("id") Long id);
	Page<Company> findByCompanyId(@Param("id") Long id, Pageable pageable);*/
	
}
