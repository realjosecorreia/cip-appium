package steps;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;    // Trocamos de junit.After para cucumber.java.After
import io.cucumber.java.Before; // Trocamos de junit.Before para cucumber.java.Before
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Calcular {
	// Declaração do objeto do Appium
	private AndroidDriver<MobileElement> driver;
	public DesiredCapabilities desiredCapabilities;
	public URL remoteUrl; 
	
	// Inicializar as configurações
	@Before // Antes de cada teste
	  public void setUp() throws MalformedURLException {
		
		// Valores para ambiente
		// LE - Emulador Local
		// LF - Dispositivo Físico Local
		// SE - Emulador no Sauce Labs
		// SF - Dispositivo Físico no Sauce Labs
		
		String ambiente = "LE";
				
		desiredCapabilities = new DesiredCapabilities();
		/*
		switch(ambiente) {
			case "SE":	
				// Configurações do Appium Desktop / Sauce labs
			   
			    desiredCapabilities.setCapability("platformName", "Android");
			    desiredCapabilities.setCapability("platformVersion", "9.0");
			    desiredCapabilities.setCapability("browserName", "");
			    // desiredCapabilities.setCapability("appiumVersion", "1.22.0"); // execução local
			    desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
			    desiredCapabilities.setCapability("deviceOrientation", "portrait");
			    desiredCapabilities.setCapability("app", "storage:filename=Calculator_v8.1 (403424005)_apkpure.com.apk");
			    desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
			    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
			    desiredCapabilities.setCapability("nativeWebScreenshot", true);
			    desiredCapabilities.setCapability("newCommandTimeout", 0);
			    desiredCapabilities.setCapability("connectHardwareKeyboard", true);
			    
				// Endereço do Appium ou Sauce labs
			    remoteUrl = new URL("https://dh05jose:29904e23-877d-45d2-a36b-09bfc5de8709@ondemand.us-west-1.saucelabs.com:443/wd/hub");
			   break;
			case "LE":
			*/
				// Configurações do Appium Desktop / Local
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "11.0");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    // desiredCapabilities.setCapability("browserName", "");
	    desiredCapabilities.setCapability("appiumVersion", "1.20.2"); // execução local
	    //desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
	    desiredCapabilities.setCapability("deviceOrientation", "portrait");
	    //desiredCapabilities.setCapability("app", "storage:filename=Calculator_v8.1 (403424005)_apkpure.com.apk");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("newCommandTimeout", 0);
	    desiredCapabilities.setCapability("connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    
	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		/*	    
			    break;
		}
        */
	    
	    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		// Tempo de Paciência - Espera Implicita - Espera até um certo tempo pelo elemento
	    driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		
		
	  }
	
	  @After // Após o teste
	  public void tearDown() {
	    driver.quit(); // quit: destruir o objeto do Appium 
	                    // close: coloca em stand by
	  }

	//@Given("^que acesso a calculadora$") // versão antiga do info.cukes
	@Given("que acesso a calculadora")   // versão nova do cucumber.io
	public void que_acesso_a_calculadora() throws MalformedURLException {
		// ToDo: Voltar o código para o Given
	}

	// @When("^clico no botao \"([^\"]*)\"$") // versão antiga do info.cukes
	@When("clico no botao {string}")
	public void clico_no_botao(String botao) {
	    System.out.println("O botao eh: " + botao);
		switch (botao){
		
		case "0":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn0 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_0");
		    btn0.click();
		    break;
		
		case "1":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
		    btn1.click();
		    break;
		
		case "2":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
		    btn2.click();
		    break;
		    
		case "3":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
		    btn3.click();
		    break;
		    
		case "4":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
		    btn4.click();
		    break;
		
		case "5":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn6 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_5");
		    btn6.click();
		    break;
		    
		case "6":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_6");
		    btn5.click();
		    break;
		    
		case "7":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn7 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
		    btn7.click();
		    break;
		    
		case "8":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn8 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
		    btn8.click();
		    break;
		    
		case "9":
			// Declara o botão como um MobileElement e associa ele com um elemento através do Id
			MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
		    btn9.click();
		    break;
		    
		case "+":   
		    // Para as operações ele utilizou o AccessibilityId
			MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
		    btnSomar.click();
		    break;
		
		case "-":   
		    // Para as operações ele utilizou o AccessibilityId
			MobileElement btnSubtrair = (MobileElement) driver.findElementByAccessibilityId("minus");
		    btnSubtrair.click();
		    break;
		    
		case "*":   
		    // Para as operações ele utilizou o AccessibilityId
			MobileElement btnMultiplicar = (MobileElement) driver.findElementByAccessibilityId("multiply");
		    btnMultiplicar.click();
		    break;
		    
		case "/":   
		    // Para as operações ele utilizou o AccessibilityId
			MobileElement btnDividir = (MobileElement) driver.findElementByAccessibilityId("divide");
		    btnDividir.click();
		    break;
		    
		case "=":   
		    // Para as operações ele utilizou o AccessibilityId
			MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
		    btnIgual.click();
		    break;
		}

		
	}

	// @Then("^exibe o resultado como \"([^\"]*)\"$") // versão antiga do info.cukes
	@Then("exibe o resultado como {string}")
	public void exibe_o_resultado_como(String resultadoEsperado) {
		MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
	    assertEquals(resultadoEsperado,lblResultado.getText()); // Agora sim é um teste!!!
	}
	
}
