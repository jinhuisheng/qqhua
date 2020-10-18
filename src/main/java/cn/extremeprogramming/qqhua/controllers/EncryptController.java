package cn.extremeprogramming.qqhua.controllers;

import cn.extremeprogramming.qqhua.EncryptedPicture;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author huisheng.jin
 * @date 2020/10/15.
 */
@Controller
public class EncryptController {
    @PostMapping("/encrypt")
    public String encrypt(@RequestParam("message") String message,
                          @RequestParam("picture") MultipartFile picture,
                          Model model) throws IOException {

        EncryptedPicture encryptedPicture = new EncryptedPicture(message, picture.getBytes());
        model.addAttribute("imageAsBase64", encryptedPicture.toBase64());
        return "encrypted.html";
    }
}
