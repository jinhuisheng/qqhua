package cn.extremeprogramming.qqhua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author huisheng.jin
 * @date 2020/10/15.
 */
@Controller
public class EncryptController {
    @PostMapping("/encrypt")
    public String encrypt() {
        return "encrypted.html";
    }
}
