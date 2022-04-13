package com.ncstudy;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTest {

	@Before
	public void before() {
		System.out.println("任何执行前先执行");
	}
	@BeforeClass
	public static void beforeclass() {
		System.out.println("任何执行前先执行,static 方法,  执行一次");
	}
	
	@Test
	public void test1() {
		Assert.assertTrue(false);  //报错后不执行了
		System.out.println("test1");
	}
	@Ignore
	public void ignore() {
		System.out.println("忽略的方法");
	}
	
	@AfterClass
	public static void afterclass() {
		System.out.println("任何执行后再执行,static 方法, 执行一次");
	}
	@After
	public void after() {
		System.out.println("任何执行后再执行");
	}
}
