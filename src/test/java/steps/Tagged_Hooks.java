package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Tagged_Hooks {
	
	private WebDriver driver;
	
	public Tagged_Hooks(Common_Steps common_steps) {
		driver = common_steps.getDriver();
	}
	
	@Before(value = "@setcookies", order =0)
	public void setCookies() {
		System.out.println("Scenario specific hoook - setCookies executed");
	}
	
	@After(value = "@test", order = 0)
	public void testAfterHook() {
		System.out.println("Scenario specific hoook - testAfterHook executed");
	}

}
