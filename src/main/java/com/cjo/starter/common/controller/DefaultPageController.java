package com.cjo.starter.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hieubui
 * @since 2019-05-08
 */
@Controller
public class DefaultPageController {

    @RequestMapping("/")
    public String getDefaultPage() {
        return "Welcome";
    }

    @RequestMapping("/index")
    public String getMainPage() {
        return "Index";
    }
}
