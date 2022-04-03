package hr.rokym.myMusicCompilation.service;

import java.util.List;

import hr.rokym.myMusicCompilation.entity.Compilation;

public interface CompilationService {

	public List<Compilation> findAll();
	
	public Compilation findById(int id);
	
	public void save(Compilation compilation);
	
	public void deleteById(int id);
	
	public List<Compilation> searchBy(String name);
}
