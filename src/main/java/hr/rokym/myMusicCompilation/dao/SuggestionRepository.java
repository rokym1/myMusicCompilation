package hr.rokym.myMusicCompilation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {

	public List<Suggestion> findAllByArtistNameContainsAllIgnoreCase(String name);
	
}


