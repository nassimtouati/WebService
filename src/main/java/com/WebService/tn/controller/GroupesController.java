package com.WebService.tn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.WebService.tn.database.model.Groupes;
import com.WebService.tn.service.GroupesService;
import com.WebService.tn.service.MemberService;


@Controller
@RequestMapping("groupes")
public class GroupesController {
	@Autowired 
	GroupesService groupeService;
	
	@Autowired
	MemberService memberService;
	
	 
	 @RequestMapping(value = "/pageT", method = RequestMethod.GET)
	    public ModelAndView getPage() {
		 
		 ModelAndView view = new ModelAndView("groupes");
		 view.addObject("user", getUser());  
	        
	        return view;
	    }
	 
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	    public @ResponseBody Map<String, Object> getSaved(Groupes groupes) {
	        Map<String, Object> map = new HashMap<String, Object>();
	 
	        memberService.ajouterMembre(groupes.getName(), getUser(), "Admin");
	        if (groupeService.saveOrUpdate(groupes)) {
	            map.put("status", "200");
	            map.put("message", "Your record have been saved successfully");
	            System.out.println("dfgjhkd  "+groupes.getName());
	            
	        }
	     
	        return map;
	    }
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getAll(Groupes groupes) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        List<Groupes> list = groupeService.list(getUser());
 
        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");
 
        }
 
        return map;
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> delete(Groupes groupes) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        if (groupeService.delete(groupes)) {
            map.put("status", "200");
            map.put("message", "Your record have been deleted successfully");
        }
 
        return map;
    }
    
    
    @RequestMapping (value="/notMemeber", method=RequestMethod.GET)
    public String afficher( ModelMap pModel){
    	
    	List <Groupes>groupe=groupeService.listTout(getUser());
    	pModel.addAttribute("groupe", groupe);
    	
    	return "rejoindre";
    	
    }
    
    @RequestMapping(value="/souscrire", method = RequestMethod.GET)
  public String souscrire(@RequestParam(value="idGroupe") final String pIdGroupe, final ModelMap pModel) {
  	
      memberService.ajouterMembre(pIdGroupe, getUser(), "Member");
      return afficher(pModel);
  }

    private String getUser() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
