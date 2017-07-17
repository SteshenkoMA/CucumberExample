package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions extends DriverManager
{
  public Actions() {}
  
  public void searchText(String searchString)
  {
    driver.findElement(By.id("lst-ib")).sendKeys(new CharSequence[] { searchString });
    driver.findElement(By.id("_fZl")).click();
  }
  
  public void downloadPicture() {
    try {
      String s = driver.findElement(By.xpath("//*[@alt='stocksgui']")).getAttribute("src");
      URL url = new URL(s);
      BufferedImage bufImgOne = ImageIO.read(url);
      ImageIO.write(bufImgOne, "png", new File("test.png"));
    }
    catch (Exception e) {
      System.out.println("Failed to download/write picture " + e);
      Assert.fail();
    }
  }
  
  public void deletePicture()
  {
    try {
      File file = new File("test.png");
      
      if (!file.delete())
      {

        System.out.println("Delete operation is failed.");
        Assert.fail();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      Assert.fail();
    }
  }
  
  public boolean isGooglePageOpened() {
    String title = driver.getTitle();
    Assert.assertEquals("Wrong title", "Google", title);
    
    return true;
  }
  
  public boolean isResultsFound() {
    String result = driver.findElement(By.id("resultStats")).getText();
    Assert.assertTrue("results not found", Integer.parseInt(result.split(" ")[1].replace(",", "")) > 1);
    
    return true;
  }
  
  public boolean isLinkOpened() {
    driver.findElement(By.xpath("//a[.='SteshenkoMA (Steshenko Maxim) · GitHub']")).click();
    String title = driver.getTitle();
    Assert.assertEquals("Wrong title", "https://github.com/SteshenkoMA - Google Search", title);
    
    return true;
  }
  
  public boolean isRepositorioesOpened() {
    driver.findElement(By.xpath("//*[@href='/SteshenkoMA?tab=repositories']")).click();
    String title = driver.getTitle();
    Assert.assertEquals("Wrong title", "SteshenkoMA (Steshenko Maxim) / Repositories · GitHub", title);
    
    return true;
  }
  
  public boolean isFinalPageOpened(String text)
  {
    driver.findElement(By.xpath("//*[@href='/SteshenkoMA/" + text + "']")).click();
    String title = driver.getTitle();
    Assert.assertEquals("Wrong title", "GitHub - SteshenkoMA/StockDownloader: A program that downloads and displays stocks from finance.yahoo.com", title);
    
    return true;
  }
  
  public boolean isPictureDownloaded() {
    downloadPicture();
    Assert.assertTrue("File is not downloaded", new File("test.png").exists());
    
    return true;
  }
  
  public boolean isPictureDeleted() {
    deletePicture();
    java.nio.file.Path path = java.nio.file.Paths.get("test.png", new String[0]);
    Assert.assertTrue("File is not deleted", java.nio.file.Files.notExists(path, new java.nio.file.LinkOption[0]));
    
    return true;
  }
}
