package orthae.com.github.b3.core.proposal.status.impl;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.Status;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalPublishedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalPublishedStatusTest {
  @Test
  public void construction() {
    var status = new ProposalPublishedStatus();

    assertEquals(Status.PUBLISHED, status.getStatus());
  }
}