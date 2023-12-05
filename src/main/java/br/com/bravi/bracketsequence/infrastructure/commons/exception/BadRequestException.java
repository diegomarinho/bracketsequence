package br.com.bravi.bracketsequence.infrastructure.commons.exception;

import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends RuntimeException {
    private APIException failedResponse;

    public BadRequestException(MessagesEnum message, Object... params) {
        super(message.readMessage(params));
        this.failedResponse = APIException.builder()
                .code(message.getCode())
                .message(message.readMessage(params))
                .reason(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build();
    }

    public BadRequestException(MessagesEnum message, HttpStatus status, Object... params) {
        super(message.readMessage(params));
        this.failedResponse = APIException.builder()
                .code(message.getCode())
                .message(message.readMessage(params))
                .reason(status.getReasonPhrase())
                .build();
    }

}
