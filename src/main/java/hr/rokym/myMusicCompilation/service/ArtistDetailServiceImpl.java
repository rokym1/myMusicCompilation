package hr.rokym.myMusicCompilation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.ArtistDetailRepository;
import hr.rokym.myMusicCompilation.entity.ArtistDetail;

@Service
public class ArtistDetailServiceImpl implements ArtistDetailService {

	private ArtistDetailRepository artistDetailRepository;
	
	@Autowired
	public ArtistDetailServiceImpl(ArtistDetailRepository artistDetailRepository) {
		this.artistDetailRepository = artistDetailRepository;
	}
	
	@Override
	public List<ArtistDetail> findAll() {
		
		return artistDetailRepository.findAll();
	}



	@Override
	public ArtistDetail findById(int theId) {
		
		Optional<ArtistDetail> result = artistDetailRepository.findById(theId);
		
		ArtistDetail detail = null;
		if (result.isPresent()) {
			detail = result.get();
		}
		else {
			throw new RuntimeException("Did not found detail");
		}
		return detail;
	}

	@Override
	public void save(ArtistDetail theArtistDetail) {
		
		artistDetailRepository.save(theArtistDetail);

	}

	@Override
	public void deleteById(int theId) {
		
		artistDetailRepository.deleteById(theId);
	}
}













