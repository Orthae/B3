package orthae.com.github.b3.core.infrastructure.sequence;

public interface SequenceRepository {
  long getNext(String sequence);
}
