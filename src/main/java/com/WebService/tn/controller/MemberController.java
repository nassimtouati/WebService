package com.WebService.tn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.WebService.tn.database.model.Groupes;
import com.WebService.tn.database.model.Memebers;
import com.WebService.tn.service.GroupesService;
import com.WebService.tn.service.MemberService;

@Controller
@RequestMapping("Members")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	GroupesService groupesService;
	
	
	@RequestMapping (value="/lesgroupes", method=RequestMethod.GET)
    public String afficher( ModelMap pModel){
    	
    	List <Groupes>groupe=groupesService.listgroupe();
    	pModel.addAttribute("groupe", groupe);
    	
    	return "groupeMembers";
    	
    }
    
    @RequestMapping(value="/lesMembres", method = RequestMethod.GET)
  public String souscrire(@RequestParam(value="idGroupe") final String pIdGroupe, final ModelMap pModel) {
  	
      List<Memebers> memeber= memberService.afficherMembers(pIdGroupe);
      pModel.addAttribute("memeber", memeber);
      
      return "detailMemeber";
      
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
