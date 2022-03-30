package hr.rokym.myMusicCompilation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

	public List<Album> findAllByOrderByTitleAsc();
	
	public List<Album> findAllByOrderByArtistNameAscTitleAsc();
	
	public List<Album> findByTitleContainsAllIgnoreCase(String title);
}


