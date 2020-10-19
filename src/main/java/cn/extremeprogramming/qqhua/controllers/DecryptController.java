package cn.extremeprogramming.qqhua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
@Controller
public class DecryptController {
    @RequestMapping("/decrypt")
    public String post() {
        return "decrypted.html";
    }
}
