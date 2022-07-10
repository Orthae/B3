package orthae.com.github.b3.core.domain.proposal.status.impl;

import orthae.com.github.b3.core.domain.proposal.status.AbstractCommentableProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.Status;

public class ProposalRejectedStatus extends AbstractCommentableProposalStatus {
  public ProposalRejectedStatus(String comment) {
    super(Status.REJECTED, comment);
  }
}
