package steps;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import Utility.ConfigRead;
import pages.LoginPage;

public class Baseclass {
	
	public WebDriver driver;
    public Logger log;
    public ConfigRead conf;
   
    //Pages 

    public LoginPage lp;
    public LoginPage addCust;  //  these 3 are created for refference, let say for example if we can have another pages as well in the aplication in future
    public LoginPage searchCust;
    public LoginPage menu;

  

    public void anyMethod() {
  }



}


