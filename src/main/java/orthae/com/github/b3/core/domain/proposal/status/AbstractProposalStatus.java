package orthae.com.github.b3.core.domain.proposal.status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Transient;

@EqualsAndHashCode
public abstract class AbstractProposalStatus implements ProposalStatus {
  @Getter
  @Transient
  private final Status status;

  protected AbstractProposalStatus(Status status) {
    if (status == null) {
      throw new IllegalArgumentException("Status can't be null.");
    }
    this.status = status;
  }
}
