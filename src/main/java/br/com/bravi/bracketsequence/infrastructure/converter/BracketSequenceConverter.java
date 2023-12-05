package br.com.bravi.bracketsequence.infrastructure.converter;

import br.com.bravi.bracketsequence.domain.dto.BracketSequenceDTO;
import br.com.bravi.bracketsequence.domain.entity.BracketSequenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BracketSequenceConverter {

    public BracketSequenceEntity convertToEntity(BracketSequenceDTO dto) {
        BracketSequenceEntity entity = new BracketSequenceEntity();
        entity.setBracketSequence(dto.getSequence());
        return entity;
    }

    public BracketSequenceDTO convertToDTO(BracketSequenceEntity entity) {
        BracketSequenceDTO dto = new BracketSequenceDTO();
        dto.setSequence(entity.getBracketSequence());
        return dto;
    }
}