package com.fpt.tomamy.modules.relief.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fpt.tomamy.controller.BaseWeb;
import com.fpt.tomamy.modules.goods.model.Good;
import com.fpt.tomamy.modules.goods.service.GoodService;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;
import com.fpt.tomamy.modules.regionmanagement.service.CommuneService;
import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.service.ReliefService;
import com.fpt.tomamy.modules.relief.validation.ReliefDetailAddForm;
import com.fpt.tomamy.modules.reliefdemand.controller.ReliefDemandController;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.validation.ReliefDemandGoodForm;
import com.fpt.tomamy.modules.relieforganization.model.ReliefOrganization;
import com.fpt.tomamy.modules.relieforganization.service.ReliefOrganizationService;
import com.fpt.tomamy.modules.reliefsession.model.ReliefSession;
import com.fpt.tomamy.modules.reliefsession.service.ReliefSessionService;
import com.fpt.tomamy.modules.usermanagement.model.User;

@Controller("ReliefController")
@RequestMapping(value = {"/relief"})
public class ReliefController extends BaseWeb{
	private static final Logger log = Logger.getLogger(ReliefController.class);
	
	@Autowired
	ReliefService reliefService;
	
	@Autowired
	ReliefSessionService reliefSessionService;
	
	@Autowired
	ReliefOrganizationService reliefOrganizationService;
	
	@Autowired
	GoodService goodService;
	
	@Autowired
	CommuneService communeService;
	
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
	@RequestMapping(value="/list-relief",method=RequestMethod.GET)
	public String listRelief(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		System.out.println(name() + "::listRelief, user = " + u.getUsername());
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService.list();
		
		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrganizations", reliefOrganizations);
		log.info(u.getUsername());
		return "relief.list";
	}
	@RequestMapping(value="/add-a-relief",method=RequestMethod.GET)
	public String addAReliefHome(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService.list();
		List<Good> goods = goodService.list();
		List<Commune> communes = communeService.list();
		
		model.put("communes", communes);
		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrganizations", reliefOrganizations);
		model.put("goods", goods);
		model.put("ReliefDetailAddForm", new ReliefDetailAddForm());
		return "relief.add";
	}
	
	@RequestMapping(value="/save-a-relief",method=RequestMethod.POST)
	public String saveAReliefDetailHome(ModelMap model,HttpSession session,
			HttpServletRequest request, @ModelAttribute("ReliefDetailAddForm") ReliefDetailAddForm form,BindingResult result){
		User u=(User) session.getAttribute("currentUser");
		System.out.println(name() + "::saveAReliefDetailForm, reliefSession = " + form.getReliefSessionCode());
		System.out.println(name() + "::saveAReliefDetailForm, commune = " + form.getCommuneCode());
		System.out.println(name() + "::saveAReliefDetailForm, date = " + form.getDate());
		System.out.println(name() + "::saveAReliefDetailForm, organization = " + form.getReliefOrganizationCode());
		System.out.println(name() + "::saveAReliefDetailForm, good = " + form.getGoodCode());
		
		String date = form.getDate();
		int money = form.getMoney();
		double quantity = form.getQuantity();
		
		Relief rl = reliefService.getRelief(form.getReliefSessionCode(), form.getReliefOrganizationCode(), form.getCommuneCode());
		if(rl == null){
			reliefService.saveARelief(form.getReliefSessionCode(), form.getReliefOrganizationCode(), form.getCommuneCode(), u.getUsername());
		}
		rl = reliefService.getRelief(form.getReliefSessionCode(), form.getReliefOrganizationCode(), form.getCommuneCode());
		
		int id = reliefService.saveAReliefDetail(rl.getRLF_Code(), form.getGoodCode(), date, quantity,
				money, u.getUsername());
		
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService.list();
		List<Good> goods = goodService.list();
		List<Commune> communes = communeService.list();
		
		model.put("communes", communes);
		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrganizations", reliefOrganizations);
		model.put("goods", goods);
		model.put("ReliefDetailAddForm", new ReliefDetailAddForm());
		
		return "relief.add";
	}

}
