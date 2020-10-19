package cn.extremeprogramming.qqhua.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
@WebMvcTest(DecryptController.class)
public class DecryptControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void should_throw_error_400_without_given_decrypted_picture() throws Exception {
        mvc.perform(multipart("/decrypt"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_handle_post_and_return_view() throws Exception {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("banner.png");
        MockMultipartFile picture = new MockMultipartFile("picture", resource);
        mvc.perform(multipart("/decrypt")
                .file(picture))
                .andExpect(status().isOk())
                .andExpect(view().name("decrypted.html"));
    }
}
