/**
 * 
 */
package com.gvision.prueba.login;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author ldgaribello
 *
 */
@RunWith(value = Parameterized.class)
public class LoginTest {
	/**
	 * Para mac "geckodriver-mac"; Para Windows "geckodriver-win"; Para linux
	 * "geckodriver-linux"
	 */
	public static final String NOMBRE_DRIVER_SISTEMA_OPERATIVO_FIREFOX = "geckodriver-mac";
	/**
	 * Para mac "chromedriver-mac"; Para Windows "chromedriver-win"; Para linux
	 * "chromedriver-linux"
	 */
	public static final String NOMBRE_DRIVER_SISTEMA_OPERATIVO_CHROME = "chromedriver-mac";
	public static int index = 1;

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { "test", "secret", "Books" }, { "userError", "secretError", "Login" } };
		return Arrays.asList(data);
	}

	private String user, pass, tituloPagina;
	private WebDriver driver;

	public LoginTest(String user, String pass, String tituloPagina) {
		super();
		this.user = user;
		this.pass = pass;
		this.tituloPagina = tituloPagina;
	}

	@Test
	public void testLoginFireFox() throws Exception {
		System.setProperty("webdriver.gecko.driver", NOMBRE_DRIVER_SISTEMA_OPERATIVO_FIREFOX);
		driver = new FirefoxDriver();
		driver.navigate().to("http://sahitest.com/demo/training/login.htm");
		WebElement elementUser = driver.findElement(By.name("user"));
		WebElement elementPass = driver.findElement(By.name("password"));
		WebElement elementBoton = driver.findElement(By.className("button"));
		System.out.println("Page title is: " + driver.getTitle());
		elementUser.sendKeys(user);
		elementPass.sendKeys(pass);
		elementBoton.click();
		System.out.println("Page title is: " + driver.getTitle());
		String titlePaginaResultado = driver.getTitle();
		Assert.assertEquals(tituloPagina, titlePaginaResultado);
	}
	
	@Test
	public void testLoginChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver", NOMBRE_DRIVER_SISTEMA_OPERATIVO_CHROME);
		driver = new ChromeDriver();
		driver.navigate().to("http://sahitest.com/demo/training/login.htm");
		WebElement elementUser = driver.findElement(By.name("user"));
		WebElement elementPass = driver.findElement(By.name("password"));
		WebElement elementBoton = driver.findElement(By.className("button"));
		System.out.println("Page title is: " + driver.getTitle());
		elementUser.sendKeys(user);
		elementPass.sendKeys(pass);
		elementBoton.click();
		System.out.println("Page title is: " + driver.getTitle());
		String titlePaginaResultado = driver.getTitle();
		Assert.assertEquals(tituloPagina, titlePaginaResultado);
	}
	
	@After
	public void finalizar() {
		driver.close();
		driver = null;
	}
}
