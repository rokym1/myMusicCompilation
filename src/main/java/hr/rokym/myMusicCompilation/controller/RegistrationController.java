package hr.rokym.myMusicCompilation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.rokym.myMusicCompilation.entity.Authority;
import hr.rokym.myMusicCompilation.entity.User;
import hr.rokym.myMusicCompilation.newUser.NewUser;
import hr.rokym.myMusicCompilation.service.AuthorityService;
import hr.rokym.myMusicCompilation.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private UserService userService;
	
	private AuthorityService authorityService;
	
	public RegistrationController(UserService userService, AuthorityService authorityService) {
		this.userService = userService;
		this.authorityService = authorityService;
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		
		theModel.addAttribute("newUser", new NewUser());
		
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("newUser") NewUser newUser, 
				BindingResult theBindingResult, 
				Model theModel) {
		
		String userName = newUser.getUserName();
		
		if (theBindingResult.hasErrors()){
			 return "registration-form";
	        }

		User existing = userService.findByUserName(userName);
		
        if (existing != null){
        	theModel.addAttribute("newUser", new NewUser());
			theModel.addAttribute("registrationError", "User name already exists.");

        	return "registration-form";
        }
        
        userService.save(newUser);
        
        Authority authority = new Authority();
        
        authority.setUsername(userName);
        
        authority.setAuthority("ROLE_USER");
        
        authorityService.save(authority);
        
        return "login";		
	}
}
