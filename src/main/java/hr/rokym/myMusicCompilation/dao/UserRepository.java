package hr.rokym.myMusicCompilation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsername(String theUserName);
	
}


