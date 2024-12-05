package StepDefinations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Payment {
	
	WebDriver driver = null;
	
	@Given("user open the flipcarkt")
	public void user_open_the_flipcarkt() {
	    // Write code here that turns the phrase above into concrete actions
		
		System.getProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("sachinrathod6165@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Sachin@6165");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@When("User selected some product and adds to cart")
	public void user_selected_some_product_and_adds_to_cart() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung s23");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@id='nav-cart']//span")).click();
		driver.findElement(By.xpath("//input[@value='Proceed to checkout']")).click();
		System.out.println("Hello 111 %%%%%%%%%%%%%%%%%%%%%%");
	//	driver.findElement(By.xpath("//span[@id='add-new-address-desktop-sasp-tango-link']")).click();
		System.out.println("Hello 2222 %%%%%%%%%%%%%%%%%%%%%%");
	}
	
	
	
	@When("user clicks on payments options")
	public void user_clicks_on_payments_options() throws InterruptedException {
		
	//	driver.findElement(By.xpath("//input[@value='SelectableAddCreditCard']")).click();
	//	driver.findElement(By.xpath("//a[text()='Enter card details']")).click();
		System.out.println("Hello 333 %%%%%%%%%%%%%%%%%%%%%%");
		driver.findElement(By.xpath("//input[@value='SelectableAddCreditCard']")).click();
		driver.findElement(By.xpath("//a[text()='Enter card details']")).click();
		driver.switchTo().frame("ApxSecureIframe");
		driver.findElement(By.xpath("//input [@name='addCreditCardNumber']")).sendKeys("8175091011691087");
		
		
	
		driver.findElement(By.xpath("//span[@data-action='a-dropdown-button' and @role='button']/span[text()='01']")).click();
		
		driver.findElement(By.xpath("//a[text()='07']")).click();
		
		
		
	//	driver.switchTo().frame("apx-secure-field-addCreditCardVerificationNumber");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@data-action='a-dropdown-button' and @role='button']/span[text()='2024']")).click();
		driver.findElement(By.xpath("//a[text()='2028']")).click();
		
		driver.findElement(By.xpath("//input[@name='ppw-widgetEvent:AddCreditCardEvent']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().frame("apx-secure-field-addCreditCardVerificationNumber");
		
		driver.findElement(By.xpath("//input[@class='card-cvv']")).sendKeys("123");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@id='checkout-secondary-continue-button-id']//span")).click();
		
		
//		driver.switchTo().frame("secureDataHandler");
		driver.findElement(By.xpath("//span[text()='Continue without saving']")).click();
//		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@name='placeYourOrder1'])[3]")).click();
		
		/*
		 * driver.findElement(By.xpath("//input[@value='SelectableAddCreditCard']")).
		 * click(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("(//a[text()='Enter card details'])[1]")).click()
		 * ;
		 * 
		 * driver.findElement(By.
		 * xpath("//span[@id='pp-OxcO5J-3']//span[@data-action='a-dropdown-button' and @role='button']"
		 * )).click(); driver.switchTo().defaultContent();
		 */
		
		
	//	driver.findElement(By.xpath("//a[@id='prime-interstitial-nothanks-button']")).click();
	//	driver.findElement(By.xpath("//span[@id='submitOrderButtonId']")).click();

	}
	@Then("user navigates to OTP screen.")
	public void user_navigates_to_otp_screen() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='otpValue']"))));
		  
		boolean otpScreen = driver.findElement(By.xpath("//input[@id='otpValue']")).isDisplayed();
		
		if(otpScreen==true) {
			System.out.print("OTP screen displayed");
		}else {
			System.out.print("OTP screen is not displayed");
		}


	}


}
