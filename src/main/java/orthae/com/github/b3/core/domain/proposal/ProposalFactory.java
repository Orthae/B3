package orthae.com.github.b3.core.domain.proposal;

import orthae.com.github.b3.core.application.cqrs.CreateProposalCommand;

public class ProposalFactory {
  public static Proposal create(CreateProposalCommand command) {
    return new Proposal(command.title(), command.content());
  }
}
