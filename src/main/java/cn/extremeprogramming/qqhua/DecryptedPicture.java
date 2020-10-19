package cn.extremeprogramming.qqhua;

import deaddrop.Basic;
import org.joda.time.DateTime;

import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.String.format;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
public class DecryptedPicture {
    private byte[] picture;

    public DecryptedPicture(byte[] picture) {
        this.picture = picture;
    }

    public byte[] getPicture() {
        return picture;
    }

    public String message() throws IOException {
        String tempFile = writePictureToTempFile();
        Basic basic = new Basic(tempFile);
        return new String(basic.decode_data());
    }

    private String writePictureToTempFile() throws IOException {
        String originalFilePath = format("/tmp/%s.png", new DateTime());
        new FileOutputStream(originalFilePath).write(picture);
        return originalFilePath;
    }
}
