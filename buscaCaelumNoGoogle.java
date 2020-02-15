import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class buscaCaelumNoGoogle {

	@Test
	public void AbrirChrome() {
		
		//Arrange
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		driver.get("https://www.google.com/");
		
		
		//Assert
		assertEquals("Google", driver.getTitle());
		driver.quit();

		
			
		}
	@Test
	public void buscaCaelum() {
		
				//Arrange
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				//Act
				
				driver.get("https://www.google.com/");
				WebElement elementSearchBar = driver.findElement(By.name("q"));
				elementSearchBar.sendKeys("Caelum");
				elementSearchBar.submit();
			
				//Assert
				
				driver.quit();
	}

	
		
}


