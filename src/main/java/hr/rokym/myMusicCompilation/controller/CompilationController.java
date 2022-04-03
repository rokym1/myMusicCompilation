package hr.rokym.myMusicCompilation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.rokym.myMusicCompilation.entity.Compilation;
import hr.rokym.myMusicCompilation.entity.Song;
import hr.rokym.myMusicCompilation.service.CompilationService;
import hr.rokym.myMusicCompilation.service.SongService;

@Controller
@RequestMapping("/compilations")
public class CompilationController {
	
	private CompilationService compilationService;
	
	private SongService songService;
	
	public CompilationController(CompilationService compilationService, SongService songService) {
		this.compilationService = compilationService;
		this.songService = songService;
	}


	@GetMapping("/list")
	public String listCompilations(@RequestParam("userName") String theUser, Model model) {
		
		List<Compilation> compilations = compilationService.searchBy(theUser);
		
		model.addAttribute("compilations", compilations);
		
		return "list-myCompilations";
	}
	
	@GetMapping("/showSongsOnComp")
	public String showSongsOnComp(@RequestParam("compilationId") int compId, Model model) {
		
		Compilation compilation = compilationService.findById(compId);
		
		List<Song> songs = compilation.getSongs();
		
		model.addAttribute("songs", songs);
		
		model.addAttribute("compilation", compilation);
		
		return "list-compilationSongs";
	}
	
	@GetMapping("/removeSong")
	public String removeSong(@RequestParam("songId") int songId, @RequestParam("compId") int compId, Model model) {
		
		Compilation compilation = compilationService.findById(compId);
		
		List<Song> compSongs = compilation.getSongs();
		
		Song songToRemove = songService.findById(songId);
		
		compSongs.remove(songToRemove);
		
		compilation.setSongs(compSongs);
		
		compilationService.save(compilation);
		
		model.addAttribute("songs", compSongs);
		
		model.addAttribute("compilation", compilation);
		
		return "list-compilationSongs";
	}
	
	@GetMapping("/addToCompilation")
	public String addToCompilation(@RequestParam("songId") int songId, @RequestParam("userName") String theUser, Model model) {
		
		Song song = songService.findById(songId);
		
		List<Compilation> compilations = compilationService.searchBy(theUser);
		
		model.addAttribute("song", song);
		
		model.addAttribute("compilations", compilations);
		
		return "chooseCompilationForSong";
	}
	
	@GetMapping("/saveSongToComp")
	public String saveSongToComp(@RequestParam("songId") int songId, @RequestParam("compId") int compId, Model model) {
		
		Compilation compilation = compilationService.findById(compId);
		
		Song song = songService.findById(songId);
		
		List<Song> newList = compilation.getSongs();
		
		newList.add(song);
		
		compilation.setSongs(newList);
		
		compilationService.save(compilation);
		
		model.addAttribute("songs", newList);
		
		model.addAttribute("compilation", compilation);
		
		return "list-compilationSongs";
	}
	
	@GetMapping("/showFormForAddComp")
	public String showFormForAddComp(@RequestParam("userName") String theUser, Model model) {
		
		Compilation compilation = new Compilation();
		
		compilation.setUserName(theUser);
		
		model.addAttribute("compilation", compilation);
		
		return "compilation-form";
	}
	
	@PostMapping("/saveComp")
	public String saveCompilation(@ModelAttribute("compilation") Compilation compilation, Model model) {
		
		List<Song> songs = new ArrayList<>();
		
		compilation.setSongs(songs);
		
		compilationService.save(compilation);
		
		List<Compilation> compilations = compilationService.searchBy(compilation.getUserName());
		
		model.addAttribute("compilations", compilations);
		
		return "list-myCompilations";
	}
}





























