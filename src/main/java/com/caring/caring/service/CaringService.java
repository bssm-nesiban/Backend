package com.caring.caring.service;

import com.caring.caring.dto.Elder;
import com.caring.caring.dto.Login;
import com.caring.caring.dto.Signup;
import com.caring.caring.entity.Member;
import com.caring.caring.exception.MemberException;
import com.caring.caring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CaringService {

    private final MemberRepository memberRepository;

    @Transactional
    public boolean signup(Signup signup) {
        memberRepository.findById(signup.getEmail())
                .ifPresent((member -> {throw new MemberException("이미 존재하는 아이디입니다.");}));

        Member member = Member.builder()
                .email(signup.getEmail())
                .password(signup.getPassword())
                .nickname(signup.getNickname())
                .build();

        memberRepository.save(member);
        return true;
    }

    public boolean login(Login login) {
        memberRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(() -> new MemberException("존재하지 않는 유저입니다."));

        return true;
    }

    public Member getMember(String email) {
        return memberRepository.findById(email)
                .orElseThrow(() -> new MemberException("존재하지 않는 유저입니다."));
    }

    @Transactional
    public void editElder(Elder elder) {
        Member member = getMember(elder.getEmail());
        member.setElder(elder.getName());
        member.setPhoneNumber(elder.getPhoneNumber());
    }

}
