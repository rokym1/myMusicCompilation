package hr.rokym.myMusicCompilation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	public List<Song> findAllByOrderByAlbumTitleAscTitleAsc();
	
	public List<Song> findByTitleContainsAllIgnoreCase(String title);
}


