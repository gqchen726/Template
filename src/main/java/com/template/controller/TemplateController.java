package com.template.controller;

import com.template.common.CommonResponseBody;
import com.template.entity.User;
import com.template.service.ITemplateServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: guoqing.chen01@hand-china.com 2021-08-22 10:46
 **/

@RestController
@RequestMapping("/user")
public class TemplateController {
    @Autowired
    private ITemplateServer templateServer;

    @GetMapping("/hello")
    @ApiOperation("helloMessage")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/findAll")
    @ApiOperation("查找所有的用户")
    @ResponseBody
    public CommonResponseBody<List<User>> findAll() {
        return new CommonResponseBody<>(templateServer.findAll());
    }

    @GetMapping("/findOneByPrimaryKey/{id}")
    @ApiOperation("根据id查找一个用户")
    @ResponseBody
    public CommonResponseBody<User> findOneByPrimaryKey(@PathVariable Integer id) {
        return new CommonResponseBody<>(templateServer.findOneByPrimaryKey(id));
    }

    @ApiOperation("根据example查找用户")
    @PostMapping("/findOneByExample")
    @ResponseBody
    public CommonResponseBody<List<User>> findOneByExample(@RequestBody User user) {
        return new CommonResponseBody<>(templateServer.findOneByExample(user));
    }

    @ApiOperation("添加一个用户")
    @PostMapping("/addOne")
    @ResponseBody
    public CommonResponseBody<Integer> addOne(@RequestBody User user) {
        return new CommonResponseBody<>(templateServer.addOne(user));
    }

    @ApiOperation("修改一个用户")
    @PostMapping("/editOne")
    @ResponseBody
    public CommonResponseBody<Integer> editOne(@RequestBody User user) {
        return new CommonResponseBody<>(templateServer.editOne(user));
    }

    @ApiOperation("删除一个用户")
    @GetMapping("/removeOneByPrimaryKey/{id}")
    @ResponseBody
    public CommonResponseBody<Integer> removeOneByPrimaryKey(@PathVariable Integer id) {
        return new CommonResponseBody<>(templateServer.removeOneByPrimaryKey(id));
    }
}
