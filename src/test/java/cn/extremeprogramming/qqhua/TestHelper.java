package cn.extremeprogramming.qqhua;

import java.io.FileInputStream;
import java.io.IOException;

import static deaddrop.Basic.encode;

public class TestHelper {
    public static byte[] loadTestPicture(String picture) throws IOException {
        return TestHelper.class.getClassLoader().getResourceAsStream(picture).readAllBytes();
    }

    public static String givenEncryptedPictureFile(String imageFilePath, String message) throws IOException {
        byte[] encodedImageData = encode(imageFilePath, message);
        return FileHelper.writePictureToTempFile(encodedImageData);
    }

    public static byte[] getBytes(String tempFile) throws IOException {
        return new FileInputStream(tempFile).readAllBytes();
    }
}