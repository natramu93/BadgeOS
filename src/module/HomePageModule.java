package module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import atu.testng.reports.ATUReports;
import constants.Constants;
import pageObjects.HomePage;
import pageObjects.UserHomePage;

public class HomePageModule {
public WebDriver driver;
public WebDriverWait sync;
public HomePage HP;
public UserHomePage UHP;
	public HomePageModule(WebDriver Webdriver, WebDriverWait Webdriverwait){
		super();
		this.driver = Webdriver;
		this.sync = Webdriverwait;
	}
	public void navigate(String Browser){
	if(Browser.equalsIgnoreCase("ff"))
		driver = new FirefoxDriver();
	else if(Browser.equalsIgnoreCase("chrome")){
		try{
			System.setProperty("webdriver.chrome.driver", Constants.chrome);
			driver = new ChromeDriver();
		}
		catch(Exception e){
			Reporter.log("The Chrome driver you tried to initiate has some error, so the firefox is opened by default");
			driver = new FirefoxDriver();
		}
	}
	ATUReports.setWebDriver(driver);
	ATUReports.indexPageDescription = "BadgeOS Project Test Report of ASAHI Technologies";
	driver.get(Constants.URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	sync = new WebDriverWait(driver,30);
	HP = new HomePage(driver,sync);
	UHP = new UserHomePage(driver,sync);
	}
	public void quit(){
		driver.quit();
	}
	public void Click_Regiater_Link(){
		try{
			HP.Register_Link().click();
		}
		catch(Exception e){
			Reporter.log("Issue with Register Link");
			Assert.fail();
		}
	}
	public void Login(){
		try
		{
			HP.Username_Txtbox().sendKeys(Constants.admin_usr);
			HP.Password_Txtbox().sendKeys(Constants.admin_pwd);
			HP.Login_Btn().click();
		}
		catch(Exception e){
			Reporter.log("Issue with Login elements (Username, Password, Login Btn)");
			Assert.fail();
		}
		try
		{
			UHP.Logout_Link();
			Reporter.log("Login Successful");
		}
		catch(Exception e){
			try{
				HP.Login_Error();
				Reporter.log("Login Credentials is wrong");
			}
			catch(Exception E){
			Reporter.log("Login Functionality issue");
			Assert.fail();
			}
		}
	}
	public void Logout(){
		try{
			UHP.Logout_Link().click();
			HP.Register_Link();
			Reporter.log("Log Out Successful");
		}
		catch(Exception e){
			Reporter.log("Log Out Error");
			Assert.fail();
		}
	}
}
