package com.bsu.ugame.gameparams.api.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 利用加密算法生成密码
 */
@RestController
public class Password {
    @GetMapping("/user/makepwd")
    public String makeBCryptPassword(@RequestParam String opwd){
        String password = new BCryptPasswordEncoder().encode(opwd);
        System.out.println(password);
        return password;
    }

}
