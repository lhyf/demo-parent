package org.lhyf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/****
 * @author YF
 * @date 2018-06-12 16:39
 * @desc IndexController
 *
 **/

@Controller
public class IndexController {

    @GetMapping(value = "/login")
    public String login() {
        return "admin/login";
    }


}
