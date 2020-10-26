package cn.extremeprogramming.qqhua.cucumber.pages;

import cn.extremeprogramming.qqhua.TestHelper;
import cn.extremeprogramming.qqhua.cucumber.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

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
        driver.submitMessageAndImageFile(message, file.getAbsolutePath());
    }

    public Boolean containsImg() {
        return driver.containsImg();
    }


    public void uploadEncryptedImage() throws IOException {
        driver.uploadEncryptedImage();
    }

    public String getDecryptedMessage(String message) {
        return driver.getDecryptedMessage(message);
    }

    public void submitImageFile(String imagePath) {
        File file = TestHelper.givenFile(imagePath);
        driver.submitEncodedImageFile(file.getAbsolutePath());
    }
}
