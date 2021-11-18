package calculadora;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Calc {

  private AndroidDriver<MobileElement> driver;

  @Before
  public void setUp() throws MalformedURLException {
	  
	
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
  
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

    URL remoteUrl = new URL("https://dh05jose:29904e23-877d-45d2-a36b-09bfc5de8709@ondemand.us-west-1.saucelabs.com:443/wd/hub");
    
    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

  }

  @Test
  public void somarDoisNumeros() {
    MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
    btn9.click();
    MobileElement btnSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
    btnSomar.click();
    MobileElement btn4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
    btn4.click();
    MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
    btnIgual.click();
    MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
    
    assertEquals("13",lblResultado.getText()); // Agora sim é um teste!!!
    // lblResultado.click();
    
    // MobileElement btnSubtrair = (MobileElement) driver.findElementByAccessibilityId("minus");
    // MobileElement btnMultiplicar = (MobileElement) driver.findElementByAccessibilityId("multiply");
    // MobileElement btnDividir = (MobileElement) driver.findElementByAccessibilityId("divide");

  }

  @After
  public void tearDown() {
    driver.quit();
  }
}

