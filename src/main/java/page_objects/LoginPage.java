package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //create a webdriver object
    public WebDriver ldriver;

    //constructor
    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        //initialize page factory
        PageFactory.initElements(rdriver, this);
    }

    //defining each web element:
    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//input[@value='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText="Logout")
    @CacheLookup
    WebElement lnkLogout;

    //
    public void setUserName(String uname){
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }
}