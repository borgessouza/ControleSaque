package br.com.ks.saques;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.ks.saques.service.SaqueService;
import br.com.ks.saques.util.Notas;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SaquesApplicationTests {
	
	
	@Autowired
	SaqueService saqueService;

	@Test
	public void TestaSaque250() {
		Double saque = 250D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	
	@Test
	public void TestaSaque90() {
		Double saque = 90D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	@Test
	public void TestaSaque430() {
		Double saque = 430D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	@Test
	public void TestaSaque660() {
		Double saque = 660D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	@Test
	public void TestaSaque880() {
		Double saque = 880D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	@Test
	public void TestaSaque1350() {
		Double saque = 1350D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	@Test
	public void TestaSaque5000() {
		Double saque = 5000D;
		assertThat(totalizar(saqueService.recuperaNotas(saque)), is(saque));;
	}
	
	
	public double totalizar(List<Notas> notas) {
		Double resultado = 0D;
		for (Notas notas2 : notas) 
			resultado += notas2.valor();
		return resultado;
	}

	

}
