package orthae.com.github.b3.core.application.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import orthae.com.github.b3.core.application.PublishProposalService;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalPublishedStatus;
import orthae.com.github.b3.core.infrastructure.ProposalRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PublishProposalServiceImpl implements PublishProposalService {
  private final ProposalRepository proposalRepository;

  @Override
  public void publishProposal(UUID id) {
    var proposal = proposalRepository.findByIdOrThrow(id);
    var proposalId = proposalRepository.nextId();
    var newStatus = new ProposalPublishedStatus();

    proposal.updateStatus(newStatus);
    proposal.setPublicationId(proposalId);

    proposalRepository.save(proposal);
  }
}
