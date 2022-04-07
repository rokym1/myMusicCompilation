package hr.rokym.myMusicCompilation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.UserRepository;
import hr.rokym.myMusicCompilation.entity.User;
import hr.rokym.myMusicCompilation.newUser.NewUser;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByUserName(String userName) {
		
		return userRepository.findByUsername(userName);
	}

	@Override
	public void save(NewUser newUser) {
		
		User user = new User();
		
		user.setUsername(newUser.getUserName());
		user.setPassword(passwordEncoder.encode(newUser.getPassword()));
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setEnabled(1);
		
		userRepository.save(user);
	}

}
