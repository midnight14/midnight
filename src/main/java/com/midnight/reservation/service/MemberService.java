package com.midnight.reservation.service;

import com.midnight.reservation.dto.MemberDTO;
import com.midnight.reservation.entity.Member;
import com.midnight.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public void registMember(MemberDTO newMember) {

        Member member =  modelMapper.map(newMember, Member.class);

        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);
    }

    public Boolean login(String id, String password, HttpServletRequest request) {

        Optional<Member> member = memberRepository.findById(id);

        if(member.isPresent()) {

            if(passwordEncoder.matches(password, member.get().getPassword())) {
                request.getSession().setAttribute("id", member.get().getId());
                request.getSession().setAttribute("password", member.get().getPassword());
                request.getSession().setAttribute("pregnancyCycle", member.get().getPregnancyCycle());

                return true;
            }
            else return false;
        }

        return false;
    }
}
