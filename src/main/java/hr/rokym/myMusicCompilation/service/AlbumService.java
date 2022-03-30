package hr.rokym.myMusicCompilation.service;

import java.util.List;

import hr.rokym.myMusicCompilation.entity.Album;

public interface AlbumService {

	public List<Album> findAll();
	
	public Album findById(int theId);
	
	public void save(Album album);
	
	public void deleteById(int theId);
	
	public List<Album> searchBy(String name);
}

