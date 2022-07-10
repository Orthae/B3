package orthae.com.github.b3.core.proposal.status.impl;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.Status;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalVerifiedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalVerifiedStatusTest {
  @Test
  public void construction() {
    var status = new ProposalVerifiedStatus();

    assertEquals(Status.VERIFIED, status.getStatus());
  }
}