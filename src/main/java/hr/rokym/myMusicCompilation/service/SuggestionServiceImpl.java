package hr.rokym.myMusicCompilation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.SuggestionRepository;
import hr.rokym.myMusicCompilation.entity.Suggestion;

@Service
public class SuggestionServiceImpl implements SuggestionService {

	private SuggestionRepository suggestionRepository;
	
	@Autowired
	public SuggestionServiceImpl(SuggestionRepository suggestionRepository) {
		this.suggestionRepository = suggestionRepository;
	}
	
	@Override
	public List<Suggestion> findAll() {
		
		return suggestionRepository.findAll();
	}

	@Override
	public Optional<Suggestion> findById(int id) {
		
		Optional<Suggestion> suggestion = suggestionRepository.findById(id);
		
		return suggestion;
	}

	@Override
	public void save(Suggestion suggestion) {
		
		suggestionRepository.save(suggestion);
	}

	@Override
	public void deleteById(int id) {
		
		suggestionRepository.deleteById(id);

	}

	@Override
	public List<Suggestion> searchByArtistName(String name) {

		List<Suggestion> suggestions = null;
		
		if (name != null && (name.trim().length() > 0)) {
			
			suggestions = suggestionRepository.findAllByArtistNameContainsAllIgnoreCase(name);
		}
		else {
			suggestions = findAll();
		}
		
		return suggestions;
	}
}










