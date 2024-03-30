package Assignment.Practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Unit test for simple App.
 */
public class AppTest {
	WebDriver driver;
	
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"abcd", "1234"},
                {"xyzz", "1234"},
        };
    }

	@Test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://codenboxautomationlab.com/");
		
		System.out.println(driver.getTitle());
	
}
	 @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) {
	        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

	        driver = new ChromeDriver();

	        driver.get("https://codenboxautomationlab.com/wp-login.php");

	        System.out.println(driver.getTitle());

//	        WebElement loginbtn = driver.findElement(By.xpath("//*[@id='meta-4']/ul/li[1]/a"));
//
//	        loginbtn.click();

	        WebElement user = driver.findElement(By.name("log"));
	        user.sendKeys(username);

	        WebElement pass = driver.findElement(By.name("pwd"));
	        pass.sendKeys(password);

	        WebElement btn = driver.findElement(By.cssSelector("input[type='submit"));
	        btn.click();

	        System.out.println(driver.findElement(By.xpath("//*[@id='login_error']")).getText());
	        
	        driver.quit();
	    }
	
}

