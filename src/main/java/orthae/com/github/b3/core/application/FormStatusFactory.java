package orthae.com.github.b3.core.application;

import orthae.com.github.b3.core.domain.proposal.status.ProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalDeletedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalRejectedStatus;
import orthae.com.github.b3.core.application.cqrs.DeleteProposalCommand;
import orthae.com.github.b3.core.application.cqrs.RejectProposalCommand;

public class FormStatusFactory {
  public static ProposalStatus fromCommand(RejectProposalCommand command) {
    return new ProposalRejectedStatus(command.comment());
  }

  public static ProposalStatus fromCommand(DeleteProposalCommand command) {
    return new ProposalDeletedStatus(command.comment());
  }
}
