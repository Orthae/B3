package orthae.com.github.b3.core.application.impl;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.Proposal;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalAcceptedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalDeletedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalRejectedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalVerifiedStatus;
import orthae.com.github.b3.core.application.cqrs.DeleteProposalCommand;
import orthae.com.github.b3.core.application.cqrs.RejectProposalCommand;
import orthae.com.github.b3.core.infrastructure.ProposalRepository;

import java.util.UUID;

import static org.mockito.Mockito.*;

class ProposalStatusServiceImplTest {
  private final ProposalRepository proposalRepository = mock(ProposalRepository.class);
  private final ProposalStatusServiceImpl proposalStatusService = new ProposalStatusServiceImpl(proposalRepository);

  @Test
  public void rejectProposal() {
    var id = UUID.randomUUID();
    var command = new RejectProposalCommand("Test");
    var proposal = mock(Proposal.class);

    when(proposalRepository.findByIdOrThrow(id)).thenReturn(proposal);

    proposalStatusService.rejectProposal(id, command);

    verify(proposal).updateStatus(any(ProposalRejectedStatus.class));
    verify(proposalRepository).findByIdOrThrow(id);
    verify(proposalRepository).save(proposal);
  }

  @Test
  public void deleteProposal() {
    var id = UUID.randomUUID();
    var command = new DeleteProposalCommand("Test");
    var proposal = mock(Proposal.class);

    when(proposalRepository.findByIdOrThrow(id)).thenReturn(proposal);

    proposalStatusService.deleteProposal(id, command);

    verify(proposal).updateStatus(any(ProposalDeletedStatus.class));
    verify(proposalRepository).findByIdOrThrow(id);
    verify(proposalRepository).save(proposal);
  }

  @Test
  public void verifyProposal() {
    var id = UUID.randomUUID();
    var proposal = mock(Proposal.class);

    when(proposalRepository.findByIdOrThrow(id)).thenReturn(proposal);

    proposalStatusService.verifyProposal(id);

    verify(proposal).updateStatus(any(ProposalVerifiedStatus.class));
    verify(proposalRepository).findByIdOrThrow(id);
    verify(proposalRepository).save(proposal);
  }

  @Test
  public void acceptProposal() {
    var id = UUID.randomUUID();
    var proposal = mock(Proposal.class);

    when(proposalRepository.findByIdOrThrow(id)).thenReturn(proposal);

    proposalStatusService.acceptProposal(id);

    verify(proposal).updateStatus(any(ProposalAcceptedStatus.class));
    verify(proposalRepository).findByIdOrThrow(id);
    verify(proposalRepository).save(proposal);
  }
}
