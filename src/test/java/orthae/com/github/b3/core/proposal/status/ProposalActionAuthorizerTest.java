package orthae.com.github.b3.core.proposal.status;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.ProposalActionAuthorizer;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalCreatedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalPublishedStatus;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalVerifiedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalActionAuthorizerTest {

  @Test
  public void authorizeCreated() {
    var status = new ProposalCreatedStatus();

    ProposalActionAuthorizer.authorizeModifyContent(status);
  }

  @Test
  public void authorizeVerified() {
    var status = new ProposalVerifiedStatus();

    ProposalActionAuthorizer.authorizeModifyContent(status);
  }

  @Test
  public void authorizeDefault() {
    var status = new ProposalPublishedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalActionAuthorizer.authorizeModifyContent(status));
  }


}