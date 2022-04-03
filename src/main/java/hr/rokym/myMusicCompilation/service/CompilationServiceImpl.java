package hr.rokym.myMusicCompilation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.rokym.myMusicCompilation.dao.CompilationRepository;
import hr.rokym.myMusicCompilation.entity.Compilation;

@Service
public class CompilationServiceImpl implements CompilationService {

	private CompilationRepository compilationRepository;
	
	@Autowired
	public CompilationServiceImpl(CompilationRepository compilationRepository) {
		this.compilationRepository = compilationRepository;
	}
	
	@Override
	public List<Compilation> findAll() {

		return compilationRepository.findAll();
	}

	@Override
	public Compilation findById(int id) {
		
		Optional<Compilation> result = compilationRepository.findById(id);
		
		Compilation compilation = null;
		
		if (result.isPresent()) {
			compilation = result.get();
		}
		else {
			throw new RuntimeException("Did not found compilation id");
		}
		
		return compilation;
	}

	@Override
	public void save(Compilation compilation) {

		compilationRepository.save(compilation);

	}

	@Override
	public void deleteById(int id) {

		compilationRepository.deleteById(id);

	}

	@Override
	public List<Compilation> searchBy(String name) {
		
		List<Compilation> compilations = compilationRepository.findByUserName(name);
		
		return compilations;
	}
}

















