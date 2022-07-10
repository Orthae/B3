package orthae.com.github.b3.core.infrastructure.sequence;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
@Getter
public class Sequence {
  @Id
  private String id;

  private long sequence;
}
