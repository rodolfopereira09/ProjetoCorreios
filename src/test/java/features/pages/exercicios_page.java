package features.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;


public class exercicios_page {
	
	@Rule
	public TestName testName = new TestName();
	
	static WebDriver driver;	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	public void abrirHome() {
		driver.get("http://correios.com.br/");
	}
	 
	public void pesquisaCEP() {
		driver.findElement(By.id("acesso-busca")).sendKeys("13310284");
		driver.findElement(By.id("acesso-busca")).submit();
	}
	
	public void acessaResultado() {
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		@SuppressWarnings("unused")
		String tabSeguinte;
		for (String tabName : tabs) {
			String nome = getDriver().switchTo().window(tabName).getTitle();
			if (nome.contains("resultadoBuscaCepEndereco")) {
				tabSeguinte = tabName;
			}
		}
	}
	
	public void printResultado() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		Files.copy(arquivo,
				new File("target" + File.separator + "screenshot" + File.separator + testName + ".jpg"));
	}
	
	public void finzaliza() {
		driver.close();
		driver.quit();
	}
}

