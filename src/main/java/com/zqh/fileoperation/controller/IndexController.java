package com.zqh.fileoperation.controller;

import com.zqh.fileoperation.entities.FileEntity;
import com.zqh.fileoperation.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqh
 * @date 2021/9/7 0007 9:12
 */
@Controller
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("tools")
    public String tools() {
        return "tools";
    }



}
