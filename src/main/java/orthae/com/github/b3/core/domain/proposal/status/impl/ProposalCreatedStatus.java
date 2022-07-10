package orthae.com.github.b3.core.domain.proposal.status.impl;

import orthae.com.github.b3.core.domain.proposal.status.AbstractProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.Status;

public class ProposalCreatedStatus extends AbstractProposalStatus {
  public ProposalCreatedStatus() {
    super(Status.CREATED);
  }
}

