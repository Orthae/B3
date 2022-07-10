package orthae.com.github.b3.core.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import orthae.com.github.b3.core.domain.proposal.Proposal;

import java.util.UUID;

interface InternalProposalRepository extends MongoRepository<Proposal, UUID> {
}
