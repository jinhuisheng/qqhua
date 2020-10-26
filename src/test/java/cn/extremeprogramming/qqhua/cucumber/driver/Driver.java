package cn.extremeprogramming.qqhua.cucumber.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;

public class Driver {

    private static final String HOST_NAME_PREFIX = "http://localhost:";
    private final WebDriver webDriver = new ChromeDriver();
    @Value("${cucumber.port}")
    private String port;
    @Value("${cucumber.context-path}")
    private String contextPath;

    public void close() {
        webDriver.close();
    }

    public void navigateTo(String url) {
        webDriver.get(urlWithHostAndPort(url));
        webDriver.switchTo().window(webDriver.getWindowHandle());
    }

    public void inputFileById(String path, String id) {
        elementById(id).sendKeys(path);
    }

    public void inputTextById(String text, String id) {
        elementById(id).sendKeys(text);
    }

    public void clickById(String id) {
        elementById(id).click();
    }

    public String waitForTextPresentByCssClassName(String className) {
        return webDriver.findElement(By.className(className)).getText();
    }

    public Boolean existElementByTagName(String tagName) {
        return webDriver.findElement(By.tagName(tagName)).isDisplayed();
    }

    private WebElement elementById(String id) {
        return webDriver.findElement(By.id(id));
    }

    private String urlWithHostAndPort(String url) {
        return HOST_NAME_PREFIX + port + contextPath + url;
    }

}
