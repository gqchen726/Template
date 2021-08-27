package com.template.controller;

import com.template.common.ResponseBody;
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
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/findAll")
    @ApiOperation("查找所有的用户")
    public ResponseBody<List<User>> findAll() {
        return new ResponseBody<>(templateServer.findAll());
    }

    @GetMapping("/findOneByPrimaryKey/{id}")
    @ApiOperation("根据id查找一个用户")
    public ResponseBody<User> findOneByPrimaryKey(@PathVariable Integer id) {
        return new ResponseBody<>(templateServer.findOneByPrimaryKey(id));
    }

    @ApiOperation("根据example查找用户")
    @PostMapping("/findOneByExample")
    public ResponseBody<List<User>> findOneByExample(@RequestBody User user) {
        return new ResponseBody<>(templateServer.findOneByExample(user));
    }

    @ApiOperation("添加一个用户")
    @PostMapping("/addOne")
    public ResponseBody<Integer> addOne(@RequestBody User user) {
        return new ResponseBody<>(templateServer.addOne(user));
    }

    @ApiOperation("修改一个用户")
    @PostMapping("/editOne")
    public ResponseBody<Integer> editOne(@RequestBody User user) {
        return new ResponseBody<>(templateServer.editOne(user));
    }

    @ApiOperation("删除一个用户")
    @GetMapping("/removeOneByPrimaryKey/{id}")
    public ResponseBody<Integer> removeOneByPrimaryKey(@PathVariable Integer id) {
        return new ResponseBody<>(templateServer.removeOneByPrimaryKey(id));
    }
}
