package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class Example {
	  public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      // Start tracing before creating / navigating a page.
		      context.tracing().start(new Tracing.StartOptions()
		        .setScreenshots(true)
		        .setSnapshots(true));
		        //.setSources(true));
		      
		      Page page = context.newPage();
		  
		      page.navigate("https://testing.d2okaspacdbhs.amplifyapp.com/");
		      page.navigate("https://testing.d2okaspacdbhs.amplifyapp.com/login/");
		      page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hudini").setExact(true)).click();
		      page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Sign in")).click();
		      page.getByText("Email").click();
		      page.getByPlaceholder("Type Your Email Address").click();
		      page.getByPlaceholder("Type Your Email Address").fill("gkrishnamurthy443@gmail.com");
		      //page.pause();//to pause the execution
		      page.getByPlaceholder("Type Your Password").click();
		      page.getByPlaceholder("Type Your Password").fill("Kavya@1234");
		   //   page.locator("div").filter(new Locator.FilterOptions().setHasText("Password")).getByRole(AriaRole.BUTTON).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Try Again!")).click();
		      
		   // Stop tracing and export it into a zip archive.
		      context.tracing().stop(new Tracing.StopOptions()
		        .setPath(Paths.get("trace.zip")));
		    }
		  }

}
