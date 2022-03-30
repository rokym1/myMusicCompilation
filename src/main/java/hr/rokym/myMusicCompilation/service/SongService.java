package hr.rokym.myMusicCompilation.service;

import java.util.List;

import hr.rokym.myMusicCompilation.entity.Song;

public interface SongService {
	
	public List<Song> findAll();
	
	public Song findById(int id);
	
	public void save(Song song);
	
	public void deleteById(int id);
	
	public List<Song> searchBy(String name);
}


