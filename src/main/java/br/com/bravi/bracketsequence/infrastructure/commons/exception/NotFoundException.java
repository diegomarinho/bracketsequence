
package br.com.bravi.bracketsequence.infrastructure.commons.exception;

import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotFoundException extends RuntimeException {
    private APIException failedResponse;

    public NotFoundException(MessagesEnum message, Object... params) {
        super(message.readMessage(params));
        this.failedResponse = APIException.builder()
                .code(message.getCode())
                .message(message.readMessage(params))
                .reason(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
    }
}
