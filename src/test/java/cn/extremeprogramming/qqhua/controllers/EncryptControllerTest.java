package cn.extremeprogramming.qqhua.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author huisheng.jin
 * @date 2020/10/15.
 */
@WebMvcTest(EncryptController.class)
public class EncryptControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void should_render_encrypt_result_page_given_message_and_picture() throws Exception {
        mvc.perform(multipart("/encrypt"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("text/html"));
    }
}
