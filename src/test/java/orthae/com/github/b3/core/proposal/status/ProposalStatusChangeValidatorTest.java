package orthae.com.github.b3.core.proposal.status;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.status.ProposalStatusChangeValidator;
import orthae.com.github.b3.core.domain.proposal.status.impl.*;

import static org.junit.jupiter.api.Assertions.*;

class ProposalStatusChangeValidatorTest {

  @Test
  public void proceedFromCreatedToVerified() {
    var from = new ProposalCreatedStatus();
    var to = new ProposalVerifiedStatus();

    ProposalStatusChangeValidator.validate(from, to);
  }

  @Test
  public void proceedFromCreatedToDeleted() {
    var from = new ProposalCreatedStatus();
    var to = new ProposalDeletedStatus("Test");

    ProposalStatusChangeValidator.validate(from, to);
  }

  @Test
  public void proceedFromCreatedToCreated() {
    var from = new ProposalCreatedStatus();
    var to = new ProposalCreatedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalStatusChangeValidator.validate(from, to));
  }

  @Test
  public void proceedFromVerifiedToRejected() {
    var from = new ProposalVerifiedStatus();
    var to = new ProposalRejectedStatus("Test");

    ProposalStatusChangeValidator.validate(from, to);
  }

  @Test
  public void proceedFromVerifiedToAccepted() {
    var from = new ProposalVerifiedStatus();
    var to = new ProposalAcceptedStatus();

    ProposalStatusChangeValidator.validate(from, to);
  }

  @Test
  public void proceedFromVerifiedToVerified() {
    var from = new ProposalVerifiedStatus();
    var to = new ProposalVerifiedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalStatusChangeValidator.validate(from, to));
  }

  @Test
  public void proceedFromAcceptedToRejected() {
    var from = new ProposalAcceptedStatus();
    var to = new ProposalRejectedStatus("Test");

    ProposalStatusChangeValidator.validate(from, to);
  }

  @Test
  public void proceedFromAcceptedToPublished() {
    var from = new ProposalAcceptedStatus();
    var to = new ProposalPublishedStatus();

    ProposalStatusChangeValidator.validate(from, to);
  }

  @Test
  public void proceedFromAcceptedToAccepted() {
    var from = new ProposalAcceptedStatus();
    var to = new ProposalAcceptedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalStatusChangeValidator.validate(from, to));
  }

  @Test
  public void proceedFromDeletedToAccepted() {
    var from = new ProposalDeletedStatus("Test");
    var to = new ProposalAcceptedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalStatusChangeValidator.validate(from, to));
  }

  @Test
  public void proceedFromRejectedToAccepted() {
    var from = new ProposalRejectedStatus("Test");
    var to = new ProposalAcceptedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalStatusChangeValidator.validate(from, to));
  }

  @Test
  public void proceedFromPublishedToAccepted() {
    var from = new ProposalPublishedStatus();
    var to = new ProposalAcceptedStatus();

    assertThrows(IllegalStateException.class, () -> ProposalStatusChangeValidator.validate(from, to));
  }
}
