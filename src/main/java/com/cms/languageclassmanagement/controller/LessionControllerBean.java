package com.cms.languageclassmanagement.controller;

import com.cms.languageclassmanagement.model.Lession;
import com.cms.languageclassmanagement.model.Period;
import com.cms.languageclassmanagement.model.Teacher;
import com.cms.languageclassmanagement.service.PeriodService;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Scope("session")
@Named(value = "lessionController")
@Join(path = "/lessions", to = "/lessions.jsf")
public class LessionControllerBean {
    @Autowired
    private PeriodService periodService;

    private Set<Lession> lessionSet ;

    public String lessionpage() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String periodid = request.getParameter("periodid");
   Period pr=   periodService.findPeriodById(Integer.valueOf(periodid));

;
        List<Lession> list = new ArrayList<>(pr.getLession());
        if(list != null || list.size() != 0) {
            Collections.reverse(list);
            this.lessionSet = new HashSet<>(list);
        }
        //?faces-redirect=true
        return"/lessions.xhtml";
    }

    public Set<Lession> getLessionSet() {

        return lessionSet;

    }
}
