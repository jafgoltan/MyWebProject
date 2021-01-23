package com.cms.languageclassmanagement.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "language")
@Access(AccessType.FIELD)
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name="lang_name")
    private String langname;
    //cascade =CascadeType.ALL
    @OneToMany(mappedBy = "language",cascade = CascadeType.ALL)
    private Set<Period> peroid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangname() {
        return langname;
    }

    public void setLangname(String langname) {
        this.langname = langname;
    }

    public Set<Period> getPeroid() {
        return peroid;
    }

    public void setPeroid(Set<Period> peroid) {
        this.peroid = peroid;
    }
}
