package automationScript;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;

	public class verifyorder2 {

	    WebDriver driver;
	    String URL = "https://demo.opencart.com/admin/index.php";

	    @Before
	    public void Initialize() {
	        // Set the ChromeDriver path
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with actual path to chromedriver

	        // Initialize ChromeDriver and set an implicit wait
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for elements
	        driver.navigate().to(URL);
	    }

	    @Test
	    public void TestRun() {
	        // Login
	        WebElement username = driver.findElement(By.id("input-username"));
	        username.clear();
	        username.sendKeys("demo");

	        WebElement password = driver.findElement(By.id("input-password"));
	        password.clear();
	        password.sendKeys("demo");

	        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	        submit.click();

	        // Add an explicit wait for the dashboard to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	            // Wait for the element with class "tile" to appear (adjust if needed)
	        WebElement totalOrdersElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'tile')][1]//h2")));

	        wait.until(ExpectedConditions.visibilityOf(totalOrdersElement));

	            // Get the text of total orders
	            String totalOrdersText = totalOrdersElement.getText();
	            System.out.println("Total Orders: " + totalOrdersText);
	        }

	    @After
	    public void TearDown() {
	        // Close the browser after the test
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

