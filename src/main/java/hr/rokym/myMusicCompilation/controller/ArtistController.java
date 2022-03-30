package hr.rokym.myMusicCompilation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.rokym.myMusicCompilation.entity.Artist;
import hr.rokym.myMusicCompilation.entity.ArtistDetail;
import hr.rokym.myMusicCompilation.service.ArtistDetailService;
import hr.rokym.myMusicCompilation.service.ArtistService;

@Controller
@RequestMapping("/artists")
public class ArtistController {

	private ArtistService artistService;
	
	private ArtistDetailService artistDetailService;
	
	public ArtistController(ArtistService artistService, ArtistDetailService artistDetailService) {
		this.artistService = artistService;
		this.artistDetailService = artistDetailService;
	}
	
	@GetMapping("/list")
	public String listArtists(Model model) {
		
		List<Artist> artists = artistService.findAll();
		
		model.addAttribute("artists", artists);
		
		return "list-artists";
	}
	
	@GetMapping("/showFormForAddArtist")
	public String showFormForAddArtist(Model model) {
		
		Artist artist = new Artist();
		
		model.addAttribute("artist", artist);
		
		return "artist-form";
	}
	
	@PostMapping("/save")
	public String saveArtist(@ModelAttribute("artist") Artist artist) {
		
	    if (artist.getId() == 0) {
	    	
	    	ArtistDetail newDetail = new ArtistDetail();
			
			artistDetailService.save(newDetail);
			
			artist.setArtistDetail(newDetail);
		} 
		
		artistService.save(artist);
		
		return "redirect:/artists/list";
	}
	
	@GetMapping("/showFormForUpdateArtist")
	public String showFormForUpdateArtist(@RequestParam("artistId") int id, Model model) {
		
		Artist artist = artistService.findById(id);
		
		model.addAttribute("artist", artist);
		
		return "artist-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("artistId") int id) {
		
		Artist artist = artistService.findById(id);
		
		if (artist.getAlbums().isEmpty() && artist.getSongs().isEmpty()) {
		
			artistService.deleteById(id);
		}
		
		return "redirect:/artists/list";
	}
	
	@GetMapping("/showAlbumList")
	public String showAlbumList(@RequestParam("artistId") int id, Model model) {
		
		Artist artist = artistService.findById(id);
		
		model.addAttribute("albums", artist.getAlbums());
		
		return "list-albums";
	}
	
	@GetMapping("/showSongList")
	public String showSongList(@RequestParam("artistId") int id, Model model) {
		
		Artist artist = artistService.findById(id);
		
		model.addAttribute("songs", artist.getSongs());
		
		return "list-songs";
	}
	
	@GetMapping("/search")
	public String searchArtist(@RequestParam("artistName") String name, Model model) {
		
		List<Artist> artists = artistService.searchBy(name);
		
		model.addAttribute("artists", artists);
		
		return "list-artists";
	}
}








