package test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverManager
{
  public static WebDriver driver;
  
  public DriverManager() {}
  
  public void openBrowser()
  {
    File pathToBinary = new File("/opt/firefox45/firefox");
    FirefoxBinary binary = new FirefoxBinary(pathToBinary);
    driver = new FirefoxDriver(binary, new FirefoxProfile());
    driver.get("https://www.google.com/ncr");
    driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
  }
  
  public void closeBrowser() {
    driver.quit();
  }
}
