package automationScript;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTotalOrders {
	
	WebDriver driver;
	String URL = "https://demo.opencart.com/admin/index.php";
	
	@Before
	public void Initialize() {
		driver = new ChromeDriver();
		driver.navigate().to(URL);
	}
	
	@Test
	public void TestRun() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.xpath(" //input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		//WebElement submit = driver.findElement(By.className("btn btn-primary"));
		submit.click();		
		
		Thread.sleep(2000);
       
		WebElement TotalOrders = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]"));
		String verifyorders = TotalOrders.getText();
		System.out.println(verifyorders);
		
		WebElement viewmore = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]"));
		viewmore.click();
	}
	
	@After
	public void TearDown() {
		driver.quit();
	}
	


}
