package org.csystem.application.rest.postalcode.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "postal_codes")
public class PostalCode {
    @Id
    @Column(name = "postal_code")
    public int postalCode;

    @Column(name = "creation_date_time")
    public LocalDateTime creationDateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "postalCode", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<PostalCodeInfo> postalCodeInfos;

    public PostalCode()
    {}

    public PostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }
}
