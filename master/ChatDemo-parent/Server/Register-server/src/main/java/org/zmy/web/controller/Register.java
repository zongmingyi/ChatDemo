package org.zmy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zmy.entity.UserInfo;
import org.zmy.service.Impl.RegisterServiceImpl;
import org.zmy.web.Result;

@RestController
@RequestMapping("/register")
public class Register {

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping
    public Result<Void> register(UserInfo userInfo){
        registerService.registerUser(userInfo);
        return Result.success();
    }
}
