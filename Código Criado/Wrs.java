package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrs {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://zerohora.clicrbs.com.br";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE() throws Exception {
	  String nome = "usuario vinte e um";
	  String usuario = "usuario23";
	  String email = usuario;

	 for (long i = 0; i < 3; i++) {
		 
		 int rand = 1+(int)(Math.random()*1000000);
		 
		 email = usuario + rand + "@email.com";
		 rodarTest(nome, usuario+rand, email);
		
	}
  }

private void rodarTest(String nome, String usuario, String email) {
	driver.get(baseUrl + "/wrs/action/update/newUser;jsessionid=ac19071f30d825732ff18c3a4149b3cfc47cf2a125ef.e34RbNaLchqQay0NbhmTc40.22?site=4446");
    driver.findElement(By.id("firstName")).clear();
	driver.findElement(By.id("firstName")).sendKeys(nome);
    driver.findElement(By.id("userName")).clear();
	driver.findElement(By.id("userName")).sendKeys(usuario);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("teste1");
    driver.findElement(By.id("password2")).clear();
    driver.findElement(By.id("password2")).sendKeys("teste1");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("acceptTerms")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    // Warning: assertTextPresent may require manual changes
    verificaSeExisteNoCorpo("Obrigado");
    verificaSeExisteNoCorpo(email)
        // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*user@email\\.com [\\s\\S]*$"));
;
}

private void verificaSeExisteNoCorpo(String texto) {
	assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*"+ texto +"[\\s\\S]*$"));
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
