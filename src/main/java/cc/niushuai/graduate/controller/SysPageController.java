package cc.niushuai.graduate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 *
 * @author niushuai
 * @email niushuai951101@gmail.com
 * @date 2018年11月24日 下午11:05:27
 */
@Slf4j
@Controller
public class SysPageController extends AbstractController {

    @RequestMapping("{module}/{url}.html")
    public String page(@PathVariable("module") String module, @PathVariable("url") String url) {

        log.info("look here...");
        log.info(module + "/" + url + ".html");

        return module + "/" + url + ".html";
    }


    @RequestMapping("index/main")
    public String main() {
        return "main/main";
    }


}
