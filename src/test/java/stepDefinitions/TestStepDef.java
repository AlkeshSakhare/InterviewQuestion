package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestStepDef {
	
	public static WebDriver driver;
	
	@Given("user open chrome browser")
	public void user_open_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	}

	@When("user open url as {string}")
	public void user_open_url_as(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(url);
	}

	@SuppressWarnings("deprecation")
	@Then("verify page title as {string}")
	public void verify_page_title_as(String title) {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("Actual title: "+ driver.getTitle());
	  System.out.println("Expected title: "+title);
	  Assert.assertEquals(title, driver.getTitle(), "Page title is not matched");
	}

	@Then("close chrome browser")
	public void close_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}
}
