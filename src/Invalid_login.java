
/*This script shows the execution of  invalid password by clicking Caps lock button*/


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Invalid_login {
	WebDriver driver;
  @Test
  public void InvalidPassword() {
	  
	

	  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@value='Caps Lock']")).click();
     driver.findElement(By.xpath("//input[@value='A' ]")).click();
     driver.findElement(By.xpath("//input[@value= '2']")).click();
     driver.findElement(By.xpath("//input[@value= '3']")).click();
     driver.findElement(By.xpath("//input[@value= '4']")).click();
     driver.findElement(By.xpath("//input[@value= 'Submit']")).click();
     
     String expected = "Your login is now temporarily blocked";
     WebElement res = driver.findElement(By.xpath("//*[@class='defaultTable']/tbody/tr/td"));
     String actual = res.getText();
     System.out.println(actual);
     Assert.assertTrue(actual.contains(expected));
     
  
     
   
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://localhost:8585/do/login");
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("Webdriver.Chrome.driver", "Chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  
  }

  @AfterTest
  public void afterTest() 
  {
	

  }

}
