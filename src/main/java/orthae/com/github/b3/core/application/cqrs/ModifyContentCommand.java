package orthae.com.github.b3.core.application.cqrs;

import javax.validation.constraints.NotBlank;

public record ModifyContentCommand(
    @NotBlank(message = "Content can't be blank.") String content) {
}
