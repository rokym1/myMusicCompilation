package hr.rokym.myMusicCompilation.service;

import hr.rokym.myMusicCompilation.entity.User;
import hr.rokym.myMusicCompilation.newUser.NewUser;

public interface UserService {

	public User findByUserName(String userName);

	public void save(NewUser newUser);
}

