package com.fpt.tomamy.modules.relief.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.tomamy.controller.BaseWeb;
import com.fpt.tomamy.modules.goods.model.Good;
import com.fpt.tomamy.modules.goods.service.GoodService;
import com.fpt.tomamy.modules.regionmanagement.model.Commune;
import com.fpt.tomamy.modules.regionmanagement.service.CommuneService;
import com.fpt.tomamy.modules.relief.model.Relief;
import com.fpt.tomamy.modules.relief.model.ReliefDetailFullInfo;
import com.fpt.tomamy.modules.relief.service.ReliefService;
import com.fpt.tomamy.modules.relief.validation.ReliefDetailAddForm;
import com.fpt.tomamy.modules.relieforganization.model.ReliefOrganization;
import com.fpt.tomamy.modules.relieforganization.service.ReliefOrganizationService;
import com.fpt.tomamy.modules.reliefsession.model.ReliefSession;
import com.fpt.tomamy.modules.reliefsession.service.ReliefSessionService;
import com.fpt.tomamy.modules.usermanagement.model.User;

@Controller("ReliefController")
@RequestMapping(value = { "/relief" })
public class ReliefController extends BaseWeb {
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

	public String name() {
		return "ReliefController";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String reliefHome(ModelMap model, HttpSession session) {
		User u = (User) session.getAttribute("currentUser");
		System.out.println(name() + "::reliefHome, user = " + u.getUsername());
		// List<ReliefDemand> list= reliefDemandService.list();
		// model.put("reliefdemandlist", list);
		log.info(u.getUsername());
		return "relief.home";
	}

	@RequestMapping(value = "/list-relief", method = RequestMethod.GET)
	public String listRelief(ModelMap model, HttpSession session) {
		User u = (User) session.getAttribute("currentUser");
		System.out.println(name() + "::listRelief, user = " + u.getUsername());
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService
				.list();

		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrganizations", reliefOrganizations);
		log.info(u.getUsername());
		return "relief.list";
	}

	@RequestMapping(value = "/list-relief-by-org", method = RequestMethod.GET)
	public String listReliefByOrg(ModelMap model, HttpSession session) {
		User u = (User) session.getAttribute("currentUser");
		System.out.println(name() + "::listRelief, user = " + u.getUsername());
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService
				.list();

		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrgs", reliefOrganizations);
		log.info(u.getUsername());
		return "relief.listByOrg";
	}

	@RequestMapping(value = "/add-a-relief", method = RequestMethod.GET)
	public String addAReliefHome(ModelMap model, HttpSession session) {
		User u = (User) session.getAttribute("currentUser");
		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService
				.list();
		List<Good> goods = goodService.list();
		List<Commune> communes = communeService.list();

		model.put("communes", communes);
		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrganizations", reliefOrganizations);
		model.put("goods", goods);
		model.put("ReliefDetailAddForm", new ReliefDetailAddForm());
		return "relief.add";
	}

	@RequestMapping(value = "/save-a-relief", method = RequestMethod.POST)
	public String saveAReliefDetailHome(ModelMap model, HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("ReliefDetailAddForm") ReliefDetailAddForm form,
			BindingResult result) {
		User u = (User) session.getAttribute("currentUser");
		System.out.println(name() + "::saveAReliefDetailForm, reliefSession = "
				+ form.getReliefSessionCode());
		System.out.println(name() + "::saveAReliefDetailForm, commune = "
				+ form.getCommuneCode());
		System.out.println(name() + "::saveAReliefDetailForm, date = "
				+ form.getDate());
		System.out.println(name() + "::saveAReliefDetailForm, organization = "
				+ form.getReliefOrganizationCode());
		System.out.println(name() + "::saveAReliefDetailForm, good = "
				+ form.getGoodCode());

		String date = form.getDate();
		int money = form.getMoney();
		double quantity = form.getQuantity();

		Relief rl = reliefService.getRelief(form.getReliefSessionCode(),
				form.getReliefOrganizationCode(), form.getCommuneCode());
		if (rl == null) {
			reliefService.saveARelief(form.getReliefSessionCode(),
					form.getReliefOrganizationCode(), form.getCommuneCode(),
					u.getUsername());
		}
		rl = reliefService.getRelief(form.getReliefSessionCode(),
				form.getReliefOrganizationCode(), form.getCommuneCode());

		int id = reliefService.saveAReliefDetail(rl.getRLF_Code(),
				form.getGoodCode(), date, quantity, money, u.getUsername());

		List<ReliefSession> reliefSessions = reliefSessionService.list();
		List<ReliefOrganization> reliefOrganizations = reliefOrganizationService
				.list();
		List<Good> goods = goodService.list();
		List<Commune> communes = communeService.list();

		model.put("communes", communes);
		model.put("reliefSessions", reliefSessions);
		model.put("reliefOrganizations", reliefOrganizations);
		model.put("goods", goods);
		model.put("ReliefDetailAddForm", new ReliefDetailAddForm());

		return "relief.add";
	}

	@ResponseBody
	@RequestMapping(value = "/get-relief-communes", method = RequestMethod.POST)
	public String getReliefCommunes(
			HttpSession session,
			@RequestParam(value = "reliefOrg", defaultValue = "0") String reliefOrganizationCode) {
		User u = (User) session.getAttribute("currentUser");
		log.info(u.getUsername());
		System.out.println(name() + "::getReliefCommunes, reliefOrg = "
				+ reliefOrganizationCode);

		List<Relief> reliefs = reliefService.list(reliefOrganizationCode);

		List<Commune> allCommunes = communeService.list();
		HashMap<String, Commune> communesMap = new HashMap<String, Commune>();
		for (Commune c : allCommunes) {
			communesMap.put(c.getCOM_Code(), c);
		}

		List<Commune> communes = new ArrayList<Commune>();
		for (Relief rl : reliefs) {
			String code = rl.getRLF_CommuneCode();
			Commune c = communesMap.get(code);
			communes.add(c);
		}

		double center_lat = 0;
		double center_lng = 0;
		int communesSize = communes.size();
		StringBuilder json = new StringBuilder("{\"communes\":[");
		String communeFormat = "{\"lat\": %f, \"lng\": %f, \"infocode\": \"%s\", \"infoname\": \"%s\"}";
		for (int i = 0; i < communesSize; i++) {
			Commune cm = communes.get(i);
			String[] s = cm.getCOM_LatLng().split(",");
			double lat = Double.valueOf(s[0].trim());
			double lng = Double.valueOf(s[1].trim());
			center_lat += lat;
			center_lng += lng;
			json.append(String.format(communeFormat, 
					lat, lng,
					cm.getCOM_Code(),
					java.net.URLEncoder.encode(cm.getCOM_Name())));
			if (i < communesSize - 1)
				json.append(", ");
		}
		json.append("], ");
		center_lat = center_lat / communesSize;
		center_lng = center_lng / communesSize;
		json.append("\"center_lat\":" + center_lat + ", \"center_lng\":"
				+ center_lng + "}");
		System.out.println(name() + "::getReliefCommunes, json = " + json);
		return json.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/get-relief-goods", method = RequestMethod.POST)
	public String getReliefGoodsForCommunes(HttpSession session,
			@RequestParam(value = "info", defaultValue = "0") String info) {
		User u = (User) session.getAttribute("currentUser");
		JSONParser parser = new JSONParser();

		String json = "{}";
		try {
			JSONObject o = (JSONObject) parser.parse(info);
			String communeCode = (String) o.get("communeCode");
			String reliefSessionCode = (String) o.get("reliefSessionCode");

			System.out.println(name()
					+ "::getReliefGoodsForCommune, communeCode = "
					+ communeCode + ", reliefSessionCode = "
					+ reliefSessionCode);

			List<ReliefDetailFullInfo> RDFI = reliefService
					.getReliefDetailForACommuneInOneReliefSession(
							reliefSessionCode, communeCode);

			json = "{";
			json += "\"reliefs\":[";
			for (int i = 0; i < RDFI.size(); i++) {
				ReliefDetailFullInfo rdfi = RDFI.get(i);
				json += "{\"good\":\""
						+ java.net.URLEncoder.encode(rdfi.getGoodName()) + "\"";
				json += ",\"quantity\":" + rdfi.getQuantity() + "";
				json += ",\"unit\":\""
						+ java.net.URLEncoder.encode(rdfi.getUnit()) + "\"";
				json += ",\"money\":" + rdfi.getMoney() + "";
				json += ",\"organization\":\""
						+ java.net.URLEncoder.encode(rdfi
								.getReliefOrganizationName()) + "\"";
				json += "}";
				if (i < RDFI.size() - 1)
					json += ",";

			}
			json += "]";
			json += "}";

			System.out.println(name()
					+ "::getReliefGoodsForCommunes, returned json = " + json);
			return json;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return json;
	}
}
