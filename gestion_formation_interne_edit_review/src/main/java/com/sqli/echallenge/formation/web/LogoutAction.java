package com.sqli.echallenge.formation.web;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class LogoutAction extends SqliBasicAction {
	private static final long serialVersionUID = 37266371781630436L;
	
	@Override
	public String execute() throws Exception {
		//Destroy Session And Redirect to Login
		sessionDestroy();
		
		return ActionSupport.SUCCESS;
	}
}
