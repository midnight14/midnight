package com.midnight.reservation.service;

import com.midnight.reservation.dto.CustomUser;
import com.midnight.reservation.entity.Member;
import com.midnight.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberRepository memberRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<Member> member = memberRepository.findById(username);

        if(!member.isPresent()) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        CustomUser customUser = new CustomUser(member.get(), authorities);

        return customUser;
    }

    public Map<String, List<String>> getPermitListMap() {

        Map<String, List<String>> permitListMap = new HashMap<>();
        List<String> adminPermitList = new ArrayList<>();
        List<String> memberPermitList = new ArrayList<>();

//        memberPermitList.add("/member/my-page");
//        memberPermitList.add("/member/secession");
//        memberPermitList.add("/report/**");
//        memberPermitList.add("/request/**");
//        memberPermitList.add("/review/review");
//        memberPermitList.add("/review/report");
//
//        adminPermitList.add("/member/admin-page");
//        adminPermitList.add("/member/admin-list");
//        adminPermitList.add("/stat/**");
//        adminPermitList.add("/admin-page/**");
//
//        permitListMap.put("adminPermitList", adminPermitList);
//        permitListMap.put("memberPermitList", memberPermitList);

        return permitListMap;
    }
}
