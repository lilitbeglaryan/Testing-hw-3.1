
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Assert.*;
import org.testng.annotations.Test;


public class WebDriverBasics {
  public static  WebDriver driver;
  public static String baseURL = "https://www.facebook.com/";

  @BeforeSuite
  public static void WebDriverBasics(){
    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.get(baseURL);
  }

  @Test
  public void header() {
    WebElement header = driver.findElement(By.className("_8eso"));
    System.out.println(header);
    Assert.assertEquals("Facebook helps you connect and share with the people in your life.",header.getText());

  }

  @Test
  public void title() {
    WebElement title = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div[1]/div/img"));
    System.out.println(title);
    Assert.assertEquals("Facebook",title.getAttribute("alt"));
  }


  @Test
  public void login() {
    WebElement email = driver.findElement(By.id("email"));
    System.out.println(email);
    Assert.assertEquals("Email address or phone number",email.getAttribute("placeholder"));
//
    email.click();
    email.sendKeys("bla@gmail.com");

    WebElement password = driver.findElement(By.cssSelector("input.inputtext._55r1._6luy._9npi"));
    System.out.println(password);
    Assert.assertTrue(password.getAttribute("name").contains("pass"));

    password.click();
    password.sendKeys("123");
    password.sendKeys(Keys.ENTER);

    WebElement errorWindow = driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[5]"));
    Assert.assertEquals("We couldn't find an account that matches what you entered, but we've found one that closely matches.",errorWindow.getText());


  }
  @AfterSuite
  public void exit(){
    driver.quit();
  }

}


//  public WebElement findSearchBar(){
//    WebElement searchBar;
//    try {
//      searchBar= this.driver.findElement(By.id("idSearchBox"));  // search bar
//      System.out.print(this.driver.getTitle());
////      searchBar.click();
////      searchBar.sendKeys("Parfume for women");
////      searchBar.sendKeys(Keys.ENTER);
////      assert
//
//    }
//    catch(NoSuchElementException e){
//      System.out.println(e.getMessage());
//      return null;
//    }
//    return searchBar;
//  }

  //  public WebElement find(){
//    try {
//      WebElement searchBar= this.driver.findElement(By.id("idSearchBox"));  // search bar
//    }
//    catch(NoSuchElementException e){
//      print(e.getMessage());
//      return null;
//    }
//    return searchBar;
//  }
//  public static void main(String[] args){
//    SUTDriver dr = new SUTDriver();
//    dr.navigateToSUT();
//
//  }
//
//}




//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class WebDriverBasics {
//  private WebDriver driver;
//
//  @BeforeTest
//  public void setUp() {
//    // Set the path to the ChromeDriver executable
//
//    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//
//    // Create a new instance of the ChromeDriver
//
//
//    ChromeOptions chromeOptions = new ChromeOptions();
//    chromeOptions.addArguments("--start-maximized");
//    chromeOptions.addArguments("--remote-allow-origins=*");
//    driver = new ChromeDriver(chromeOptions);
////    return new ChromeDriver(chromeOptions);
//    // Navigate to the Google homepage
//    driver.get("https://www.google.com");
//  }
//  @Test
//  public void searchTest() {
//    // Find the search box element
//    WebElement searchBox = driver.findElement(By.name("q"));
//
//    // Enter the search keyword
//    searchBox.sendKeys("Selenium");
//
//    // Submit the search form
//    searchBox.submit();
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//    // Wait for the search results to load
//    WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".g .r a")));
//    // Verify that the first search result contains the search keyword
//    Assert.assertTrue(firstResult.getText().toLowerCase().contains("selenium"));
//  }
//  @AfterTest
//  public void tearDown() {
//    // Close the browser
//    driver.quit();
//  }
//}