package cn.extremeprogramming.qqhua;

import deaddrop.Basic;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static cn.extremeprogramming.qqhua.TestHelper.loadTestPicture;
import static deaddrop.Basic.encode;
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
        String tempFile = givenEncryptedPictureFile("src/test/resources/banner.png", TO_BE_DECRYPTED_MESSAGE);
        Basic basic = new Basic(tempFile);
        String expected = new String(basic.decode_data());

        byte[] picture = new FileInputStream(tempFile).readAllBytes();
        DecryptedPicture decryptedPicture = new DecryptedPicture(picture);
        assertThat(decryptedPicture.message()).isEqualTo(expected);
    }

    private String givenEncryptedPictureFile(String imageFilePath, String message) throws IOException {
        byte[] encodedImageData = encode(imageFilePath, message);
        return FileHelper.writePictureToTempFile(encodedImageData);
    }

}
