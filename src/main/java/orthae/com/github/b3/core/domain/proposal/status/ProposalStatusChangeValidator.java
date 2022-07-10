package orthae.com.github.b3.core.domain.proposal.status;

public class ProposalStatusChangeValidator {
  public static void validate(ProposalStatus from, ProposalStatus to) {
    var canProceed = switch (from.getStatus()) {
      case DELETED, REJECTED, PUBLISHED -> false;
      case CREATED -> canProceedFromCreated(to);
      case VERIFIED -> canProceedFromVerified(to);
      case ACCEPTED -> canProceedFromAccepted(to);
    };
    if (!canProceed) {
      var message = String.format("Can't proceed from %s to %s.", from.getStatus(), to.getStatus());
      throw new IllegalStateException(message);
    }
  }

  private static boolean canProceedFromCreated(ProposalStatus to) {
    return switch (to.getStatus()) {
      case VERIFIED, DELETED -> true;
      default -> false;
    };
  }

  private static boolean canProceedFromVerified(ProposalStatus to) {
    return switch (to.getStatus()) {
      case REJECTED, ACCEPTED -> true;
      default -> false;
    };
  }

  private static boolean canProceedFromAccepted(ProposalStatus to) {
    return switch (to.getStatus()) {
      case REJECTED, PUBLISHED -> true;
      default -> false;
    };
  }
}
