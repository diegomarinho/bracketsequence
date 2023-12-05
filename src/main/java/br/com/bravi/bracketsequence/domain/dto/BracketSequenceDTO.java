package br.com.bravi.bracketsequence.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BracketSequenceDTO {

    @NotBlank(message = "A sequência de colchetes não pode estar vazia")
    //@Pattern(regexp = "[\\](){}]+", message = "A sequência deve conter apenas colchetes")
    private String sequence;
}