package cn.extremeprogramming.qqhua;

import deaddrop.Basic;
import org.joda.time.DateTime;

import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.String.format;
import static java.util.Base64.getMimeEncoder;

/**
 * @author huisheng.jin
 * @date 2020/10/18.
 */
public class EncryptedPicture {
    private final String message;
    private final byte[] picture;

    public EncryptedPicture(String message, byte[] picture) {
        this.message = message;
        this.picture = picture;
    }

    public String getMessage() {
        return message;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String toBase64() throws IOException {
        String tempFilePath = writePictureToTempFile();
        byte[] encodedImage = Basic.encode(tempFilePath, message);
        return getMimeEncoder().encodeToString(encodedImage);
    }

    private String writePictureToTempFile() throws IOException {
        String originalFilePath = format("/tmp/%s.png", new DateTime());
        new FileOutputStream(originalFilePath).write(picture);
        return originalFilePath;
    }
}
