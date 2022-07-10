package orthae.com.github.b3.core.application;

import orthae.com.github.b3.core.application.cqrs.CreateProposalCommand;
import orthae.com.github.b3.core.application.cqrs.ModifyContentCommand;

import java.util.UUID;

public interface ProposalService {
  void createProposal(CreateProposalCommand command);

  void modifyContent(UUID id, ModifyContentCommand command);
}
