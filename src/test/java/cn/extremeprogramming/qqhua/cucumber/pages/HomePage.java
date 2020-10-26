package cn.extremeprogramming.qqhua.cucumber.pages;

import cn.extremeprogramming.qqhua.TestHelper;
import cn.extremeprogramming.qqhua.cucumber.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class HomePage {

    private Driver driver;

    @Autowired
    public HomePage(Driver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigateTo("/");
    }

    public void submitMessageAndImageFile(String message, String imagePath) {
        File file = TestHelper.givenFile(imagePath);
        driver.inputTextById(message, "inputMessage");
        driver.inputFileById(file.getAbsolutePath(), "encryptImage");
        driver.clickById("encryptButton");
    }

    public Boolean existEncodedImage() {
        return driver.existElementByTagName("img");
    }

    public String getDecryptedMessage() {
        return driver.waitForTextPresentByCssClassName("card-text");
    }

    public void submitImageFile(String imagePath) {
        File file = TestHelper.givenFile(imagePath);
        driver.inputFileById(file.getAbsolutePath(), "encodedImage");
        driver.clickById("decryptButton");
    }
}
