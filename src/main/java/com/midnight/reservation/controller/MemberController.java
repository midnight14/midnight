package com.midnight.reservation.controller;

import com.midnight.reservation.dto.CustomUser;
import com.midnight.reservation.dto.LoginRequest;
import com.midnight.reservation.dto.MemberDTO;
import com.midnight.reservation.service.AuthenticationService;
import com.midnight.reservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AuthenticationService userDetailsService;

    @PostMapping("/regist")
    public ResponseEntity registMember(@RequestBody MemberDTO member) {
        memberService.registMember(member);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/login")
    public Boolean login(@RequestBody Map<String, String> reqMap, HttpServletRequest request) {

        String id = (String) reqMap.get("id");
        String password = (String) reqMap.get("password");

        Boolean successStatus =  memberService.login(id, password, request);

        return successStatus;
    }
}
