import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

public class ValidarRegrasNegocio {

	@Test
	public void verificarNomeObrigatior() {
		
		//Arrange
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TargetUrl url = new TargetUrl();
		driver.get(url.getUrl());
		
		//Act
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		
		//Assert
		
		assertEquals("Nome eh obrigatorio",alert.getText());
		alert.accept();
		
		//End	
	}
	@Test
	
	public void verificarSobrenomeObrigatorio() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TargetUrl url = new TargetUrl();
		driver.get(url.getUrl());
		
		//Act
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("José");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		
		//Assert
		
		assertEquals("Sobrenome eh obrigatorio",alert.getText());
		alert.accept();
		
		//End	
	}
	
	@Test
	
	public void verificaSexoObrigatorio() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TargetUrl url = new TargetUrl();
		driver.get(url.getUrl());
		
		//Act
		driver.findElement(By.id("elementosForm:nome")).sendKeys("José");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Maciel");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		
		//Assert
		
		assertEquals("Sexo eh obrigatorio",alert.getText());
		alert.accept();
		
		//End	

	}
	@Test
	
	public void verificaVegetariano() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TargetUrl url = new TargetUrl();
		driver.get(url.getUrl());
		
		//Act
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("José");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Maciel");
		driver.findElement(By.id("elementosForm:sexo:0")).click(); //masculino
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();//carne
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();//vegetariano
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		
		//Assert
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

	}
	@Test
	
	public void verificaEsportes() {
		
		//Arrange

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TargetUrl url = new TargetUrl();
		driver.get(url.getUrl());
		
		//Act
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("José");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Maciel");
		driver.findElement(By.id("elementosForm:sexo:0")).click(); //masculino
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();//carne
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		
		//Assert
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());

	}
}
