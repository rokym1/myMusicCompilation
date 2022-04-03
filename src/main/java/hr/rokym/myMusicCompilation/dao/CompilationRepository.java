package hr.rokym.myMusicCompilation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.myMusicCompilation.entity.Compilation;

public interface CompilationRepository extends JpaRepository<Compilation, Integer> {

	public List<Compilation> findByUserName(String userName);
}

