package br.com.bravi.bracketsequence.service;

import br.com.bravi.bracketsequence.infrastructure.service.BracketSequenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketSequenceServiceTest {

    private BracketSequenceService bracketSequenceService;

    @BeforeEach
    void setUp() {
        bracketSequenceService = new BracketSequenceService();
    }

    @Test
    void testValidBracketSequence() {
        assertTrue(bracketSequenceService.validateBracketSequence("(){}[]"));
        assertTrue(bracketSequenceService.validateBracketSequence("{()}{}"));
    }

    @Test
    void testInvalidBracketSequence() {
        assertFalse(bracketSequenceService.validateBracketSequence("[]{()"));
        assertFalse(bracketSequenceService.validateBracketSequence("[{)]"));
    }
}
