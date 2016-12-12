package com.fpt.tomamy.modules.reliefdemand.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.tomamy.controller.BaseWeb;
import com.fpt.tomamy.modules.goods.model.Good;
import com.fpt.tomamy.modules.goods.service.GoodService;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;
import com.fpt.tomamy.modules.regionmanagement.service.CommuneService;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemand;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetail;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandDetailFullInfo;
import com.fpt.tomamy.modules.reliefdemand.model.ReliefDemandFullInfo;
import com.fpt.tomamy.modules.reliefdemand.service.ReliefDemandService;
import com.fpt.tomamy.modules.reliefdemand.validation.ReliefDemandGoodForm;
import com.fpt.tomamy.modules.reliefsession.model.ReliefSession;
import com.fpt.tomamy.modules.reliefsession.service.ReliefSessionService;
import com.fpt.tomamy.modules.usermanagement.model.User;


import java.net.URLEncoder;


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
	
	@Autowired
	GoodService goodService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String reliefDemandHome(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		System.out.println(name() + "::reliefDemandHome, user = " + u.getUsername());
		//List<ReliefDemand> list= reliefDemandService.list();
		//model.put("reliefdemandlist", list);
		log.info(u.getUsername());
		return "reliefdemand.home";
	}
	@RequestMapping(value="/add-a-relief-demand",method=RequestMethod.GET)
	public String addAReliefDemandHome(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<Good> goods = goodService.list();
		List<Commune> communes = communeService.list();
		
		model.put("reliefSessions", reliefSessions);
		model.put("ReliefDemandGoodForm", new ReliefDemandGoodForm());
		model.put("communes", communes);
		model.put("goods", goods);
		
		return "reliefdemand.add";
	}

	@RequestMapping(value="/save-a-relief-demand",method=RequestMethod.POST)
	public String saveAReliefDemandHome(ModelMap model,HttpSession session,
			HttpServletRequest request, @ModelAttribute("ReliefDemandGoodForm") ReliefDemandGoodForm form,BindingResult result){
		User u=(User) session.getAttribute("currentUser");
		System.out.println(name() + "::saveAReliefDemandForm, reliefSession = " + form.getReliefSessionCode());
		System.out.println(name() + "::saveAReliefDemandForm, commune = " + form.getCommuneCode());
		
		ReliefDemand rd = reliefDemandService.getReliefDemand(form.getReliefSessionCode(), form.getCommuneCode());
		if(rd == null){
			reliefDemandService.saveAReliefDemand(form.getReliefSessionCode(), form.getCommuneCode(),u.getUsername());
		}
		rd = reliefDemandService.getReliefDemand(form.getReliefSessionCode(), form.getCommuneCode());
		
		int id = reliefDemandService.saveAReliefDemandDetail(rd.getRLFDM_Code(), form.getGoodCode(), form.getQuantity(),u.getUsername());
		
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<Good> goods = goodService.list();
		List<Commune> communes = communeService.list();
		
		model.put("reliefSessions", reliefSessions);
		model.put("ReliefDemandGoodForm", new ReliefDemandGoodForm());
		model.put("communes", communes);
		model.put("goods", goods);
		
		return "reliefdemand.add";
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
		
		
		
		List<ReliefDemandFullInfo> lstReliefDemandDetail = new ArrayList<ReliefDemandFullInfo>();
		for(ReliefDemand rd: list){
			ReliefDemandFullInfo rdd = new ReliefDemandFullInfo();
			rdd.setRLFDM_CommuneName(mCode2Commune.get(rd.getRLFDM_CommuneCode()).getCOM_Name());
			rdd.setRLFDM_ReliefSessionCode(rd.getRLFDM_ReliefSessionCode());
			lstReliefDemandDetail.add(rdd);
		}
		System.out.println(name() + "::listReliefDemandHome, user = " + u.getUsername() + ", GOT list = " + list.size());
		for(ReliefDemandFullInfo rdd: lstReliefDemandDetail){
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
	
	@ResponseBody @RequestMapping(value="/get-relief-goods", method=RequestMethod.POST)
	public String getReliefGoods(HttpSession session,
			@RequestParam(value="reliefdemandcode", defaultValue="0")String reliefdemandcode){
		User u=(User) session.getAttribute("currentUser");
		log.info(u.getUsername());
		
		//List<Good> G = reliefDemandService.listGoodsDemand(reliefdemandcode);
		//System.out.println(name() + "::getReliefGoods, reliefdemandcode = " + reliefdemandcode + ", G = " + G.size());
		List<ReliefDemandDetailFullInfo> G = reliefDemandService.listReliefDemandDetailFullInfo(reliefdemandcode);
		
		String json = "{";
		json += "\"demands\":[";
		for(int i = 0; i < G.size(); i++){
			String encodeName = java.net.URLEncoder.encode(G.get(i).getRLFDMDT_GoodName());
			double quantity = G.get(i).getRLFDMDT_Quantity();
			String unit = java.net.URLEncoder.encode(G.get(i).getRLFDMDT_GoodUnit());
			json += "{\"item\":{\"name\":\"" + encodeName + "\",\"unit\":\"" + unit + "\",\"quantity\":" + quantity + "}}";
			if(i < G.size()-1)
				json += ",";
		}
		json += "]";
				json += "}";
		System.out.println(name() + "::getReliefGoods, json = " + json);		
		return json;
	}
	@ResponseBody @RequestMapping(value="/get-relief-communes", method=RequestMethod.POST)
	public String getReliefCommunes(HttpSession session,
			@RequestParam(value="reliefsession", defaultValue="0")String reliefSessionCode){
		User u=(User) session.getAttribute("currentUser");
		log.info(u.getUsername());
		System.out.println(name() + "::getReliefCommunes, session = " + reliefSessionCode);
		List<ReliefDemandFullInfo> list = reliefDemandService.list(reliefSessionCode);
		
		double center_lat = 0;
		double center_lng = 0;
		
		String json = "{"
				+ "\"communes\":[";
		for(int i = 0; i < list.size(); i++){
			ReliefDemandFullInfo rdi = list.get(i);
			//List<Good> G = reliefDemandService.listGoodsDemand(rdi.getRLFDM_Code());
			//System.out.println(name() + "::getReliefCommunes, rdi code = " + rdi.getRLFDM_Code() + ", goods = " + G.size());
			//String info = "";
			//for(Good g: G){
			//	info += g.getGOD_Name() + "\n";
			//}
			
			
			String[] s = list.get(i).getRLFDM_CommuneLatLng().split(",");
			double lat = Double.valueOf(s[0].trim());
			double lng = Double.valueOf(s[1].trim());
			center_lat += lat;
			center_lng += lng;
			json += "{\"lat\":" + lat + 
					",\"lng\":" + lng + 
					",\"infocode\":\"" + rdi.getRLFDM_Code() + "\"" +
					"}";
			//json += "{\"latlng\":\"" + list.get(i).getRLFDM_CommuneLatLng() + "\"}";
			if(i < list.size()-1)
				json += ",";
		}
		center_lat = center_lat/list.size();
		center_lng = center_lng/list.size();
		
		json += "]";
		json += ",\n\"center_lat\":" + center_lat + ",\"center_lng\":" + center_lng;
		json += "}";
		System.out.println(name() + "::getReliefCommunes, json = " + json);
		return json;
	}
	public String name(){
		return "ReliefDemandController";
	}
}

