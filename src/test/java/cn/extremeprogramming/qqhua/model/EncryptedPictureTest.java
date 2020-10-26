package cn.extremeprogramming.qqhua.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static cn.extremeprogramming.qqhua.TestHelper.loadTestPicture;
import static deaddrop.Basic.encode;
import static java.util.Base64.getMimeEncoder;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/10/18.
 */
public class EncryptedPictureTest {

    private static final String MESSAGE = "hello";

    @Test
    void should_create_encryptedPicture_success_given_message_and_picture() throws IOException {
        byte[] bytes = loadTestPicture("banner.png");
        EncryptedPicture encryptedPicture = new EncryptedPicture(MESSAGE, bytes);
        assertThat(encryptedPicture.getMessage()).isEqualTo(MESSAGE);
        assertThat(encryptedPicture.getPicture()).isEqualTo(bytes);
    }

    @Test
    void should_toBase64_success() throws IOException {
        byte[] bytes = loadTestPicture("banner.png");
        EncryptedPicture encryptedPicture = new EncryptedPicture(MESSAGE, bytes);

        byte[] encodedImageData = encode("src/test/resources/banner.png", MESSAGE);
        String expected = getMimeEncoder().encodeToString(encodedImageData);

        assertThat(encryptedPicture.toBase64()).isEqualTo(expected);
    }

}
