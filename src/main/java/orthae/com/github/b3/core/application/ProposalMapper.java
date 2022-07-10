package orthae.com.github.b3.core.application;

import orthae.com.github.b3.core.domain.proposal.Proposal;
import orthae.com.github.b3.core.domain.proposal.status.CommentableFormStatus;
import orthae.com.github.b3.core.domain.proposal.status.ProposalStatus;
import orthae.com.github.b3.dto.ProposalDto;
import orthae.com.github.b3.dto.StatusDto;

public class ProposalMapper {
  public static ProposalDto toDto(Proposal proposal) {
    return new ProposalDto(
        proposal.getId(),
        proposal.getPublicationId(),
        proposal.getTitle(),
        proposal.getContent(),
        toDto(proposal.getStatus()),
        proposal.getHistory()
            .stream()
            .map(ProposalMapper::toDto)
            .toList()
    );
  }

  private static StatusDto toDto(ProposalStatus status) {
    var type = status.getStatus().name();
    var comment = status instanceof CommentableFormStatus ? ((CommentableFormStatus) status).getComment() : null;
    return new StatusDto(type, comment);
  }
}
