package cn.extremeprogramming.qqhua;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static deaddrop.Basic.encode;
import static java.util.Base64.getMimeEncoder;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/10/18.
 */
public class EncryptedPictureTest {
    @Test
    void should_create_encryptedPicture_success_given_message_and_picture() throws IOException {
        byte[] bytes = getClass().getClassLoader().getResourceAsStream("banner.png").readAllBytes();
        EncryptedPicture encryptedPicture = new EncryptedPicture("hello", bytes);
        assertThat(encryptedPicture.getMessage()).isEqualTo("hello");
        assertThat(encryptedPicture.getPicture()).isEqualTo(bytes);
    }

    @Test
    void should_toBase64_success() throws IOException {
        byte[] bytes = getClass().getClassLoader().getResourceAsStream("banner.png").readAllBytes();
        EncryptedPicture encryptedPicture = new EncryptedPicture("hello", bytes);

        byte[] encodedImageData = encode("src/test/resources/banner.png", "hello");
        String expected = getMimeEncoder().encodeToString(encodedImageData);

        assertThat(encryptedPicture.toBase64()).isEqualTo(expected);
    }

}
