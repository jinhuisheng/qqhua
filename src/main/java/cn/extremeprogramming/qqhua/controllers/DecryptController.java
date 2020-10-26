package cn.extremeprogramming.qqhua.controllers;

import cn.extremeprogramming.qqhua.model.DecryptedPicture;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author huisheng.jin
 * @date 2020/10/19.
 */
@Controller
public class DecryptController {
    @RequestMapping("/decrypt")
    public String post(@RequestParam("picture") MultipartFile picture, Model model) throws IOException {
        DecryptedPicture decryptedPicture = new DecryptedPicture(picture.getBytes());
        model.addAttribute("message", decryptedPicture.message());
        return "decrypted.html";
    }
}
