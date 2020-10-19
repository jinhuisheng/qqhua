package cn.extremeprogramming.qqhua.controllers;

import cn.extremeprogramming.qqhua.EncryptedPicture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.io.InputStream;

import static cn.extremeprogramming.qqhua.TestHelper.loadTestPicture;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author huisheng.jin
 * @date 2020/10/15.
 */
@WebMvcTest(EncryptController.class)
public class EncryptControllerTest {
    private static final String MODEL_ATTR_IMAGE_AS_BASE_64 = "imageAsBase64";

    @Autowired
    private MockMvc mvc;
    private MockMultipartFile picture;

    @BeforeEach
    void setUp() throws IOException {
        picture = givenPicture();
    }

    @Test
    void should_throw_error_400_given_message_or_picture_post() throws Exception {
        mvc.perform(multipart("/encrypt"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_render_encrypt_result_page_given_message_and_picture() throws Exception {
        mvc.perform(multipart("/encrypt")
                .file(picture)
                .param("message", "Hello!"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"));
    }

    @Test
    void should_resolve_model_with_attribute_given_message_and_picture() throws Exception {
        MockMultipartFile picture = givenPicture();

        EncryptedPicture expected = new EncryptedPicture("Hello!", loadTestPicture("banner.png"));

        mvc.perform(multipart("/encrypt")
                .file(picture)
                .param("message", "Hello!"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists(MODEL_ATTR_IMAGE_AS_BASE_64))
                .andExpect(model().attribute(MODEL_ATTR_IMAGE_AS_BASE_64, expected.toBase64()));
    }

    private MockMultipartFile givenPicture() throws IOException {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("banner.png");
        return new MockMultipartFile("picture", resource);
    }

}
