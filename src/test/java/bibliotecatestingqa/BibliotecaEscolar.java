package bibliotecatestingqa;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BibliotecaEscolar {
	
	WebDriver driver;
	By botonRegistroLocator=By.linkText("Registro");
	By PaginaRegistro=By.className("card-header");
	
	/*variables de registro*/
	
	By nombre=By.id("nombre");
	By apellido=By.id("apellidos");
	By email=By.id("email");
	By telefono=By.id("telefono");
	By contraseña=By.id("password");
	By registrarse=By.linkText("Registrarte");
	By cancelar=By.linkText("Cancelar");
	By mensaje=By.id("msg");
	By panel=By.xpath("/html/body/nav/div/a");
	By botonlogin=By.linkText("Login");
	By mensajelogin=By.xpath("/html/body/div/div/div[2]/div[2]/div/div/h5");
	By correologin=By.xpath("//*[@id=\"email\"]");
	By contraseñalogin=By.xpath("//*[@id=\"password\"]");
	By botonsesion=By.linkText("Iniciar sesion");
	By mensajebienvenido=By.xpath("//*[@id=\"msg\"]/div");
	By bregistrarse=By.xpath("/html/body/div/div/div[2]/div[2]/div/div/a[2]");
	
	@BeforeClass
	  public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver1/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://bibliotecaqa.s3-website-us-east-1.amazonaws.com/");
		
	  }

	
	  @Test
	  
	  /*cancelar registro*/

	  public void cancelarregistrousuario() throws InterruptedException {
	  	  driver.findElement(botonRegistroLocator).click();
	  	  Thread.sleep(2000);
	  	  if(driver.findElement(PaginaRegistro).isDisplayed()) {
	  		  
	  		 driver.findElement(nombre).sendKeys("Ruben");
	  		 driver.findElement(apellido).sendKeys("Amaya");
	  		 driver.findElement(email).sendKeys("rquimbayo@enigmadev.com");
	  		 driver.findElement(telefono).sendKeys("3122978644");
	  		 driver.findElement(contraseña).sendKeys("Ma123@");
	  		 
	  		 driver.findElement(cancelar).click();
	  		
	  		 assertTrue(driver.findElement(panel).isDisplayed());
	  		  Thread.sleep(2000);
	  		 
	  		 
	  		  
	  	  }
	  	 
	  	  
	  }
	
  @Test
  
  /* Registro usuario*/
 
  public void registrousuario() throws InterruptedException {
	  driver.findElement(botonRegistroLocator).click();
	  Thread.sleep(20000);
	  if(driver.findElement(PaginaRegistro).isDisplayed()) {
		  
		 driver.findElement(nombre).sendKeys("Malory");
		 driver.findElement(apellido).sendKeys("Quimbayo");
		 driver.findElement(email).sendKeys("mquimbayo@enigmadev.com");
		 driver.findElement(telefono).sendKeys("3122978643");
		 driver.findElement(contraseña).sendKeys("Ma123@");
		 
		 driver.findElement(registrarse).click();
		
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		  Thread.sleep(1000);
		 
		 
		  
	  }
	 
	  
  }
  
  @Test

  /*Inicio sesion datos correctos*/

  public void iniciosesiondatoscorrectos() throws InterruptedException {
  	  driver.findElement(botonlogin).click();
  	  Thread.sleep(2000);
  	  if(driver.findElement(mensajelogin).isDisplayed()) {
  		  
  		  driver.findElement(correologin).sendKeys("mquimbayo@gmail.com");
  		  driver.findElement(contraseñalogin).sendKeys("Ma123@");
  		 driver.findElement(botonsesion).click();
  		
  		 assertTrue(driver.findElement(mensajebienvenido).isDisplayed());
  		  Thread.sleep(2000);
  		 
  		 
  		  
  	  }
  	 
  	  
  }
  
  @Test
  
  /*validando campos obligatorios*/
  
  public void registrousuarioobligatorio() throws InterruptedException {
	  driver.findElement(botonRegistroLocator).click();
	  Thread.sleep(2000);
	  if(driver.findElement(PaginaRegistro).isDisplayed()) {
		  
		 driver.findElement(nombre).sendKeys("");
		 driver.findElement(registrarse).click(); 
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		 driver.findElement(nombre).sendKeys("Rosalba");
		 driver.findElement(registrarse).click();
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		 driver.findElement(apellido).sendKeys("Maya");
		 driver.findElement(registrarse).click();
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		 driver.findElement(email).sendKeys("rosalbamaya1245@gmail.com");
		 driver.findElement(registrarse).click(); 
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		 driver.findElement(telefono).sendKeys("3122586456");
		 driver.findElement(registrarse).click(); 
		 assertFalse(driver.findElement(mensaje).isDisplayed());
				 
	  }
	 
	  
  }
  
  
 @Test
  /*validación caracteres*/
 
  public void validandocaracteres() throws InterruptedException {
	  driver.findElement(botonRegistroLocator).click();
	  Thread.sleep(2000);
	  
	  if(driver.findElement(PaginaRegistro).isDisplayed()) {
		  driver.findElement(nombre).sendKeys("Fernando1245");
		  driver.findElement(apellido).sendKeys("Fern1");
		  driver.findElement(email).sendKeys("malorygmail.com");
		  driver.findElement(telefono).sendKeys("3115567789684a");
		  driver.findElement(contraseña).sendKeys("Malorymay");
		  driver.findElement(registrarse).click();

			 
		  
			  WebElement idn = driver.findElement(nombre);			  
				 String texto=idn.getText();
				 assertEquals(10, texto.length()<=10);
				 assertEquals(3, texto.length()==3);
				 
				 
				 for (int x = 0; x < texto.length(); x++) {
					 char c=texto.charAt(x);
					 
					 if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
				        }
				 }
				
				WebElement ida = driver.findElement(apellido);			  
					 String texto1=ida.getText();
					 assertEquals(10, texto1.length()<=10);
					 assertEquals(3, texto1.length()==3);
					 
					 
					 for (int i = 0; i < texto1.length(); i++) {
						 char c1=texto.charAt(i);
						 
						 if (!((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z') || c1 == ' ')) {
					        }
					 }
					 
					 Pattern pattern = Pattern
				                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
					 Matcher mather = pattern.matcher((CharSequence) email);
					 
					 if (mather.find() == true) {
				            System.out.println("El email ingresado es válido.");
				        } else {
				            System.out.println("El email ingresado es inválido.");
				        }
					 
					 WebElement idt = driver.findElement(telefono);			  
					 String texto2=idt.getText();
					 assertEquals(12, texto2.length()<=12);
					 assertEquals(10, texto2.length()==10);
					 
					 for (int t = 0; t < texto2.length(); t++) {
						 char c2=texto2.charAt(t);
						 
						 if (c2 >= 0 && c2 <= 9) {
							 System.out.println("es valido");
					        }
					 }
					 
					 WebElement idcc = driver.findElement(contraseña);			  
					 String texto3=idcc.getText();
					 assertEquals(20, texto3.length()<=20);
					 assertEquals(8, texto3.length()==8);
					 
					 for (int j = 0; j < texto3.length(); j++) {
						 char c3=texto3.charAt(j);
						 String passValue = String.valueOf(c3);
						 
						 if (passValue.matches("[A-Z]")) {
			                    int contLetraMay = 0;
								contLetraMay++;
			                } else if (passValue.matches("[a-z]")) {
			                    int contLetraMin = 0;
								contLetraMin++;
			                } else if (passValue.matches("[0-9]")) {
			                    int contNumero = 0;
								contNumero++;
			                }
						 
						
					 }
					 
					 
	  }
	    
 
	  
  }
 
 @Test
 
 /*Inicio sesion nulo*/

 public void iniciosesionnulos() throws InterruptedException {
	  driver.findElement(botonlogin).click();
	  Thread.sleep(2000);
	  if(driver.findElement(mensajelogin).isDisplayed()) {
		 
		 driver.findElement(botonsesion).click();
		
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		  Thread.sleep(2000);
		 
		 
		  
	  }
	 
	  
 }
 
@Test
 
 /*Inicio sesion email nulo*/

 public void iniciosesioemailnulo() throws InterruptedException {
	  driver.findElement(botonlogin).click();
	  Thread.sleep(2000);
	  if(driver.findElement(mensajelogin).isDisplayed()) {
		  
		  driver.findElement(correologin).sendKeys("");
		  driver.findElement(contraseñalogin).sendKeys("123");
		 driver.findElement(botonsesion).click();
		
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		  Thread.sleep(2000);
		 
		 
		  
	  }
	 
	  
 }
@Test

/*Inicio sesion contraseña nulo*/

public void iniciosesiocontraseñalnulo() throws InterruptedException {
	  driver.findElement(botonlogin).click();
	  Thread.sleep(2000);
	  if(driver.findElement(mensajelogin).isDisplayed()) {
		  
		  driver.findElement(correologin).sendKeys("mquimbayo@enigmadev.com");
		  driver.findElement(contraseñalogin).sendKeys("");
		 driver.findElement(botonsesion).click();
		
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		  Thread.sleep(2000);
		 
		 
		  
	  }
	 
	  
}
@Test

/*Inicio sesion datos incorrectos*/

public void iniciosesiondatosincorrectos() throws InterruptedException {
	  driver.findElement(botonlogin).click();
	  Thread.sleep(2000);
	  if(driver.findElement(mensajelogin).isDisplayed()) {
		  
		  driver.findElement(correologin).sendKeys("aparras@gmail.com");
		  driver.findElement(contraseñalogin).sendKeys("123");
		 driver.findElement(botonsesion).click();
		
		 assertTrue(driver.findElement(mensaje).isDisplayed());
		  Thread.sleep(2000);
		 
		 
		  
	  }
	 
	  
}


@Test

/*Ingreso a interfaz registro desde login*/

public void ingresoregistrousuariologin() throws InterruptedException {
	  driver.findElement(botonlogin).click();
	  Thread.sleep(2000);
	  if(driver.findElement(mensajelogin).isDisplayed()) {
		  
		 driver.findElement(bregistrarse).click();
		
		 assertTrue(driver.findElement(PaginaRegistro).isDisplayed());
		  Thread.sleep(2000);
		 
		 
		  
	  }
	 
	  
}
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
