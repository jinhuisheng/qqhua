package cn.extremeprogramming.qqhua;

import deaddrop.Basic;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static cn.extremeprogramming.qqhua.TestHelper.loadTestPicture;
import static deaddrop.Basic.encode;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
public class DecryptedPictureTest {
    @Test
    void should_create_decryptedPicture_success() throws IOException {
        byte[] bytes = loadTestPicture("banner.png");
        DecryptedPicture decryptedPicture = new DecryptedPicture(bytes);
        assertThat(decryptedPicture.getPicture()).isEqualTo(bytes);
    }

    @Test
    void should_get_message_success() throws IOException {
        byte[] encodedImageData = encode("src/test/resources/banner.png", "hello");
        String tempFile = writePictureToTempFile(encodedImageData);
        Basic basic = new Basic(tempFile);
        String expected = new String(basic.decode_data());

        byte[] picture = new FileInputStream(tempFile).readAllBytes();
        DecryptedPicture decryptedPicture = new DecryptedPicture(picture);
        assertThat(decryptedPicture.message()).isEqualTo(expected);
    }

    private String writePictureToTempFile(byte[] picture) throws IOException {
        String originalFilePath = format("/tmp/%s.png", new DateTime());
        new FileOutputStream(originalFilePath).write(picture);
        return originalFilePath;
    }

}
