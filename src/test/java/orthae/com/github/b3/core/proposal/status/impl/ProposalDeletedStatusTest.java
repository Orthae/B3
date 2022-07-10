package orthae.com.github.b3.core.proposal.status.impl;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.Status;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalDeletedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalDeletedStatusTest {

  @Test
  public void construction() {
    var comment = "Unit test";
    var status = new ProposalDeletedStatus(comment);

    assertEquals(Status.DELETED, status.getStatus());
    assertEquals(comment, status.getComment());
  }
}