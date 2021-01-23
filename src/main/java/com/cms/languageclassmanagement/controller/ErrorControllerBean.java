package com.cms.languageclassmanagement.controller;

import org.ocpsoft.rewrite.annotation.Join;

import javax.inject.Named;

@Named(value = "errorController")
@Join(path = "/error", to = "/error.jsf")

public class ErrorControllerBean {
}
