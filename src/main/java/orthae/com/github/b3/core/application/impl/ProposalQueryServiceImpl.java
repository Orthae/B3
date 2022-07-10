package orthae.com.github.b3.core.application.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import orthae.com.github.b3.core.application.ProposalMapper;
import orthae.com.github.b3.core.application.ProposalQueryService;
import orthae.com.github.b3.core.infrastructure.ProposalRepository;
import orthae.com.github.b3.core.application.cqrs.ProposalQuery;
import orthae.com.github.b3.dto.ProposalDto;

import java.util.List;

@Service
@AllArgsConstructor
public class ProposalQueryServiceImpl implements ProposalQueryService {
  private final ProposalRepository proposalRepository;

  @Override
  public List<ProposalDto> queryProposals(ProposalQuery query) {
    return proposalRepository.findBy(query.toQuery())
        .stream()
        .map(ProposalMapper::toDto)
        .toList();
  }
}
