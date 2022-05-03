package org.csystem.app.security.service.admin.data.dal;

import org.csystem.app.security.service.admin.data.entity.Member;
import org.csystem.app.security.service.admin.data.repository.IMemberRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class SystemAdminAppHelper {
    private final IMemberRepository m_memberRepository;

    public SystemAdminAppHelper(IMemberRepository memberRepository)
    {
        m_memberRepository = memberRepository;
    }

    public Member saveMember(Member m)
    {
        return m_memberRepository.save(m);
    }


    public Optional<Member> findMemberByEnabledAndUsernameAndPassword(boolean enabled, String username, String password)
    {
        return m_memberRepository.findByEnabledAndUsernameAndPassword(enabled, username, password);
    }

    public Iterable<Member> findMemberByEnabled(boolean enabled)
    {
        return m_memberRepository.findByEnabled(enabled);
    }

    public Iterable<Member> findMemberByRegisterDate(LocalDate registerDate)
    {
        return m_memberRepository.findByRegisterDate(registerDate);
    }

    public Iterable<Member> findMemberByYear(int year)
    {
        return m_memberRepository.findByYear(year);
    }
}
