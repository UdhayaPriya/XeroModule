package XeroModule;

import java.io.IOException;

public class AutomationScripts extends Module{
	
	public static void testID01A() throws IOException {
		
		Module.launchHomepage();
		Module.login();
		
	}
	
	public static void testID01B() throws IOException, InterruptedException {
		
		Module.launchHomepage();
		Module.loginErrorPwd();
		
	}
	
	public static void testID01C() throws IOException, InterruptedException {
		
		Module.launchHomepage();
		Module.loginErrorUser();
		
	}
	
	public static void testID01D() throws InterruptedException, IOException {
		
		Module.launchHomepage();
		Module.forgotPassword();
		
	}

	public static void testID02A() throws IOException, InterruptedException {
		
		Module.launchFreeTrial();
		Module.freeTrialSignup();
	
	}

	public static void testID02B() throws IOException, InterruptedException {
		
		Module.launchFreeTrial();
		Module.freeTrialError();
	
	}

	public static void testID02C() throws IOException {
		
		Module.launchFreeTrial();
		Module.freeTrialTermsOfUse();
		Module.freeTrialPrivacyPolicy();
	
	}

	public static void testID02D() throws IOException {
		
		Module.launchFreeTrial();
		Module.freeTrialOfferDetails();
	
	}

	public static void testID02E() throws IOException {
		
		Module.launchFreeTrial();
		Module.freeTrialAccountantOrBookkeeper();
	
	}

	public static void testID03A() throws IOException, InterruptedException {
		
		Module.launchHomepage();
		Module.login();
		Module.startPageUI();
	
	}

}
