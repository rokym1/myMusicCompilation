package hr.rokym.myMusicCompilation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.AuthorityRepository;
import hr.rokym.myMusicCompilation.entity.Authority;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	private AuthorityRepository authorityRepository;
	
	@Autowired
	public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
	@Override
	public void save(Authority authority) {
		
		authorityRepository.save(authority);
	}
}

