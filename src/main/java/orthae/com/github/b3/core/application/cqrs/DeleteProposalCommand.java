package orthae.com.github.b3.core.application.cqrs;

import javax.validation.constraints.NotBlank;

public record DeleteProposalCommand(
    @NotBlank(message = "Comment can't be blank.") String comment) {
}
