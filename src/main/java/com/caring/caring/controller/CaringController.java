package com.caring.caring.controller;

import com.caring.caring.controller.path.ApiPath;
import com.caring.caring.dto.Elder;
import com.caring.caring.dto.Login;
import com.caring.caring.dto.Signup;
import com.caring.caring.entity.Member;
import com.caring.caring.service.CaringService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CaringController {

    private String password;

    private final CaringService caringService;

    @GetMapping(ApiPath.START)
    public String start() {
        return "START";
    }

    @PostMapping(ApiPath.SIGNUP)
    public boolean signup(
            @Valid @RequestBody Signup signup
            ) {
        return caringService.signup(signup);
    }

    @PostMapping(ApiPath.LOGIN)
    public boolean login(
            @Valid @RequestBody Login login
    ) {
        return caringService.login(login);
    }

    @GetMapping(ApiPath.GETMEMBER)
    public Member getMember(
            @PathVariable String email
    ) {
        return caringService.getMember(email);
    }

    @PutMapping(ApiPath.SETELDER)
    public void editElder(
            @Valid @RequestBody Elder elder
    ) {
        caringService.editElder(elder);
    }

    @PostMapping(ApiPath.SETPASSWORD)
    public void setPassword(
            @PathVariable String password
    ) {
        this.password = password;
    }

    @GetMapping(ApiPath.GETPASSWORD)
    public String getPassword() {
        return this.password;
    }

}
