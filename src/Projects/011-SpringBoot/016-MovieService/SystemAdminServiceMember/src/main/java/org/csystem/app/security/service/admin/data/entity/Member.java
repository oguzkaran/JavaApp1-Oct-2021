package org.csystem.app.security.service.admin.data.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member { //POJO (Plain Old Java Object)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public int id;

    @Column(length = 300, unique = true, nullable = false)
    public String username;

    @Column(length = 512, nullable = false)
    public String password;

    @Column(name = "first_name", length = 300, nullable = false)
    public String firstName;

    @Column(name = "middle_name", length = 300)
    public String middleName;

    @Column(name = "last_name",length = 300, nullable = false)
    public String lastName;

    @Column(nullable = false)
    public boolean enabled;

    @Column(name = "register_date", nullable = false)
    public LocalDate registerDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
    public Set<MemberRole> memberRoles;

    //...
}
