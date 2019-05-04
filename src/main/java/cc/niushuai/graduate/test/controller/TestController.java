package cc.niushuai.graduate.test.controller;

import cc.niushuai.graduate.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author niush
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MailService mailService;


    @GetMapping("/mail")
    @ResponseBody
    public void testSend(){
        mailService.testSend("1225803134@qq.com");
    }

}
