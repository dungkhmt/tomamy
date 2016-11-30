package com.fpt.tomamy.modules.relief.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fpt.tomamy.controller.BaseWeb;
import com.fpt.tomamy.modules.reliefdemand.controller.ReliefDemandController;
import com.fpt.tomamy.modules.usermanagement.model.User;

@Controller("ReliefController")
@RequestMapping(value = {"/relief"})
public class ReliefController extends BaseWeb{
	private static final Logger log = Logger.getLogger(ReliefController.class);
	
	public String name(){
		return "ReliefController";
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String reliefHome(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		System.out.println(name() + "::reliefHome, user = " + u.getUsername());
		//List<ReliefDemand> list= reliefDemandService.list();
		//model.put("reliefdemandlist", list);
		log.info(u.getUsername());
		return "relief.home";
	}
}
