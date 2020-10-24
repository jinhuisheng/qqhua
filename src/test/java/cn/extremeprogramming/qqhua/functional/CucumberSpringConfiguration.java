package cn.extremeprogramming.qqhua.functional;

import cn.extremeprogramming.qqhua.QqhuaApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huisheng.jin
 * @date 2020/10/24.
 */
@CucumberContextConfiguration
@SpringBootTest(classes = QqhuaApplication.class)
public class CucumberSpringConfiguration {
}
