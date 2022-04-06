package hr.rokym.myMusicCompilation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.rokym.myMusicCompilation.entity.Suggestion;
import hr.rokym.myMusicCompilation.service.SuggestionService;

@Controller
@RequestMapping("/suggestions")
public class SuggestionController {

	private SuggestionService suggestionService;
	
	public SuggestionController(SuggestionService suggestionService) {
		this.suggestionService = suggestionService;
	}
	
	@GetMapping("/addSuggestion")
	public String addSuggestion(Model model) {
		
		Suggestion suggestion = new Suggestion();
		
		model.addAttribute("suggestion", suggestion);
		
		return "suggestion-form";
	}
	
	@PostMapping("/save")
	public String saveSuggestion(@ModelAttribute("suggestion") Suggestion suggestion) {
		
		suggestionService.save(suggestion);
		
		return "redirect:/artists/list";
	}
}

