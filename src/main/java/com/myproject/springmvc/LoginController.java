package com.myproject.springmvc;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.models.User;
import com.myproject.services.Loginservice;

@Controller
public class LoginController {

	@Autowired
	Loginservice lginServ;
	
	@RequestMapping(value="/index")
	public String index(ModelMap model) {
		// TODO Auto-generated method stub
            return "login";
	}
	
	@RequestMapping(value="/loginUser" , method= {RequestMethod.POST})
//	@ResponseBody
	public String loginUser( @RequestParam("un")  String userName, @RequestParam("pw")  String password, ModelMap model /*, @PathVariable("key") String key*/) {
		User user = new User(userName, password);
		if(lginServ.validateUser(user))
            		return "welcome";
		else
		{
//			model.put("err", "Invalid username/password");
//			return "login";
			return "redirect:/index?err=Invalid username or password";
		}
			
	}
	
//	@RequestMapping(value="/user" , method= {RequestMethod.GET}, produces= "application/json" )
	@GetMapping(value="/user" , produces= "application/json")
	@ResponseBody
	public User getUser( @RequestParam("un")  String userName, @RequestParam("pw")  String password /*, @PathVariable("key") String key*/) {
		User user = new User(userName, password);
			return user;
	}
}
