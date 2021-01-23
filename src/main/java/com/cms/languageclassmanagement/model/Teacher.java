package com.cms.languageclassmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Access(AccessType.FIELD)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(unique = true,name="teacher_name")

    private String teachrname;
    @Column
    private int age;
    @Column
    private String educationlevel;
    @Column
    private String language;
    @Column
    private String phonenumber;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Period> periodSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeachrname() {
        return teachrname;
    }

    public void setTeachrname(String teachrname) {
        this.teachrname = teachrname;
    }

    public Set<Period> getPeriodSet() {
        return periodSet;
    }

    public void setPeriodSet(Set<Period> periodSet) {
        this.periodSet = periodSet;
    }
}
