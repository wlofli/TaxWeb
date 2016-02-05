package com.tax.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tax.model.DO.SpiderTaxTask;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/conf/spring-mvc.xml"
		,"file:src/main/resources/conf/spring-mybatis.xml"})
public class LoginTest {

	
	@Resource
	private LoginService LoginService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	

	@Test
	public void test() {
		SpiderTaxTask task = new SpiderTaxTask(); 
		
		
		fail("Not yet implemented");
	}

}
