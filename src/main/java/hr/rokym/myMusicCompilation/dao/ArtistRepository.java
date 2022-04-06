package hr.rokym.myMusicCompilation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

	public List<Artist> findAllByOrderByNameAsc();
	
	public List<Artist> findByNameContainsAllIgnoreCase(String name);
	
	public Artist findByName(String name);
}


