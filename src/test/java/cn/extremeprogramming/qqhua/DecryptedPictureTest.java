package cn.extremeprogramming.qqhua;

import deaddrop.Basic;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static cn.extremeprogramming.qqhua.TestHelper.loadTestPicture;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
public class DecryptedPictureTest {

    private static final String TO_BE_DECRYPTED_MESSAGE = "hello";

    @Test
    void should_create_decryptedPicture_success() throws IOException {
        byte[] bytes = loadTestPicture("banner.png");
        DecryptedPicture decryptedPicture = new DecryptedPicture(bytes);
        assertThat(decryptedPicture.getPicture()).isEqualTo(bytes);
    }

    @Test
    void should_get_message_success() throws IOException {
        String tempFile = TestHelper.givenEncryptedPictureFile("src/test/resources/banner.png"
                , TO_BE_DECRYPTED_MESSAGE);
        Basic basic = new Basic(tempFile);
        String expected = new String(basic.decode_data());

        DecryptedPicture decryptedPicture = new DecryptedPicture(TestHelper.getBytes(tempFile));
        assertThat(decryptedPicture.message()).isEqualTo(expected);
    }

}
