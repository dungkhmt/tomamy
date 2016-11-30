package com.fpt.tomamy.modules.reliefdemand.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.tomamy.controller.BaseWeb;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;
import com.fpt.tomamy.modules.regionmanagement.service.CommuneService;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;
import com.fpt.tomamy.modules.reliefdemand.service.ReliefDemandService;
import com.fpt.tomamy.modules.reliefsession.model.ReliefSession;
import com.fpt.tomamy.modules.reliefsession.service.ReliefSessionService;
import com.fpt.tomamy.modules.usermanagement.model.User;



@Controller("ReliefDemandController")
@RequestMapping(value = {"/reliefdemand"})
public class ReliefDemandController extends BaseWeb{
	private static final Logger log = Logger.getLogger(ReliefDemandController.class);
	
	@Autowired
	ReliefDemandService reliefDemandService;
	
	@Autowired
	CommuneService communeService;
	
	@Autowired
	ReliefSessionService reliefSessionService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String reliefDemandHome(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		System.out.println(name() + "::reliefDemandHome, user = " + u.getUsername());
		//List<ReliefDemand> list= reliefDemandService.list();
		//model.put("reliefdemandlist", list);
		log.info(u.getUsername());
		return "reliefdemand.home";
	}
	@RequestMapping(value="/list-relief-demand",method=RequestMethod.GET)
	public String listReliefDemandHome(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		
		List<ReliefDemand> list= reliefDemandService.list();
		List<Commune> lstCommunes = communeService.list();
		HashMap<String, Commune> mCode2Commune = new HashMap<String, Commune>();
		for(Commune c: lstCommunes){
			mCode2Commune.put(c.getCOM_Code(), c);
		}
		
		List<ReliefDemandDetail> lstReliefDemandDetail = new ArrayList<ReliefDemandDetail>();
		for(ReliefDemand rd: list){
			ReliefDemandDetail rdd = new ReliefDemandDetail();
			rdd.setRLFDM_CommuneName(mCode2Commune.get(rd.getRLFDM_CommuneCode()).getCOM_Name());
			rdd.setRLFDM_ReliefSessionCode(rd.getRLFDM_ReliefSessionCode());
			lstReliefDemandDetail.add(rdd);
		}
		System.out.println(name() + "::listReliefDemandHome, user = " + u.getUsername() + ", GOT list = " + list.size());
		for(ReliefDemandDetail rdd: lstReliefDemandDetail){
			System.out.println(rdd.getRLFDM_CommuneName());
		}
		
		for(ReliefSession rs: reliefSessions){
			System.out.println("Session " + rs.getRLFSS_Name());
		}
		model.put("reliefdemandlist", lstReliefDemandDetail);
		model.put("reliefsessions", reliefSessions);
		log.info(u.getUsername());
		return "reliefdemand.list";
	}
	
	@ResponseBody @RequestMapping(value="/get-relief-communes", method=RequestMethod.POST)
	public String getReliefCommunes(HttpSession session,
			@RequestParam(value="reliefsession", defaultValue="0")String reliefSessionCode){
		User u=(User) session.getAttribute("currentUser");
		log.info(u.getUsername());
		System.out.println(name() + "::getReliefCommunes, session = " + reliefSessionCode);
		List<ReliefDemandDetail> list = reliefDemandService.list(reliefSessionCode);
		String json = "{"
				+ "\"communes\":[";
		for(int i = 0; i < list.size(); i++){
			String[] s = list.get(i).getRLFDM_CommuneLatLng().split(",");
			json += "{\"lat\":" + Double.valueOf(s[0].trim()) + ",\"lng\":" + Double.valueOf(s[1].trim()) + "}";
			//json += "{\"latlng\":\"" + list.get(i).getRLFDM_CommuneLatLng() + "\"}";
			if(i < list.size()-1)
				json += ",";
		}
		json += "]}";
		System.out.println(name() + "::getReliefCommunes, json = " + json);
		return json;
	}
	public String name(){
		return "ReliefDemandController";
	}
}

