package cn.extremeprogramming.qqhua;

import deaddrop.Basic;
import java.io.IOException;

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
        String tempFilePath = FileHelper.writePictureToTempFile(picture);
        byte[] encodedImage = Basic.encode(tempFilePath, message);
        return getMimeEncoder().encodeToString(encodedImage);
    }

}
