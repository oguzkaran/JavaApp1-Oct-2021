package org.csystem.app.security.service.admin.data.entity;

import javax.persistence.*;
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

    public boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
    public Set<MemberRole> memberRoles;

    //...
}
