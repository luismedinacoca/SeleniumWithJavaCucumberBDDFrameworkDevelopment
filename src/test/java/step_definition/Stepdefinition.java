package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.LoginPage;

public class Stepdefinition {

    public WebDriver driver;
    public LoginPage lp;

    @Given("^User Launch Chrome browser$")
    public void user_Launch_Chrome_browser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //Initiazile a Chrome driver
        driver = new ChromeDriver();

        //create an instance of Login Page
        lp = new LoginPage(driver);
    }

    @When("^User opens URL \"([^\"]*)\"$")
    public void user_opens_URL(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        //get the url
        driver.get(url);
    }

    @When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void user_enters_Email_as_and_Password_as(String email, String pwd) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        //enter or set the credentials
        lp.setUserName(email);
        lp.setPassword(pwd);
    }

    @When("^Click on Login$")
    public void click_on_Login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        lp.clickLogin();
    }

    @Then("^Page Title should be \"([^\"]*)\"$")
    public void page_Title_should_be(String title) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }else{
            Assert.assertEquals(title, driver.getTitle());
            System.out.println("page title is correct and user is logged in!");
        }
    }

    @When("^User click on Log out link$")
    public void user_click_on_Log_out_link() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("^close browser$")
    public void close_browser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        driver.close();
    }
}
