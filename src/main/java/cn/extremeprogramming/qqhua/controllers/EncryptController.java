package cn.extremeprogramming.qqhua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huisheng.jin
 * @date 2020/10/15.
 */
@Controller
public class EncryptController {
    @PostMapping("/encrypt")
    public String encrypt(@RequestParam("message") String message,
                          @RequestParam("picture") MultipartFile picture
    ) {
        return "encrypted.html";
    }
}
