package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Locators {
	public static void main(String[] args) {
		
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		//locators
		BrowserContext b1=browser.newContext();
		Page p1=b1.newPage();
		p1.navigate("https://testing.d2okaspacdbhs.amplifyapp.com");
		//single elements
		Locator signinbutton = p1.locator("text= Sign In");
		signinbutton.first().click();
		int totalsignintext = signinbutton.count();
        System.out.println(totalsignintext+"totalsignintext") ;
        
		//signinbutton.click();       // message='Error: strict mode violation: locator("text= Sign In") resolved to 3 elements:
		System.out.println(" clicked");//beacuse of this error we are give first() it will perform click action first element
		
		
		//multiple element 
		
	}

}
