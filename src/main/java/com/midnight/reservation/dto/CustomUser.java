package com.midnight.reservation.dto;

import com.midnight.reservation.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private String id;
    private String password;
    private String pregnancyCycle;

    public CustomUser(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getId(), member.getPassword(), authorities);

        setDetails(member);
    }
    private void setDetails(Member member) {
        this.id = member.getId();
        this.password = member.getPassword();
        this.pregnancyCycle = member.getPregnancyCycle();
    }


}
