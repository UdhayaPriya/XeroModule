package XeroModule;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Module extends ReusableMethods {
			
	public static void launchHomepage() throws IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/launchHomepage.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		 
		 String url = rec_data[1][1];
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize(); 
		
	}
	
	public static void login() throws IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/login.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		String email, pwd;
		
		email = rec_data[1][1];
		pwd = rec_data[1][2];
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		enterText (driver.findElement(By.xpath(".//*[@id='email']")), email, "Email address");
		enterText (driver.findElement(By.xpath(".//*[@id='password']")), pwd, "Password");
		clickButton(driver.findElement(By.xpath(".//*[@id='submitButton']")), "Login");

	}
	
	public static void loginErrorPwd() throws IOException, InterruptedException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/loginErrorPwd.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		String expectedErrMsg, email, pwd;
		email = rec_data[1][1];
		pwd = rec_data[1][2];
		expectedErrMsg = rec_data[1][3];
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		enterText (driver.findElement(By.xpath(".//*[@id='email']")), email, "Email address");
		enterText (driver.findElement(By.xpath(".//*[@id='password']")), pwd	, "Password");
		clickButton(driver.findElement(By.xpath(".//*[@id='submitButton']")), "Login");
		
		String actualErrMsg = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText().trim();
		validateErrorMsg (expectedErrMsg , actualErrMsg );
		
	}
	
	public static void loginErrorUser() throws IOException, InterruptedException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/loginErrorUser.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		String expectedErrMsg, email, pwd;
		
		expectedErrMsg = rec_data[1][3];
		email = rec_data[1][1];
		pwd = rec_data[1][2];
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		enterText (driver.findElement(By.xpath(".//*[@id='email']")), email, "Email address");
		enterText (driver.findElement(By.xpath(".//*[@id='password']")), pwd, "Password");
		clickButton(driver.findElement(By.xpath(".//*[@id='submitButton']")), "Login");
		
		String actualErrMsg = driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText().trim();
		validateErrorMsg (expectedErrMsg , actualErrMsg );
		
	}
	
	public static void forgotPassword() throws InterruptedException, IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/forgotPassword.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		String email;
		
		email = rec_data[1][1];
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		clickButton(driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a")), "Forgot your password?");
		enterText(driver.findElement(By.xpath(".//*[@id='UserName']")), email, "Email");
		clickButton(driver.findElement(By.xpath(".//*[@id='submitButton']/a")), "Send link");
		
	}
	
	public static void launchFreeTrial() throws IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/launchFreeTrial.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		 
		 String url = rec_data[1][1];
		 
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize(); 
		clickButton(driver.findElement(By.xpath("html/body/div[6]/header/nav/div[3]/div[1]/div/div/div/ul/li[6]/a/span")), " free trial");
		
	}
	
	public static void freeTrialSignup() throws InterruptedException, IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/freeTrialSignup.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		String firstName, lastName, email, phone, cntry;
		
		firstName = rec_data[1][1];
		lastName = rec_data[1][2];
		email = rec_data[1][3];
		phone = rec_data[1][4];
		cntry = rec_data[1][5];
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		enterText(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input")), firstName, "First name");
		enterText(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input")), lastName, "Last name");
		enterText(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")), email, "Email address");
		enterText(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/input")), phone, "Phone number");
		selectDropdown (driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[7]/label/span/select")), cntry, "Country");
		
		//recaptcha handling pending

	}
	
	public static void freeTrialError() throws InterruptedException, IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/freeTrialError.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		//String expectedErrMsgFname, expectedErrMsgLname, expectedErrMsgEmail, expectedErrMsgPhone, expectedErrMsgEmail2, actualErrMsgFname, actualErrMsgLname, actualErrMsgEmail, actualErrMsgPhone, actualErrMsgEmail2, 
		String email;
		
		//expectedErrMsgFname = rec_data[1][1];
		//expectedErrMsgLname = rec_data[1][2];
		//expectedErrMsgEmail = rec_data[1][3];
		//expectedErrMsgPhone = rec_data[1][4];
		//expectedErrMsgEmail2 = rec_data[1][5];
		email = rec_data[1][6];
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		//recaptcha submit button pending
		mouseOver(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button")), "Get started");
		clickButton(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button")), "Get started");
		
		//actualErrMsgFname = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-1']")).getText().trim();
		//actualErrMsgLname = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-2']")).getText().trim();
		//actualErrMsgEmail = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']")).getText().trim();
		//actualErrMsgPhone = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-4']")).getText().trim();
		
		//validateErrorMsg (expectedErrMsgFname , actualErrMsgFname );
		//validateErrorMsg (expectedErrMsgLname , actualErrMsgLname );
		//validateErrorMsg (expectedErrMsgEmail , actualErrMsgEmail );
		//validateErrorMsg (expectedErrMsgPhone , actualErrMsgPhone );
		
		enterText(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")), email, "Email address");
		mouseOver(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button")), "Get started");
		clickButton(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[10]/span/button")), "Get started");
		
		//actualErrMsgEmail2 = driver.findElement(By.xpath(".//*[@id='signup-form-error-messege-3']")).getText().trim();
		//validateErrorMsg (expectedErrMsgEmail2 , actualErrMsgEmail2 );
		
	}
	
	public static void freeTrialTermsOfUse() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		clickButton(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[1]")), "terms of use");
		
	}
	
	public static void freeTrialPrivacyPolicy() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		clickButton(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[2]")), "privacy policy");
		
	}
	
	public static void freeTrialOfferDetails() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		clickButton(driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/div/label/a[3]")), "offer details");
		
	}
	
	public static void freeTrialAccountantOrBookkeeper() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		clickButton(driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a")), "accountant or bookkeeper");
		
	}
	
	public static void startPageUI() throws InterruptedException, IOException {
		
		String dt_path = "C:/Priya/Selenium Training/Testing/TestData/startPageUI.xls";
		String[][] rec_data = ReusableMethods.readSheet(dt_path, "Sheet1");
		
		String expectedDisplayMsg, actualDisplayMsg;
		
		expectedDisplayMsg = rec_data[1][1];
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		actualDisplayMsg = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[1]/p")).getText().trim();
		validateDisplayMsg(expectedDisplayMsg, actualDisplayMsg);
		
		clickButton(driver.findElement(By.xpath(".//*[@id='Dashboard']")), "Dashboard");
		clickButton(driver.findElement(By.xpath(".//*[@id='Accounts']")), "Accounts");	
		clickButton(driver.findElement(By.xpath(".//*[@id='Payroll']")), "Payroll");
		clickButton(driver.findElement(By.xpath(".//*[@id='Reports']")), "Reports");
		clickButton(driver.findElement(By.xpath(".//*[@id='Contacts']")), "Contacts");
		clickButton(driver.findElement(By.xpath(".//*[@id='Settings']")), "Settings");
		clickButton(driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")), "quicklaunch");
		clickButton(driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")), "files");
		clickButton(driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a")), "notifications");
		clickButton(driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")), "search");
		clickButton(driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a")), "help");

	}


}
