package com.nibid.chat_app.Controller;

import com.nibid.chat_app.Model.UserEntity;
import com.nibid.chat_app.Security.Auth.JwtGenerator;
import com.nibid.chat_app.Security.Model.JwtUser;
import com.nibid.chat_app.Service.IUserService;
import com.nibid.chat_app.Utils.ApiConstant;
import com.nibid.chat_app.Utils.BCryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private IUserService userService;
    private JwtGenerator jwtGenerator;

    @Autowired
    public LoginController(IUserService userService, JwtGenerator jwtGenerator) {
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping(ApiConstant.LOGIN)
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        UserEntity userEntity = userService.findByEmail(user.getEmail());
        if (userEntity == null) {
            return ResponseEntity.status(404).body("User not found.");
        }
        if (!BCryptUtils.match(user.getPassword(), userEntity.getPassword())) {
            return ResponseEntity.ok("Incorrect Email or Password.");
        }
        JwtUser jwtUser = new JwtUser();
        jwtUser.setId(userEntity.getId());
        jwtUser.setUserName(userEntity.getEmail());

        if (userEntity.getRoleStr() != null) {
            String role = userEntity.getRoleStr();
            jwtUser.setRole(role);
            user.setRoleStr(role);
        }

        user.setId(userEntity.getId());
        user.setToken(jwtGenerator.generate(jwtUser));
        user.setName(userEntity.getName());
        return ResponseEntity.ok(user);
    }

    @PostMapping(ApiConstant.REGISTER)
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        UserEntity userEntity = userService.findByEmail(user.getEmail());
        if (userEntity != null) {
            return ResponseEntity.status(403).body("Duplicate Entry.");
        }
        user.setPassword(BCryptUtils.bCrypt(user.getPassword()));
        this.userService.save(user);
        return ResponseEntity.ok(user);
    }

}
