package cn.extremeprogramming.qqhua.model;

import cn.extremeprogramming.qqhua.FileHelper;
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
        String tempFile = FileHelper.writePictureToTempFile(picture);
        Basic basic = new Basic(tempFile);
        return new String(basic.decode_data());
    }

}
