package execution;

import org.testng.annotations.Test;

import constants.Constants;
import module.HomePageModule;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestSuite {
public WebDriver driver;
public WebDriverWait sync;
public HomePageModule HPM;
	@Test
	public void Login(){
		HPM.Login();
		HPM.Logout();
	}
  	@Test
  	public void Register() {
  		HPM.Click_Regiater_Link();
  	}
  	@BeforeTest
  	public void beforeTest() {
  		HPM = new HomePageModule(driver,sync);
  		HPM.navigate(Constants.Browser);
  	}
  	@AfterTest
  	public void afterTest() {
  		HPM.quit();
  	}

}
