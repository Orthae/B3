package orthae.com.github.b3.core.infrastructure.sequence;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@AllArgsConstructor
class SequenceRepositoryImpl implements SequenceRepository {
  private final MongoOperations mongoOperations;

  public long getNext(String sequence) {
    Sequence counter = mongoOperations.findAndModify(query(where("_id").is(sequence)),
        new Update().inc("sequence", 1), options().returnNew(true).upsert(true),
        Sequence.class);
    return !Objects.isNull(counter) ? counter.getSequence() : 1;
  }
}
