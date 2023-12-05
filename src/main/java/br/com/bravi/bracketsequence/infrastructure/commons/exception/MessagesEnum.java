package br.com.bravi.bracketsequence.infrastructure.commons.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum MessagesEnum {

    BRACKET_RECORD_TYPE_VALID("BRA-REC-TYPE-VAL-00", "bracket.record.type.valid"),
    BRACKET_RECORD_TYPE_INVALID("BRA-REC-TYPE-VAL-01", "bracket.record.type.invalid")
    ;

    private static MessageSource messageSource;
    private final String code;
    private final String message;

    public String readMessage(Object... params) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        String message = resourceBundle.getString(this.message);
        return ArrayUtils.isEmpty(params)
                ? message
                : formatPattern(message, params);
    }

    private String formatPattern(String pattern, Object[] stringArguments) {
        String[] placeholders = (pattern + " ").split("\\{\\}");
        return IntStream.range(0, Math.min(stringArguments.length, placeholders.length))
                .mapToObj(i -> placeholders[i] + stringArguments[i])
                .collect(Collectors.joining()) + placeholders[placeholders.length - 1];
    }

}
