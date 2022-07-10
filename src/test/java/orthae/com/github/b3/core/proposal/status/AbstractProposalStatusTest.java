package orthae.com.github.b3.core.proposal.status;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.AbstractProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.Status;

import static org.junit.jupiter.api.Assertions.*;

class AbstractProposalStatusTest {
  @Test
  public void invalidConstructionNull() {
    assertThrows(IllegalArgumentException.class, () -> new AbstractProposalStatus(null) {
    });
  }

  @Test
  public void hashEquals() {
    var status = Status.CREATED;
    var a = new AbstractProposalStatus(status) {
    };
    var b = new AbstractProposalStatus(status) {
    };

    var equalsResult = a.equals(b);
    var hashResult = a.hashCode() == b.hashCode();

    assertTrue(equalsResult);
    assertTrue(hashResult);
  }
}