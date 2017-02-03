package com.WebService.tn.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.WebService.tn.database.model.Commentaire;
import com.WebService.tn.database.model.Groupes;
import com.WebService.tn.form.CommentaireForm;
import com.WebService.tn.service.CommentaireService;
import com.WebService.tn.service.GroupesService;
import com.WebService.tn.service.MemberService;

@Controller
@RequestMapping("commentaire")
public class CommentaireController {
	
	@Autowired 
	GroupesService groupeService;
	
	@Autowired
	MemberService memberService;
	
	
	@Autowired
	CommentaireService comService;
	
	
	
	@RequestMapping (value="/toutlesgroup", method=RequestMethod.GET)
    public String afficher( ModelMap pModel){
    	
    	List <Groupes>groupe=groupeService.listgroupe();
    	pModel.addAttribute("groupe", groupe);
    	
    	return "groupelist";
    	
    }
	
	
	@RequestMapping(value="/afficherCommentaire", method = RequestMethod.GET)
    public String afficherCommentaire(final ModelMap pModel ,@RequestParam(value="idGroupe") final String pIdGroupe) {
        final List<Commentaire> lListeComm =comService.afficherCommentaire(pIdGroupe);
        pModel.addAttribute("lListeComm", lListeComm);
        pModel.addAttribute("user", getUser());
        pModel.addAttribute("groupe_name",pIdGroupe);
        
        if (pModel.get("creationCommentaire") == null) {
            pModel.addAttribute("creationCommentaire", new CommentaireForm());
        }
        
        return "creationCommentaire";
    }

    @RequestMapping(value="/ajouterCommentaire", method = RequestMethod.POST)
    public String creer( @ModelAttribute(value="creationCommentaire") final CommentaireForm pCreation, 
            final BindingResult pBindingResult, final ModelMap pModel) {

     System.out.println("gf  "+pCreation.getGroup_name());
     System.out.println("gf  "+pCreation.getCommentaire());
     
           comService.ajouterCom(pCreation.getGroup_name(), getUser(), pCreation.getCommentaire());
        
        return afficherCommentaire(pModel,pCreation.getGroup_name());
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
