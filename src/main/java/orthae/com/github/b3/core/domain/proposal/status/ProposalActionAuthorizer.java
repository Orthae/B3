package orthae.com.github.b3.core.domain.proposal.status;

public class ProposalActionAuthorizer {
  public static void authorizeModifyContent(ProposalStatus status) {
    var canModify = switch (status.getStatus()) {
      case CREATED, VERIFIED -> true;
      default -> false;
    };
    if (!canModify) {
      var message = String.format("Can't modify content in %s status.", status.getStatus());
      throw new IllegalStateException(message);
    }
  }
}
