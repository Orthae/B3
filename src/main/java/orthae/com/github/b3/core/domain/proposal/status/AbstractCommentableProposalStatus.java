package orthae.com.github.b3.core.domain.proposal.status;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
public abstract class AbstractCommentableProposalStatus extends AbstractProposalStatus implements CommentableFormStatus {
  @Getter
  private final String comment;

  protected AbstractCommentableProposalStatus(Status status, String comment) {
    super(status);
    if (comment == null || comment.isBlank()) {
      throw new IllegalArgumentException("Comment can't be null or blank.");
    }
    this.comment = comment;
  }
}
