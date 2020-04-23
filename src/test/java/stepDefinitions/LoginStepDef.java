package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {

	static WebDriver driver;
	
	@Given("I open chrome browser")
	public void i_open_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	}

	@Given("open url as {string}")
	public void open_url_as(String url) {
	    // Write code here that turns the phrase above into concrete actions
	  driver.get(url);
	}

	@When("I enter <username> and <password>")
	public void i_enter_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   List<String> data=dataTable.asList();
	   driver.findElement(By.id("username")).sendKeys(data.get(0));
	   driver.findElement(By.id("password")).sendKeys(data.get(1));
	}

	@When("click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.id("loginbtn")).click();
	}

	@Then("I validate login user")
	public void i_validate_login_user() {
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertTrue(driver.getCurrentUrl().contains("home.html"));
	}


}
