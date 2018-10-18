package com.edinnov.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edinnov.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeLaunchManagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * Descrição: Teste de validação usando pacote spring Security "BCryptor"
	 * 
	 * Objetivo: Testar vários Hahs gerados pelo "BCryptor" validado com a mesma senha, deve
	 * retornar true para passar no teste. 
	 *   
	 */
	@Test
	public void testValidatePassword() {
		String encodedPassword = PasswordUtils.generatePasswordBCrypt("123456");
		System.out.println("Senha codificada: "+encodedPassword);
		
		encodedPassword = PasswordUtils.generatePasswordBCrypt("123456");
		System.out.println("Senha codificada novamente: "+encodedPassword);
		
		System.out.println("Senha válida: "+ PasswordUtils.validatePassword("123456", encodedPassword));
		
		assertEquals(true, PasswordUtils.validatePassword("123456", encodedPassword));
	}
}
