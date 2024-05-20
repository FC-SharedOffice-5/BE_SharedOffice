package com.FC.SharedOfficePlatform.global.security;

import com.FC.SharedOfficePlatform.domain.member.entity.Member;
import com.FC.SharedOfficePlatform.global.security.enums.AuthorityCode;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
public class MemberDetails implements UserDetails {

    private final Long id;
    private final String email;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;


    public static MemberDetails create(Member member) {
        AuthorityCode authorityCode = getAuthorityByAuthCode(member.getAuthCode().getAuthCode());
        return MemberDetails.builder()
            .id(member.getId())
            .email(member.getEmail())
            .password(member.getPassword())
            .authorities(List.of(new SimpleGrantedAuthority(authorityCode.name())))
            .build();
    }

    private static AuthorityCode getAuthorityByAuthCode(int authCode) {
        switch (authCode) {
            case 0:
                return AuthorityCode.ROLE_SUPER_ADMIN;
            case 1:
                return AuthorityCode.ROLE_OFFICE_ADMIN;
            case 2:
                return AuthorityCode.ROLE_MEMBER;
            default:
                throw new IllegalArgumentException("유효하지 않은 인가 번호입니다" + authCode);
        }
    }

    public Long getId() { return id; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
