package com.jeannot.ttpt;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
	Web Front-End Test
	
	Automate the following functional test using Selenium:
	
	1. Navigate to the Wikipedia home page, http://www.wikipedia.org/.
	
	2. Search for a given string in English:
	
	(a) Type in a string given as parameter in the search input field.
	
	(b) Select English as the search language.
	
	(c) Click the search button.
	
	3. Validate that the first heading of the search results page matches the
	
	search string (ignoring case).
	
	4. Verify that the search results page is available in a language given as
	
	parameter.
	
	5. Navigate to the search results page in that language.
	
	6. Validate that the search results page in the new language includes a
	
	link to the version in English.
 *
 */
public class WebFrontEndTest {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //set global polling wait for elements to appear
		
	}
	
    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
	
	@Test
	public void wikipedia_search_returns_expected_results_in_english() {
		String searchString = "banana";
		String language = "English";
		searchWikipediaForGivenStringInGivenLanguage(searchString, language);
		WebElement firstHeading = driver.findElement(By.id("firstHeading"));
		assertTrue("Result should be " + searchString, searchString.equalsIgnoreCase(firstHeading.getText()));
	}
	
	@Test
	public void wikipedia_search_returns_expected_results_in_german_and_has_a_link_back_to_english() {
		String searchString = "banana";
		String language = "Deutsch";
		searchWikipediaForGivenStringInGivenLanguage(searchString, language);
		WebElement firstHeading = driver.findElement(By.id("firstHeading"));
		assertTrue("Result should be " + searchString, searchString.equalsIgnoreCase(firstHeading.getText()));
		assertNotNull("We should see a link back to the English language article",driver.findElement(By.linkText("English")));
		
		
	}
	
	private void searchWikipediaForGivenStringInGivenLanguage(String searchString, String language) {
		driver.get("http://www.wikipedia.org/");
		WebElement searchLanguage = driver.findElement(By.id("searchLanguage"));
		searchLanguage.sendKeys(language);
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		searchBox.sendKeys(searchString);
		searchBox.submit(); //NB am assuming this is equivalent of clicking the search button
		
	}
	
}
