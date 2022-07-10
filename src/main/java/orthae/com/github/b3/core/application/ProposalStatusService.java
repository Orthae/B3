package orthae.com.github.b3.core.application;

import orthae.com.github.b3.core.application.cqrs.DeleteProposalCommand;
import orthae.com.github.b3.core.application.cqrs.RejectProposalCommand;

import java.util.UUID;

public interface ProposalStatusService {
  void rejectProposal(UUID id, RejectProposalCommand command);

  void deleteProposal(UUID id, DeleteProposalCommand command);

  void verifyProposal(UUID id);

  void acceptProposal(UUID id);
}
