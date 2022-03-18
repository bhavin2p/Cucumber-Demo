package steps;

import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_steps {
	WebDriver driver;
	
	public EbayHome_steps(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
		
	@Given("I am on Ebay Home Page")
	public void i_am_on_Ebay_Home_Page() {
	    
	    driver.get("https://www.ebay.com");
	    driver.manage().window().maximize();
	}

	@When("I click on Advanced Search Link")
	public void i_click_on_Advanced_Search_Link() {
		driver.findElement(By.linkText("Advanced")).click();
	}

	@Then("I navigate to Advanced Search Page")
	public void i_navigate_to_Advanced_Search_Page() {
		String expURL = "https://www.ebay.com/sch/ebayadvsearch";
		String actURL = driver.getCurrentUrl();
		if(!expURL.equals(actURL)) {
			fail("Page does not navigate to expected page");
		}
	}
	
	@When("I search for {string}")
	public void i_search_for_iPhone(String str1) {
	    driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
	    driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	}

	@Then("I validate atleast {int} search items present")
	public void i_validate_atleast_search_items_present(int count) {
		String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText().trim();
		String itemCount2 = itemCount.replaceAll(",", "");
	    int itemCountInt = Integer.parseInt(itemCount2);
	    if(itemCountInt <= count) {
	    	fail("Less than 1000 result");
	    }
	}
	
	@When("I search for {string} in {string} category")
	public void i_search_for_in_category(String string, String string2) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);
		List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
		for(WebElement x : cat) {
			if(x.getText().trim().toLowerCase().equals(string2.toLowerCase())) {
				x.click();
				break;
			}
		}
	    driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
	    Thread.sleep(1000);
	}
	
	@When("I click on {string}")
	public void i_click_on(String string) throws InterruptedException {
	    Thread.sleep(4000);
		driver.findElement(By.partialLinkText(string)).click();
	    Thread.sleep(1000);
	}

	@Then("I validate that page navigates to {string} and title contains {string}")
	public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
		String actUrl = driver.getCurrentUrl();
		String actTitle = driver.getTitle();
		if(!actUrl.equals(url)) {
			fail("Page does navigate to expecteed url : " +url);
		}
		if(!actTitle.contains(title)) {
			fail("Title mismatch");
		}
	}
}
