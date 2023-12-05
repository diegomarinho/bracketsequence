package br.com.bravi.bracketsequence.infrastructure.repository;// BracketRepository.java
import br.com.bravi.bracketsequence.domain.entity.BracketSequenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BracketSequenceRepository extends JpaRepository<BracketSequenceEntity, Long> {
}
