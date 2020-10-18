package cn.extremeprogramming.qqhua.controllers;

import cn.extremeprogramming.qqhua.EncryptedPicture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

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
    @Autowired
    private MockMvc mvc;

    @Test
    void should_throw_error_400_given_message_or_picture_post() throws Exception {
        mvc.perform(multipart("/encrypt"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_render_encrypt_result_page_given_message_and_picture() throws Exception {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("banner.png");
        MockMultipartFile picture = new MockMultipartFile("picture", resource);

        mvc.perform(multipart("/encrypt")
                .file(picture)
                .param("message", "Hello!"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"));
    }

    @Test
    void should_resolve_model_with_attribute_given_message_and_picture() throws Exception {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("banner.png");
        MockMultipartFile picture = new MockMultipartFile("picture", resource);

        EncryptedPicture expected = new EncryptedPicture("Hello!", loadTestPicture("banner.png"));

        mvc.perform(multipart("/encrypt")
                .file(picture)
                .param("message", "Hello!"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("imageAsBase64"))
                .andExpect(model().attribute("imageAsBase64", expected.toBase64()));
    }

}
