package orthae.com.github.b3.core.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import orthae.com.github.b3.core.domain.proposal.Proposal;
import orthae.com.github.b3.core.infrastructure.sequence.SequenceRepository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class ProposalRepository {
  private final InternalProposalRepository internalRepository;
  private final MongoTemplate mongoTemplate;
  private final SequenceRepository sequenceRepository;
  private static final String PROPOSAL_SEQUENCE = "PROPOSAL_SEQUENCE";

  public List<Proposal> findBy(Query query) {
    return mongoTemplate.find(query, Proposal.class);
  }

  public Proposal findByIdOrThrow(UUID id) {
    return internalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Proposal not found"));
  }

  public void save(Proposal proposal) {
    internalRepository.save(proposal);
  }

  public long nextId() {
    return sequenceRepository.getNext(PROPOSAL_SEQUENCE);
  }

}
