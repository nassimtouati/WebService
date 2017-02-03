package com.WebService.tn.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.WebService.tn.database.model.User;
import com.WebService.tn.service.UsersDeleteServices;

@Controller
@RequestMapping("users")
public class DeleteController {
	 @Autowired
	    UsersDeleteServices userServices;
	 
	    @RequestMapping(value = "/DELETEX", method = RequestMethod.GET)
	    public ModelAndView getPage() {
	        ModelAndView view = new ModelAndView("Delete");
	        return view;
	    }
	 
	    @RequestMapping(value = "/deletenew", method = RequestMethod.POST)
	    public @ResponseBody Map<String, Object> delete(User user) {
	        Map<String, Object> map = new HashMap<String, Object>();
	 
	        if (userServices.delete(user)) {
	            map.put("status", "200");
	            map.put("message", "Your record have been deleted successfully");
	        }
	 
	        return map;
	    }
	    
	}
