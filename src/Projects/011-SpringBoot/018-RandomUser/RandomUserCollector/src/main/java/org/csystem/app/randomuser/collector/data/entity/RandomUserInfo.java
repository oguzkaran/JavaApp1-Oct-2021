package org.csystem.app.randomuser.collector.data.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.jdbc.support.xml.XmlBinaryStreamProvider;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "random_user_info")
@TypeDef(name = "json", typeClass = JsonBinaryType.class)
public class RandomUserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "random_user_info_id")
    public int id;

    @Column(length = 256)
    public String first;

    @Column(length = 256)
    public String last;

    @Column(name = "save_datetime")
    public LocalDateTime saveDatetime = LocalDateTime.now();

    @Type(type = "json")
    @Column(columnDefinition = "json")
    public UserInfo userInfo;
}
