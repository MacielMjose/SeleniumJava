import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;



public class testesJavascript {

	@Test
	public void DeveInteragirComAlertSimples() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		WebElement btnAlert = driver.findElement(By.id("alert"));
		btnAlert.click();
		
		Alert alert = driver.switchTo().alert();
		String textoAlrt = alert.getText();
		Assert.assertEquals("Alert Simples", textoAlrt);
		alert.accept();
			
		//Assert
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlrt);
		driver.quit();
	}

}
