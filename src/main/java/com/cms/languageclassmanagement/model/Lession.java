package com.cms.languageclassmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "lessions")
@Access(AccessType.FIELD)
public class Lession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name="lession_subject")
    private String subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "lession_period")

    private Period period;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}
