package cn.extremeprogramming.qqhua.controllers;

import cn.extremeprogramming.qqhua.TestHelper;
import deaddrop.Basic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
@WebMvcTest(DecryptController.class)
public class DecryptControllerTest {

    private static final String TO_BE_DECRYPTED_MESSAGE = "hello";
    public static final String MODEL_ATTRIBUTE_MESSAGE = "message";

    @Autowired
    MockMvc mvc;
    private String encryptedPictureFile;
    private MockMultipartFile picture;

    @BeforeEach
    void setUp() throws IOException {
        encryptedPictureFile = TestHelper.givenEncryptedPictureFile("src/test/resources/banner.png"
                , TO_BE_DECRYPTED_MESSAGE);
        picture = new MockMultipartFile("picture", TestHelper.getBytes(encryptedPictureFile));
    }

    @Test
    void should_throw_error_400_without_given_decrypted_picture() throws Exception {
        mvc.perform(multipart("/decrypt"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_handle_post_and_return_view() throws Exception {
        mvc.perform(multipart("/decrypt")
                .file(picture))
                .andExpect(status().isOk())
                .andExpect(view().name("decrypted.html"));
    }

    @Test
    void should_resolve_model_attribute_success() throws Exception {
        String expected = givenExpected(encryptedPictureFile);
        mvc.perform(multipart("/decrypt")
                .file(picture))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists(MODEL_ATTRIBUTE_MESSAGE))
                .andExpect(model().attribute(MODEL_ATTRIBUTE_MESSAGE, expected));
    }

    private String givenExpected(String encryptedPictureFile) {
        Basic basic = new Basic(encryptedPictureFile);
        return new String(basic.decode_data());
    }

}
