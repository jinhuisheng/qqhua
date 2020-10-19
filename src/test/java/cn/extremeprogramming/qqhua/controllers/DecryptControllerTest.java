package cn.extremeprogramming.qqhua.controllers;

import cn.extremeprogramming.qqhua.FileHelper;
import deaddrop.Basic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static deaddrop.Basic.encode;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
@WebMvcTest(DecryptController.class)
public class DecryptControllerTest {

    private static final String TO_BE_DECRYPTED_MESSAGE = "hello";

    @Autowired
    MockMvc mvc;

    @Test
    void should_throw_error_400_without_given_decrypted_picture() throws Exception {
        mvc.perform(multipart("/decrypt"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_handle_post_and_return_view() throws Exception {
        String encryptedPictureFile = givenEncryptedPictureFile("src/test/resources/banner.png", TO_BE_DECRYPTED_MESSAGE);
        MockMultipartFile picture = new MockMultipartFile("picture", new FileInputStream(encryptedPictureFile).readAllBytes());
        mvc.perform(multipart("/decrypt")
                .file(picture))
                .andExpect(status().isOk())
                .andExpect(view().name("decrypted.html"));
    }

    @Test
    void should_resolve_model_attribute_success() throws Exception {
        String encryptedPictureFile = givenEncryptedPictureFile("src/test/resources/banner.png", TO_BE_DECRYPTED_MESSAGE);
        Basic basic = new Basic(encryptedPictureFile);
        String expected = new String(basic.decode_data());

        MockMultipartFile picture = new MockMultipartFile("picture", new FileInputStream(encryptedPictureFile).readAllBytes());
        mvc.perform(multipart("/decrypt")
                .file(picture))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attribute("message", expected));
    }

    private String givenEncryptedPictureFile(String imageFilePath, String message) throws IOException {
        byte[] encodedImageData = encode(imageFilePath, message);
        return FileHelper.writePictureToTempFile(encodedImageData);
    }
}
