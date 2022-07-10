package orthae.com.github.b3.core.proposal.status.impl;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.Status;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalCreatedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalCreatedStatusTest {

  @Test
  public void construction() {
    var status = new ProposalCreatedStatus();

    assertEquals(Status.CREATED, status.getStatus());
  }
}