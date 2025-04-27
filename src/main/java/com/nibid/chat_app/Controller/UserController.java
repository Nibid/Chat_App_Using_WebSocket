package com.nibid.chat_app.Controller;

import com.nibid.chat_app.Model.UserEntity;
import com.nibid.chat_app.Service.IUserService;
import com.nibid.chat_app.Utils.ApiConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.USER)
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(ApiConstant.FIND_ALL_USER)
    public List<UserEntity> findAllUser(String email) {
        return userService.findAllUser(email);
    }
}
