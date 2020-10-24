package cn.extremeprogramming.qqhua;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {QqhuaApplication.class})
class QqhuaApplicationTests {

    @Test
    void contextLoads() {
    }

}
