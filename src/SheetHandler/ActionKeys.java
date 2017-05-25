package SheetHandler;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

public class ActionKeys  {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static  String openBrowser(String browser) {	
		
		if(browser.equals("chrome")){
			
			try{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Repository\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();	
			
			}catch(Exception e)	{			
				return "Browser not Initailized";
			  }
			}
		return "Browser Initialized";  
	
	}
 
	public static String  URLnavigate(String path,String LocAction,String keys){
			
		try{
			driver.navigate().to(path);	
			
		}catch(Exception e){			
			return driver.getCurrentUrl();
		}
		return driver.getCurrentUrl();
			
	}
 
	
	public static String XPATHsendkeys(String path,String action,String key) {
	
		System.out.println("Sendkeys Invoked"+path);
		
		try{
		if(key.toLowerCase().equals("enter")){
		driver.findElement(By.xpath(path)).sendKeys(Keys.ENTER);
		return driver.findElement(By.xpath(path)).getAttribute("value");
		
		}else{
			driver.findElement(By.xpath(path)).sendKeys(key);
			return driver.findElement(By.xpath(path)).getAttribute("value");
			
		}
		}catch(Exception e){			
			return driver.findElement(By.xpath(path)).getAttribute("value");
		}
		
		
		
		
	}
 
	public static void input_Password(){
		driver.findElement(By.id("pwd")).sendKeys("Test@123");
		}
 
	public static String XPATHclick(String path,String action,String key){
	
		
		try{
			
			System.out.println(key);
		if(key.toLowerCase().equals("act")){
			
		
		System.out.println(key);
		driver.findElement(By.xpath(path)).click();	
		
		if(driver.getTitle()!=null){
		
		return driver.getCurrentUrl();
		
		}else{
			
			return driver.getCurrentUrl();
			
			}
		  }
		
		
		}catch(Exception e){
			
			return (e.getMessage());
			}
		return driver.getCurrentUrl();
		}
 
	public static String XPATHwaitfor(String path,String action,String key) {
		
		try{
		
		wait = new WebDriverWait(driver,10000);
		System.out.println("Inside XPATHWait"+action);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		
		
		}catch(Exception e){
			
			return (e.getMessage());
		}
		return "Element appeared";
		}
	
	public static String CSSwaitfor(String path,String action,String key) throws Exception{
		
		try{
			
			System.out.println("Inside CSSWait");
		wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		
		
		}catch(Exception e){
			
			return (e.getMessage());
			
		}
		
		return "Element appeared";
	}
 

	
	
	public static String CSSSendkeys(String path,String action,String key){
		
		
		try{
		if(key.toLowerCase().equals("enter")){
		driver.findElement(By.cssSelector(path)).sendKeys(Keys.ENTER);
		
		}else{
			driver.findElement(By.xpath(path)).sendKeys(key);
		}
		}catch(Exception e){
			
			return (e.getMessage());
			
		}
		return "Key Sent:"+key;
		
		
		
		
	}
	
	
	public static boolean CSSClick(String path,String action,String key){
		
		if(key.toLowerCase().equals("validate")){
		System.out.println("Click invoked");
		System.out.println(key);
		driver.findElement(By.cssSelector(path)).click();	

	//This will be pushed in the sheet as a validation	
		
		if(driver.getTitle()!=null){
			
		System.out.println(driver.getTitle());
		
		}else{
			
			System.out.println(driver.getCurrentUrl());
			
			}
		 }
		return true;
		
	}
 
	
	
	public static String CSSelementdisplayed(String path,String action,String key){
		
		
		try{			
			driver.findElement(By.cssSelector(path)).isDisplayed();			
			return "Element displayed";			
		}catch(Exception e ){
						
			return (e.getMessage());
		}
			
		}
		
		
		
		public static String XPATHelementdisplayed(String path,String action,String key){
			
			
			try{			
				driver.findElement(By.xpath(path)).isDisplayed();			
				return "Element displayed";			
			}catch(Exception e ){
							
				return (e.getMessage());
				
			}
		
		
			
		}
		
			
	public static String NAnavigateback(String path,String action,String key){
		
		
	try{
		
		
		if(path.trim().equals("NA")){
			
			driver.navigate().back();
			
		}else if(!path.equals("NA")||(!path.equals(null))) {
			
			driver.navigate().to(path);
			
		}
		
	}catch(Exception e){
		
		return (e.getMessage());
		
	}
		
		
		return "Navigated back successfuly";
		
	}
		
		
		
		
		
	
	
	
	
	
	
	public static void closeBrowser(){
			driver.quit();
		}
 
	}
	
	
	
	