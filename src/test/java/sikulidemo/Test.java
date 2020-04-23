package sikulidemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	static Screen screen = null;
	static Pattern pattern = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
//		driver.get("http://demowebshop.tricentis.com/");
		
		screen = new Screen();
		try {
//			clickBySikuli("register.PNG");
//			clickBySikuli("search.PNG");
//			sendKeysBySikuli("searchbox1", "look for store");
//			driver.get("http://demo.guru99.com/test/simple_context_menu.html");
//			doubleClickBySikuli("double.PNG");
			driver.manage().window().maximize();
			driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
			dragNdropBySikuli("drag1", "drop");
			dragNdropBySikuli("drag2", "drop");
			System.out.println("You clicked me");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void doubleClickBySikuli(String imagePath) {
		try {

			pattern = new Pattern(
					"C:\\Users\\Alkesh\\eclipse-workspace\\TheInternet\\src\\test\\resources\\img\\" + imagePath);
			screen.wait(pattern,20);
			screen.doubleClick(pattern);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in doubleClickBySikuli : " + e);
			System.out.println("Error for image : " + imagePath);
		}
	}
	public static void dragNdropBySikuli(String sourceImg,String destinationImg) {
		try {

			pattern = new Pattern(
					"C:\\Users\\Alkesh\\eclipse-workspace\\TheInternet\\src\\test\\resources\\img\\" + sourceImg);
		Pattern	drop = new Pattern(
					"C:\\Users\\Alkesh\\eclipse-workspace\\TheInternet\\src\\test\\resources\\img\\" + destinationImg);	
			screen.wait(pattern,20);
			
			screen.dragDrop(pattern, drop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in dragNdropBySikuli : " + e);
			System.out.println("Error for image : " + sourceImg+"\t"+destinationImg);
		}
	}
	public static void clickBySikuli(String imagePath) {
		try {

			pattern = new Pattern(
					"C:\\Users\\Alkesh\\eclipse-workspace\\TheInternet\\src\\test\\resources\\img\\" + imagePath);
			screen.wait(pattern,20);
			screen.click(pattern);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in clickBySikuli : " + e);
			System.out.println("Error for image : " + imagePath);
		}
	}

	public static void sendKeysBySikuli(String imagePath, String data) {
		try {
			pattern = new Pattern(
					"C:\\Users\\Alkesh\\eclipse-workspace\\TheInternet\\src\\test\\resources\\img\\" + imagePath);
			screen.wait(pattern,20);
			screen.type(pattern, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in sendKeysBySikuli : " + e);
			System.out.println("Error for image : " + imagePath);
		}
	}
}
