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
		String textoAlert = alert.getText();
		Assert.assertEquals("Alert Simples", textoAlert);
		alert.accept();
			
		//Assert
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);
		driver.quit();
	}
	
	@Test
	
	
	public void DeveInteragirComConfirm() {
		
		//Arrange
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		WebElement btnConfirm = driver.findElement(By.id("confirm"));
		btnConfirm.click();
		Alert confirm = driver.switchTo().alert();
		String confirmMessage = confirm.getText();
		Assert.assertEquals("Confirm Simples", confirmMessage);
		confirm.accept();
		confirmMessage = confirm.getText();
		Assert.assertEquals("Confirmado", confirmMessage);
		confirm.dismiss();
		
		btnConfirm.click();
		confirm = driver.switchTo().alert();
		confirm.dismiss();
		confirmMessage = confirm.getText();
		Assert.assertEquals("Negado", confirmMessage);
		
		//Assert
		
		driver.quit();

	}
	
	@Test
	
	public void DeveInteragirComPrompt() {

		//Arrange
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Act
		
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		WebElement btnConfirm = driver.findElement(By.id("prompt"));
		btnConfirm.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		//Assert
		
		driver.quit();

	}
}
