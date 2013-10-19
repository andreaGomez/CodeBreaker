package co.edu.udea.dae.test;

import junit.framework.Assert;


import org.junit.Before;
import org.junit.Test;

import co.edu.udea.dae.main.CodeBreaker;

public class CodeBreakerTest {
	CodeBreaker juego;
	String respuesta;
	
	@Before
	public void init() {
		juego = new CodeBreaker();
		respuesta = "";
	}
	
	@Test
	public void todosCoincidenTest(){		
		respuesta = juego.validarPosiciones("8819");
		Assert.assertEquals("XXXX", respuesta);		
	}
	
	@Test
	public void tresCoincidenTest(){
		respuesta = juego.validarPosiciones("4819");
		Assert.assertEquals("XXX", respuesta);		
	}	
	
	@Test
	public void dosCoincidenTest(){
		respuesta = juego.validarPosiciones("3815");
		Assert.assertEquals("XX", respuesta);		
	}
	
	@Test
	public void unoCoincide(){
		respuesta = juego.validarPosiciones("7549");
		Assert.assertEquals("X", respuesta);
	}
	
	@Test
	public void ningunoCoincide(){
		respuesta = juego.validarPosiciones("6543");
		Assert.assertEquals("", respuesta);
	}
	
	@Test
	public void contieneUno(){
		respuesta = juego.validarPosiciones("6482");
		Assert.assertEquals("-", respuesta);
	}
	
	@Test
	public void contieneDos(){
		respuesta = juego.validarPosiciones("6488");
		Assert.assertEquals("--", respuesta);
	}
	
	@Test
	public void contieneDos2(){
		respuesta = juego.validarPosiciones("2197");
		Assert.assertEquals("--", respuesta);
	}
	
	@Test
	public void contieneTres(){
		respuesta = juego.validarPosiciones("2198");
		Assert.assertEquals("---", respuesta);
	}
	
	@Test
	public void contieneCuatro(){
		respuesta = juego.validarPosiciones("1988");
		Assert.assertEquals("----", respuesta);
	}	

	@Test
	public void tresCoincidenUnaPosicionErradaUnaBuenaTest(){
		respuesta = juego.validarPosiciones("9819");
		Assert.assertEquals("-XXX", respuesta);		
	}
	
	@Test
	public void dosCoincidenContieneUnoTest(){
		respuesta = juego.validarPosiciones("9815");
		Assert.assertEquals("-XX", respuesta);		
	}
	
	@Test
	public void dosCoincidenContieneDosTest(){
		respuesta = juego.validarPosiciones("9818");
		Assert.assertEquals("-XX-", respuesta);		
	}
	
	@Test
	public void unoCoincideContieneUnoTest(){
		respuesta = juego.validarPosiciones("9865");
		Assert.assertEquals("-X", respuesta);		
	}
	
	@Test
	public void unoCoincideContieneDosTest(){
		respuesta = juego.validarPosiciones("9851");
		Assert.assertEquals("-X-", respuesta);		
	}
	
	@Test
	public void unoCoincideContieneTresTest(){
		respuesta = juego.validarPosiciones("9881");
		Assert.assertEquals("-X--", respuesta);		
	}
}
