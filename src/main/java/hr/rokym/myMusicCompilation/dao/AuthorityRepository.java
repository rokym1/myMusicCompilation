package hr.rokym.myMusicCompilation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {

	
}
