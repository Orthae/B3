package orthae.com.github.b3.core.proposal.status.impl;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.Status;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalRejectedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalRejectedStatusTest {
  @Test
  public void construction() {
    var comment = "Unit test";
    var status = new ProposalRejectedStatus(comment);

    assertEquals(Status.REJECTED, status.getStatus());
    assertEquals(comment, status.getComment());
  }
}