package interviewQuestion;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestD {

	@Test
	public void handleAlert() throws IOException {

		// 1.Handle alert
		WebDriver driver = new ChromeDriver();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("Send some message to prompt");
		alert.getText();// to get alert message

		// 2.Handle broken links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String urlLink = element.getAttribute("href");
			URL link = new URL(urlLink);
			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			// Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			// connect using connect method
			httpConn.connect();
			// use getResponseCode() to get the response code.
			if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());

			}
		}

		// 3.DIff b/w implicit and explicit waits

		/*
		 * Implicit waits:Implicit waits are used to provide a default waiting time (say
		 * 30 seconds) between each consecutive test step/command across the entire test
		 * script. Thus, the subsequent test step would only execute when the 30 seconds
		 * have elapsed after executing the previous test step/command.
		 * 
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * Explicit waits : Explicit waits are used to halt the execution until the time
		 * a particular condition is met or the maximum time has elapsed. Unlike
		 * Implicit waits, Explicit waits are applied for a particular instance only.
		 * 
		 */
		WebElement element = driver.findElement(By.id("i"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		// eg. of expected conditions
		ExpectedConditions.presenceOfElementLocated((By) element);
		ExpectedConditions.visibilityOfElementLocated((By) element);
		ExpectedConditions.invisibilityOfElementLocated((By) element);
		ExpectedConditions.visibilityOf(element);
		ExpectedConditions.alertIsPresent();

		/*
		 * Fluent wait: The frequency with which FluentWait has to check the conditions
		 * defined. Ignore specific types of exception waiting such as
		 * NoSuchElementExceptions while searching for an element on the page. The
		 * maximum amount of time to wait for a condition
		 * 
		 * WebDriverWait is a subclass of FluentWait. In FluentWait you have more
		 * options to configure, along with maximum wait time, like polling interval,
		 * exceptions to ignore etc.
		 */

		// 4.How to mouse hover sub-menu and click the element?
		WebElement subMenu = driver.findElement(By.id("1"));
		Actions actions = new Actions(driver);
		actions.moveToElement(subMenu);
		actions.build().perform();
		element.click();

		// 5.How to drag and drop the element?
		WebElement source = driver.findElement(By.id("1"));
		WebElement target = driver.findElement(By.id("2"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target);

		// 6.How to handle drop-down and how to print all the elements present in a
		// drop-down?
		WebElement dropDown = driver.findElement(By.id("1"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("text");

		List<WebElement> list = select.getOptions();
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}

		// 7.How to handle authentication pop up?
		String url = "http://Username:Password@SiteURL";
		driver.get(url);

		// 8.How to take a screenshot?
		File source1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source1, new File("./Screenshots/Screen.png"));

		
		//9.handle hidden element
		// MAKE HIDDEN ELEMENTS VISIBLE AT RUNTIME
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", element);

		// 10.Scroll web page--. SCROLL WEB PAGE UNTIL IT IS VISIBLE

		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
}