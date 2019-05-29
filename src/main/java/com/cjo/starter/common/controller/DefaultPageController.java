package com.cjo.starter.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hieubui
 * @since 2019-05-08
 */
@Controller
public class DefaultPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultPage() {
        return "Welcome";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getMainPage() {
        return "Index";
    }
}
