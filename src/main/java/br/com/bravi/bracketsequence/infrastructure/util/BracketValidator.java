package br.com.bravi.bracketsequence.infrastructure.util;

import java.util.Map;
import java.util.Stack;

public class BracketValidator {

    private static final Map<Character, Character> BRACKET_PAIRS = Map.of('(', ')', '{', '}', '[', ']');

    public static boolean validateBracketSequence(String bracketSequence) {
        Stack<Character> stack = new Stack<>();

        return bracketSequence
                .chars()
                .mapToObj(c -> (char) c)
                .allMatch(bracket -> {
                    if (isOpeningBracket(bracket)) {
                        stack.push(bracket);
                    } else {
                        return !stack.isEmpty() && isMatchingPair(stack.pop(), bracket);
                    }
                    return true;
                }) && stack.isEmpty();
    }

    private static boolean isOpeningBracket(char bracket) {
        return BRACKET_PAIRS.containsKey(bracket);
    }

    private static boolean isMatchingPair(char openingBracket, char closingBracket) {
        return BRACKET_PAIRS.get(openingBracket) == closingBracket;
    }

}
