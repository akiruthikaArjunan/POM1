package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loginpage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginTest extends BaseTest {

    Loginpage loginpage;
    @Test
    public void test(){
        loginpage=new Loginpage(DriverFactory.getDriver());

        loginpage.login(ConfigReader.get("username"),ConfigReader.get("password"));

        Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html","login successful");
    }
}
