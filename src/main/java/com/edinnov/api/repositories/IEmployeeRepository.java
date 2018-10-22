package com.edinnov.api.repositories;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.edinnov.api.entities.Employee;
@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = IEmployeeRepository.EXISTS_EMPLOYEE_BY_CPF, query="SELECT emp FROM employee emp WHERE emp.cpf =:cpf" )
})
public interface IEmployeeRepository extends JpaRepository<Employee, Long>{
	public static final String EXISTS_EMPLOYEE_BY_CPF = "IEmployeeRepository.existsByCpf";
	
	public static final String DELETE_EMPLOYEE_BY_CPF = "IEmployeeRepository.deleteEmployeeByCpf";
	
	Employee getEmployeeById(Long id);
	Employee findByCpf(String cpf);
	boolean existsByCpf(@Param("cpf") String cpf);
	void deleteEmployeeByCpf(@Param("cpf") String cpf);
}
