package cn.extremeprogramming.qqhua.functional.steps;

import io.cucumber.java8.En;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author huisheng.jin
 * @date 2020/10/24.
 */
public class MyStepdefs implements En {
    private final WebDriver driver = new ChromeDriver();

    public MyStepdefs() {
        Given("^user opens home page$", () -> {
            driver.get("https://www.google.com");
        });
        When("^user uploads picture with message \"([^\"]*)\"$", (String arg0) -> {
            WebElement element = driver.findElement(By.name("q"));
            // Enter something to search for
            element.sendKeys("xx");
            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();
        });
        Then("^user sees encoded picture$", () -> {
            // Google's search is rendered dynamically with JavaScript
            // Wait for the page to load timeout after ten seconds
            new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("xx");
                }
            });
        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
