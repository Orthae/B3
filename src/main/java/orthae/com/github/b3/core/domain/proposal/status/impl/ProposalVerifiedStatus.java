package orthae.com.github.b3.core.domain.proposal.status.impl;

import orthae.com.github.b3.core.domain.proposal.status.AbstractProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.Status;

public class ProposalVerifiedStatus extends AbstractProposalStatus {
  public ProposalVerifiedStatus() {
    super(Status.VERIFIED);
  }
}
