package com.fpt.tomamy.modules.usermanagement.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fpt.tomamy.controller.BaseWeb;
import com.fpt.tomamy.modules.usermanagement.model.Role;
import com.fpt.tomamy.modules.usermanagement.model.User;
import com.fpt.tomamy.modules.usermanagement.service.RoleService;
import com.fpt.tomamy.modules.usermanagement.service.UserService;
import com.fpt.tomamy.modules.usermanagement.validation.UserValidation;



@Controller("UserManagerController")
@RequestMapping(value = {"/usermanager"})
public class UserManagerController extends BaseWeb {	
	@Autowired
	UserService user;
	
	
	@Autowired
	private RoleService roleService;

	
	private static final Logger log = Logger.getLogger(UserManagerController.class);
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(ModelMap model,HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		List <User> list = user.getList();
		model.put("usi", list);
		log.info(u.getUsername());
		return "usermanagement.home";
	}
	public String name(){
		return "UserController";
	}
	
	@RequestMapping(value = "/add-a-newUser", method = RequestMethod.GET)
	public String addUser(ModelMap model, HttpSession session){
		User u=(User) session.getAttribute("currentUser");
		//RequestBatchContainerDelivery r = (RequestBatchContainerDelivery) session.getAttribute("currentRequestBatchContainerDelivery");
		//List<RequestBatchContainerDelivery> list = requestBatchContainerDeliveryService.getList();
		//model.put("rqi", list);
		System.out.println(name() + "::addUser start");
		model.put("userValidation",new UserValidation());

		log.info(u.getUsername());
		return "usermanagement.addUser";
	}
	
	
	
	@RequestMapping(value = "/save-a-newUser", method = RequestMethod.POST)
	public String saveAnUser(HttpServletRequest request, @Valid @ModelAttribute("userForm") UserValidation userForm , BindingResult result, Model model, HttpSession session){
		model.addAttribute("username", userForm.getUsername());
		model.addAttribute("password", userForm.getPassword());
		model.addAttribute("repassword", userForm.getRepassword());
//		model.addAttribute("orderPickupDeliveryFormAdd", new mOrderPickupDeliveryFormAdd());
		
		if(result.hasErrors()){
			log.info("FAIL");
			return "add-a-newUser";
		}
		if(user.getByUsername(userForm.getUsername()) !=null){
			model.addAttribute("status", "Username exist");
			model.addAttribute("userForm", new UserValidation());
			log.info("FAIL");
			return "add-a-newUser";
		
		}
		if(!userForm.getPassword().equals(userForm.getRepassword())){
			model.addAttribute("status","password and repassword not match");
			model.addAttribute("userForm", new UserValidation());
			log.info("FAIL");
			return "add-a-newUser";
		}
		try{
			String username = userForm.getUsername();
			String password = DigestUtils.md5Hex(userForm.getPassword());
			
			Role role = roleService.getByName("ROLE_USER");
			HashSet<Role> roles = new HashSet<Role>();
			roles.add(role);
			user.save(username, password, roles);
			
			
		}catch(Exception e){
			model.addAttribute("status", "You failed to create new account");
			model.addAttribute("userForm", new UserValidation());
			return "add-a-newUser";
		}
		model.addAttribute("status", "You have register successfully the account, please login to continue");
		log.info(userForm.getUsername() +"DONE");
		return "login";
	}
		


	

	
	

}

