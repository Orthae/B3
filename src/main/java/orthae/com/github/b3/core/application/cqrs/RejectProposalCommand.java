package orthae.com.github.b3.core.application.cqrs;

import javax.validation.constraints.NotBlank;

public record RejectProposalCommand(
    @NotBlank(message = "Comment can't be blank.") String comment) {
}
