package steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayAdvancedSearchSteps {
	
	WebDriver driver;
	
	public EbayAdvancedSearchSteps(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	@Given("I am Ebay Advanced Search Page")
	public void i_am_Ebay_Advanced_Search_Page() {
	    driver.get("https://www.ebay.com/sch/ebayadvsearch");
	    driver.manage().window().maximize();
	}

	@When("I click on Ebay Logo")
	public void i_click_on_Ebay_Logo() {
		driver.findElement(By.xpath("//a[@id='gh-la']")).click();
	    
	}

	@Then("I am navigated to Ebay Home Page")
	public void i_am_navigated_to_Ebay_Home_Page() {
		String expURL = "https://www.ebay.com/";
		String actURL = driver.getCurrentUrl();
		if(!expURL.equals(actURL)) {
			fail("Page does not navigate to expected page");
		}
	}
	
	@When("I advanced search an item")
	public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
	    
		driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1, 0));
		driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys(dataTable.cell(1, 1));
		driver.findElement(By.xpath("//input[@name='_udlo']")).sendKeys(dataTable.cell(1, 2));
		driver.findElement(By.xpath("//input[@name='_udhi']")).sendKeys(dataTable.cell(1, 3));
		driver.findElement(By.xpath("//button[@id='searchBtnLowerLnk']")).click();
		Thread.sleep(5000);
	}

}
