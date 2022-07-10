package orthae.com.github.b3.core.domain.proposal.status.impl;

import orthae.com.github.b3.core.domain.proposal.status.AbstractCommentableProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.Status;

public class ProposalDeletedStatus extends AbstractCommentableProposalStatus {
  public ProposalDeletedStatus(String comment) {
    super(Status.DELETED, comment);
  }
}
