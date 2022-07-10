package orthae.com.github.b3.core.application;

import orthae.com.github.b3.core.application.cqrs.ProposalQuery;
import orthae.com.github.b3.dto.ProposalDto;

import java.util.List;

public interface ProposalQueryService {
  List<ProposalDto> queryProposals(ProposalQuery query);
}
