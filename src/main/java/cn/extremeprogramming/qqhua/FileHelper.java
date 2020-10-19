package cn.extremeprogramming.qqhua;

import org.joda.time.DateTime;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author huisheng.jin
 */
public class FileHelper {
    public static String writePictureToTempFile(byte[] picture) throws IOException {
        String originalFilePath = String.format("/tmp/%s.png", new DateTime());
        new FileOutputStream(originalFilePath).write(picture);
        return originalFilePath;
    }
}