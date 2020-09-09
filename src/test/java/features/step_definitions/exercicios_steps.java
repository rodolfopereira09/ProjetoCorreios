package features.step_definitions;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test; 

import features.pages.exercicios_page;

public class exercicios_steps {
	
	exercicios_page homepage = new exercicios_page();

	@Before
	public void beforeTeste() {
		homepage.inicializa();
	}

	@Test
	public void exercicio_01() throws IOException {
		homepage.abrirHome();
		homepage.pesquisaCEP();
		homepage.acessaResultado(); 
		homepage.printResultado();	
	}

	@Test
	public void exercicio_02() throws IOException {
		homepage.abrirHome();
		homepage.pesquisaCEP();
		homepage.acessaResultado(); 
		homepage.printResultado();
	}
	
	@After
	public void afterTest() {
		homepage.finzaliza();
	}
}
