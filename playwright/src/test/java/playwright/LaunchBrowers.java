package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowers {
	public static void main(String[] args) {

		// create method we will start server and playwright returns the definition
		Playwright playwright = Playwright.create();// for create option we need 1.8 jre
		// to launch browser (browser context) it will run headless mode
		// Browser browser = playwright.firefox().launch();// if chromium bbrinaries not
		// inastall it automatically download in your pc

		// to lunch edge.firefox.chrome browewr

		LaunchOptions ip = new LaunchOptions();
		ip.setChannel("firefox");
		ip.setHeadless(false);
		//chromium contains edge,beta ,dev ,chrome and firefox contains firefox, webkit contans safari
		
		
		
		Browser browser = playwright.chromium().launch(ip);
		// to run head mode
		// Browser browser = playwright.webkit().launch(new
		// BrowserType.LaunchOptions().setHeadless(false));
		// page context
		Page page = browser.newPage();
		// to pass url and launch application
		page.navigate("https://www.facebook.com");
		// to fetch page title
		String pagetitle = page.title();
		System.out.println("the page title" + pagetitle);
		// to fetch page url
		String pageurl = page.url();
		System.out.println("the page title" + pageurl);
		// to close browser
		browser.close();
		// to close /stop the server
		playwright.close();

	}

}
