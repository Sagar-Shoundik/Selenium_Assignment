package Internshala;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearch {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
		
		driver.manage().window().maximize();
		searchBox.sendKeys("Wrist Watches");
		driver.findElement(By.className("nav-search-submit")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("brandsRefinements")));
	
		// Apply Filters
		
		
		driver.findElement(By.xpath("//span[text()='Titan']")).click();
		driver.findElement(By.xpath("//span[text()='25% Off or more']")).click();
		driver.findElement(By.xpath("//span[text()='Leather']")).click();
		driver.findElement(By.xpath("//span[text()='Analogue']")).click();
		
		WebElement searchResults = driver.findElement(By.cssSelector(".s-result-list"));
		if(searchResults.findElements(By.cssSelector(".s-result-item")).size() > 0)
		{
			WebElement fifthElement = searchResults.findElements(By.cssSelector(".s-result-item")).get(5);
			System.out.println(fifthElement.getText());
		}
		else
		{
			System.out.println("Search result dont have atleast 5 elements.");
		}
		
		driver.quit();
	}

}
