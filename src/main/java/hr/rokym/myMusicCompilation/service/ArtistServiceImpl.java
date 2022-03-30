package hr.rokym.myMusicCompilation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.ArtistRepository;
import hr.rokym.myMusicCompilation.entity.Artist;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	private ArtistRepository artistRepository;
	
	@Autowired
	public ArtistServiceImpl(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Override
	public List<Artist> findAll() {
		
		return artistRepository.findAllByOrderByNameAsc();
	}

	@Override
	public Artist findById(int theId) {
		
		Optional<Artist> result = artistRepository.findById(theId);
		
		Artist artist = null;
		
		if (result.isPresent()) {
			artist = result.get();
		}
		else {
			throw new RuntimeException("Did not found artist id");
		}
		
		return artist;
	}
	
	@Override
	public void save(Artist theArtist) {
		
		artistRepository.save(theArtist);
	}

	@Override
	public void deleteById(int theId) {
		
		artistRepository.deleteById(theId);
	}

	@Override
	public List<Artist> searchBy(String name) {
		
		List<Artist> results = null;
		
		if (name != null && (name.trim().length() > 0)) {
			
			results = artistRepository.findByNameContainsAllIgnoreCase(name);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
}








