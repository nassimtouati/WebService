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

import com.WebService.tn.database.model.Users;
import com.WebService.tn.service.UsersService;

@Controller
@RequestMapping("users")
public class UsersDelete {
	 @Autowired
	    UsersService userServices;
	 
	    @RequestMapping(value = "/DELETE", method = RequestMethod.GET)
	    public ModelAndView getPage() {
	        ModelAndView view = new ModelAndView("DeleteAccount");
	        return view;
	    }
	 
	    @RequestMapping(value = "/delete111", method = RequestMethod.POST)
	    public @ResponseBody Map<String, Object> delete(Users users) {
	        Map<String, Object> map = new HashMap<String, Object>();
	 
	        if (userServices.delete(users)) {
	            map.put("status", "200");
	            map.put("message", "Your record have been deleted successfully");
	        }
	 
	        return map;
	    }
	    
	}
