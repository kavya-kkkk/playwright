package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowerContext {
public static void main(String[] args) {
	
//it will launch the brower in incongito mode because of that cookies will not store
	
	Playwright playwright = Playwright.create();
	Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	
	BrowserContext b1=browser.newContext();
	Page p1=b1.newPage();
	p1.navigate("https://www.facebook.com");
	System.out.println(p1.title());

	
	BrowserContext b2=browser.newContext();
	Page p2=b2.newPage();
	p2.navigate("https://www.flipkart.com");
	System.out.println(p2.title());
	
	BrowserContext b3=browser.newContext();
	Page p3=b2.newPage();
	p2.navigate("https://www.amazon.com");
	System.out.println(p2.title());
	
	
	p1.close();
	p2.close();
	p3.close();
	
}

	
}
