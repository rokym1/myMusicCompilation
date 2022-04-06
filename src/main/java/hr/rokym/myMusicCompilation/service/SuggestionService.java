package hr.rokym.myMusicCompilation.service;

import java.util.List;
import java.util.Optional;

import hr.rokym.myMusicCompilation.entity.Suggestion;

public interface SuggestionService {
	
	public List<Suggestion> findAll();
	
	public Optional<Suggestion> findById(int id);
	
	public void save(Suggestion suggestion);
	
	public void deleteById(int id);
	
	public List<Suggestion> searchByArtistName(String name);

}

