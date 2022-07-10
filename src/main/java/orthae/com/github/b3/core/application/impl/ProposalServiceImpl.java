package orthae.com.github.b3.core.application.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import orthae.com.github.b3.core.application.ProposalService;
import orthae.com.github.b3.core.domain.proposal.ProposalFactory;
import orthae.com.github.b3.core.infrastructure.ProposalRepository;
import orthae.com.github.b3.core.application.cqrs.CreateProposalCommand;
import orthae.com.github.b3.core.application.cqrs.ModifyContentCommand;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {
  private final ProposalRepository proposalRepository;

  @Override
  public void createProposal(CreateProposalCommand command) {
    var proposal = ProposalFactory.create(command);
    proposalRepository.save(proposal);
  }

  @Override
  public void modifyContent(UUID id, ModifyContentCommand command) {
    var proposal = proposalRepository.findByIdOrThrow(id);
    proposal.updateContent(command.content());
    proposalRepository.save(proposal);
  }
}
