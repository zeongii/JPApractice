package com.example.ex1_hello_jpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {

    @Id
    private String id;

    private Long age;

    @Column(name = "name")
    private String userName;

    /*

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    */


    public String getId() {
        return id;
    }

    public Long getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Member() {

    }


}
