package orthae.com.github.b3.core.application.cqrs;

import javax.validation.constraints.NotBlank;

public record CreateProposalCommand(
    @NotBlank(message = "Title can't be blank.") String title,
    @NotBlank(message = "Content can't be blank.") String content) {
}
