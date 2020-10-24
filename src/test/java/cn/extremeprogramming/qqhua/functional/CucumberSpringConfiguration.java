package cn.extremeprogramming.qqhua.functional;

import cn.extremeprogramming.qqhua.QqhuaApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author huisheng.jin
 * @date 2020/10/24.
 */
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = {QqhuaApplication.class})
@AutoConfigureMockMvc
public class CucumberSpringConfiguration {
}
