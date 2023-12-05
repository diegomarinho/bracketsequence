package br.com.bravi.bracketsequence.controller;

import br.com.bravi.bracketsequence.controller.response.ApiResponse;
import br.com.bravi.bracketsequence.controller.swagger.ApiOperation;
import br.com.bravi.bracketsequence.domain.dto.BracketSequenceDTO;
import br.com.bravi.bracketsequence.infrastructure.commons.exception.MessageProvider;
import br.com.bravi.bracketsequence.infrastructure.commons.exception.MessagesEnum;
import br.com.bravi.bracketsequence.infrastructure.service.BracketSequenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/bracket")
@RequiredArgsConstructor
@Tag(name = "Bracket Sequence", description = "Validate Bracket Sequence")
public class BracketController {

    private final BracketSequenceService bracketService;
    private final MessageProvider messageProvider;

    @ApiOperation(
            method = "POST",
            description = "Validate or Save Bracket Sequence",
            summary = "Validate or Save Bracket Sequence"
    )
    @PostMapping("/validate")
    public ResponseEntity<ApiResponse> validateBracketSequence(@RequestBody @Valid BracketSequenceDTO dto) {
        boolean isValid = bracketService.validateBracketSequence(dto.getSequence());
        if (isValid) {
            bracketService.saveBracketSequence(dto);
            return ResponseEntity.ok(new ApiResponse("success", messageProvider.getMessage(MessagesEnum.BRACKET_RECORD_TYPE_VALID)));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("error", messageProvider.getMessage(MessagesEnum.BRACKET_RECORD_TYPE_INVALID)));
        }
    }
}
