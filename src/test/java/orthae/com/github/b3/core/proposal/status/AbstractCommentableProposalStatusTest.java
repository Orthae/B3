package orthae.com.github.b3.core.proposal.status;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.AbstractCommentableProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.Status;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCommentableProposalStatusTest {
  @Test
  public void invalidConstructionNull() {
    assertThrows(IllegalArgumentException.class, () -> new AbstractCommentableProposalStatus(Status.CREATED, null) {
    });
  }

  @Test
  public void invalidConstructionBlank() {
    assertThrows(IllegalArgumentException.class, () -> new AbstractCommentableProposalStatus(Status.CREATED, "") {
    });
  }

  @Test
  public void hashEquals() {
    var message = "Test";
    var status = Status.CREATED;
    var a = new AbstractCommentableProposalStatus(status, message) {
    };
    var b = new AbstractCommentableProposalStatus(status, message) {
    };

    var equalsResult = a.equals(b);
    var hashResult = a.hashCode() == b.hashCode();

    assertTrue(equalsResult);
    assertTrue(hashResult);
  }
}