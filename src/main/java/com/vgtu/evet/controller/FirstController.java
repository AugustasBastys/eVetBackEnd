package com.vgtu.evet.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping("/webapiB")
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_Test-API')")
    public String file() {
        return "Response from Test-API.";
    }

    @GetMapping("/user")
    @ResponseBody
    @PostAuthorize("hasAuthority('SCOPE_Test-API')")
    public String user() {
        return "User read success.";
    }

    @GetMapping("/webapiB/clientCredential")
    @PreAuthorize("hasAuthority('APPROLE_WebApiB.ClientCredential.ExampleScope')")
    @ResponseBody
    public String clientCredential() {
        return "Response from webApiB: clientCredential";
    }

}
