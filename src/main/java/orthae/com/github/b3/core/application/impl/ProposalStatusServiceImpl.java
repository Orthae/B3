package orthae.com.github.b3.core.application.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import orthae.com.github.b3.core.application.FormStatusFactory;
import orthae.com.github.b3.core.application.ProposalStatusService;
import orthae.com.github.b3.core.domain.proposal.status.ProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalAcceptedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalVerifiedStatus;
import orthae.com.github.b3.core.infrastructure.ProposalRepository;
import orthae.com.github.b3.core.application.cqrs.DeleteProposalCommand;
import orthae.com.github.b3.core.application.cqrs.RejectProposalCommand;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProposalStatusServiceImpl implements ProposalStatusService {
  private final ProposalRepository proposalRepository;

  @Override
  public void rejectProposal(UUID id, RejectProposalCommand command) {
    var newStatus = FormStatusFactory.fromCommand(command);
    update(id, newStatus);
  }

  @Override
  public void deleteProposal(UUID id, DeleteProposalCommand command) {
    var newStatus = FormStatusFactory.fromCommand(command);
    update(id, newStatus);
  }

  @Override
  public void verifyProposal(UUID id) {
    var newStatus = new ProposalVerifiedStatus();
    update(id, newStatus);
  }

  @Override
  public void acceptProposal(UUID id) {
    var newStatus = new ProposalAcceptedStatus();
    update(id, newStatus);
  }

  private void update(UUID id, ProposalStatus status) {
    var proposal = proposalRepository.findByIdOrThrow(id);
    proposal.updateStatus(status);
    proposalRepository.save(proposal);
  }
}
