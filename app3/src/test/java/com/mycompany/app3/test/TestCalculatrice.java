package com.mycompany.app3.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.app3.CalculatriceEx;
import com.mycompany.app3.SimpleCalculatrice;

public class TestCalculatrice {
	
	private static Logger logger = LoggerFactory.getLogger(TestCalculatrice.class);
	private static SimpleCalculatrice calculatrice; //à tester
	private CalculatriceEx calculatriceEx; //à tester
	
	@BeforeAll //@BeforeAll in jUnit5 , @BeforeClass in jUnit4
	public static void initCalculatrice() {
		calculatrice = new SimpleCalculatrice();
	}
	
	@BeforeEach //@BeforeEach in jUnit5 , @Before in jUnit4
	public void initCalculatriceEx() {
		this.calculatriceEx = new CalculatriceEx();
	}
	
	@Test
	public void testAddition() {
		double resAdd=calculatrice.addition(5.5, 6.6);
		logger.trace("addition(5.5,6.6)="+resAdd);
		Assertions.assertTrue(resAdd>= (12.1 - 0.00000001) && resAdd <= (12.1 + 0.00000001));
	}
	
	@Test
	public void testMultiplication() {
		double resMult=calculatrice.multiplication(2.0, 3.3);
		logger.trace("multiplication(2.0, 3.3)="+resMult);
		Assertions.assertEquals( 6.6 , resMult, 0.00000001);
        //Assert.assert...() avec jUNit 4 et Assertions.assert...() avec jUnit5/jupiter
	}
	
	@Test
	public void testSum() {
		calculatriceEx.pushVal(1.1);
		calculatriceEx.pushVal(2.2);
		calculatriceEx.pushVal(3.3);
		double somme = calculatriceEx.sum();
		logger.trace("somme(1.1,2.2,3.3)="+somme);
		Assertions.assertEquals( 6.6 , somme, 0.00000001);
	}
	
	@Test
	public void testAverage() {
		calculatriceEx.pushVal(1.1);
		calculatriceEx.pushVal(1.5);
		double moyenne = calculatriceEx.average();
		logger.trace("moyenne(1.1,1.5)="+moyenne);
		Assertions.assertEquals( 1.3 , moyenne, 0.00000001);
	}

}
