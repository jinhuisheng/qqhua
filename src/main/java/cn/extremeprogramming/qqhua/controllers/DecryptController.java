package cn.extremeprogramming.qqhua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
@Controller
public class DecryptController {
    @RequestMapping("/decrypt")
    public String post(@RequestParam("picture") MultipartFile picture, Model model) {
        model.addAttribute("message", "test");
        return "decrypted.html";
    }
}
