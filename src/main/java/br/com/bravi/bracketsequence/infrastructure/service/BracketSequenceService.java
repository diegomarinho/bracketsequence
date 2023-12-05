package br.com.bravi.bracketsequence.infrastructure.service;

import br.com.bravi.bracketsequence.infrastructure.converter.BracketSequenceConverter;
import br.com.bravi.bracketsequence.domain.dto.BracketSequenceDTO;
import br.com.bravi.bracketsequence.domain.entity.BracketSequenceEntity;
import br.com.bravi.bracketsequence.infrastructure.repository.BracketSequenceRepository;
import br.com.bravi.bracketsequence.infrastructure.util.BracketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BracketSequenceService {

    @Autowired
    private BracketSequenceRepository bracketSequenceRepository;

    @Autowired
    private BracketSequenceConverter converter;

    public boolean validateBracketSequence(String input) {
        return BracketValidator.validateBracketSequence(input);
    }

    public BracketSequenceDTO saveBracketSequence(BracketSequenceDTO dto) {
        BracketSequenceEntity entity = converter.convertToEntity(dto);
        validateBracketSequence(entity.getBracketSequence());
        entity = bracketSequenceRepository.save(entity);
        return converter.convertToDTO(entity);
    }

}
