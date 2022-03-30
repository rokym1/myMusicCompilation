package hr.rokym.myMusicCompilation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.SongRepository;
import hr.rokym.myMusicCompilation.entity.Song;

@Service
public class SongServiceImpl implements SongService {

	private SongRepository songRepository;
	
	@Autowired
	public SongServiceImpl(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	@Override
	public List<Song> findAll() {
	
		return songRepository.findAllByOrderByAlbumTitleAscTitleAsc();
	}

	@Override
	public Song findById(int id) {

		Optional<Song> result = songRepository.findById(id);
		
		Song song = null;
		
		if (result.isPresent()) {
			song = result.get();
		}
		else {
			throw new RuntimeException("Didi not found song id");
		}
		
		return song;
	}

	@Override
	public void save(Song song) {

		songRepository.save(song);
	}

	@Override
	public void deleteById(int id) {
		
		songRepository.deleteById(id);
	}

	@Override
	public List<Song> searchBy(String name) {
		
		List<Song> results = null;
		
		if (name != null && (name.trim().length() >  0)) {
			
			results = songRepository.findByTitleContainsAllIgnoreCase(name);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
}


