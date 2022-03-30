package hr.rokym.myMusicCompilation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.rokym.myMusicCompilation.entity.Album;
import hr.rokym.myMusicCompilation.entity.Artist;
import hr.rokym.myMusicCompilation.entity.Song;
import hr.rokym.myMusicCompilation.service.AlbumService;
import hr.rokym.myMusicCompilation.service.ArtistService;
import hr.rokym.myMusicCompilation.service.SongService;

@Controller
@RequestMapping("/albums")
public class AlbumController {

	private AlbumService albumService;
	
	private ArtistService artistService;
	
	private SongService songService;
	
	public AlbumController(AlbumService albumService, ArtistService artistService, SongService songService) {
		this.albumService = albumService;
		this.artistService = artistService;
		this.songService = songService;
	}
	
	@GetMapping("/list")
	public String listAlbums(Model model) {
		
		List<Album> albums = albumService.findAll();
		
		model.addAttribute("albums", albums);
		
		return "list-albums";
	}
	
	@GetMapping("/showFormForAddAlbum")
	public String showFormForAddAlbum(Model model) {
		
		Album album = new Album();
		
		List<Artist> artists = artistService.findAll();
		
		model.addAttribute("album", album);
		
		model.addAttribute("artists", artists);
		
		return "album-form";
	}
	
	@PostMapping("/save")
	public String saveAlbum(@ModelAttribute("album") Album album) {
		
		Artist tempArtist = artistService.findById(album.getArtist().getId());
		
		if (album.getId() != 0) {
			
			Album updatedAlbum = albumService.findById(album.getId());
			
			List<Song> songsList = updatedAlbum.getSongs();
			
			if (!songsList.isEmpty()) {
				songsList.forEach(song -> {
					Song tempSong = songService.findById(song.getId());
					tempSong.setArtist(tempArtist);
				});
			}
		}
		
		album.setArtist(tempArtist);
		
		albumService.save(album);
		
		return "redirect:/albums/list";
	}
	
	@GetMapping("/showFormForUpdateAlbum")
	public String showFormForUpdateAlbum(@RequestParam("albumId") int id, Model model) {
		
		Album album = albumService.findById(id);
		
		model.addAttribute("album", album);
		
		List<Artist> artists = artistService.findAll();
		
		model.addAttribute("artists", artists);
		
		return "album-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("albumId") int id) {
		
		Album album = albumService.findById(id);
		
		if (album.getSongs().isEmpty()) {
			
			albumService.deleteById(id);
		}
			
		return "redirect:/albums/list";
	}
	
	@GetMapping("/showSongList")
	public String showSongList(@RequestParam("albumId") int id, Model model) {
		
		Album album = albumService.findById(id);
		
		model.addAttribute("songs", album.getSongs());
		
		return "list-songs";
	}
	
	@GetMapping("/search")
	public String searchAlbum(@RequestParam("albumTitle") String name, Model model) {
		
		List<Album> albums = albumService.searchBy(name);
		
		model.addAttribute("albums", albums);
		
		return "list-albums";
	}
}



