package hr.rokym.myMusicCompilation.service;

import java.util.List;

import hr.rokym.myMusicCompilation.entity.Artist;

public interface ArtistService {

	public List<Artist> findAll();
	
	public Artist findById(int theId);
	
	public void save(Artist theArtist);
	
	public void deleteById(int theId);
	
	public List<Artist> searchBy(String name);
}
