package cn.extremeprogramming.qqhua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huisheng.jin
 * @date 2020/10/15.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "home";
    }
}
