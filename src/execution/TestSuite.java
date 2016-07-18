package execution;

import org.testng.annotations.Test;

import constants.Constants;
import module.HomePageModule;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
//ATU Listener
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

public class TestSuite {
	//Set Property for ATU Reporter Configuration
    {
      System.setProperty("atu.reporter.config", "C:\\Selenium\\ATUReporter_Selenium_testNG_5.5 BETA + ATU Recorder 2.1+javadoc+propfile\\atu.properties");
    }
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
