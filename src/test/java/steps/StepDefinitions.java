package steps;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


public class StepDefinitions extends Baseclass{
	
//	WebDriver driver;  // we can directly use like this. or we can create basecalss and put these over there. and we can extend that base class.
//	LoginPage lp;
//	Logger log;
//	ConfigRead conf;
	
	
	
	 @Before                                         //hooks

	    public void setup() throws Exception {
      log = Logger.getLogger("nopCommApplication");
	        PropertyConfigurator.configure(".\\testData\\log4j.properties");
       //Config
     //conf = new ConfigRead();
    Properties confProp = new Properties();
	        FileInputStream  confFile = new FileInputStream(".\\testData\\config.properties");
	        confProp.load(confFile);

    String browser = confProp.getProperty("broswer");
	        log.info("Execution on browser: " + browser);
      if(browser.equalsIgnoreCase("chrome")) {
    WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }

	        

	        else if(browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }

	        else {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }

	    }

	    

	    @BeforeStep
	    public void executeBeforeEachStep() {
        log.info("***********executeBeforeEachStep***********");
	    }

  @Given("user launch chrome browser")
	    public void launchApp() {
    log.info("***********Maximize browser***********");
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        driver.manage().window().maximize();

	        //Create an Object
	        lp = new LoginPage(driver);
    }

	    @When("user open app {string}")
	    public void user_open_app(String appURL) {
	        log.info("Application URL: " + appURL);
	        driver.get(appURL);
	    }

	    @When("user enter email as {string} and password as {string}")
	    public void user_enter_email_as_and_password_as(String email, String pwd) {
	        log.info("enter userName " + email);
	        lp.enterEmail(email);
	        log.info("enter password " + pwd);
	        lp.enterPass(pwd);
    }

	    @When("user click on Login")
	    public void user_click_on_Login() {
	        log.info("click on login button");
	        lp.clickLoginButton();
    }

	    @Then("page Title should be {string}")
	    public void page_Title_should_be(String expectedTitle) throws Exception {
       log.info("Application Title: " + expectedTitle);
	        lp.verifyApplicationTitle(expectedTitle);
	    }

	    @When("user click on Logout link")
	    public void user_click_on_Logout_link() {
	        log.info("click on logout button");
	        lp.clickLogoutButton();
	    }

	    @Then("close the browser")
	    public void close_the_browser() {
        log.info("close the browser");
	        driver.close();
	    }


	}


	

	

