package orthae.com.github.b3.core.proposal;

import org.junit.jupiter.api.Test;
import orthae.com.github.b3.core.domain.proposal.Proposal;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalCreatedStatus;

import static org.junit.jupiter.api.Assertions.*;

class ProposalTest {

  @Test
  public void construction() {
    var title = "Title";
    var content = "Content";

    var proposal = new Proposal(title, content);

    assertNotNull(proposal.getId());
    assertEquals(title, proposal.getTitle());
    assertEquals(content, proposal.getContent());
    assertEquals(new ProposalCreatedStatus(), proposal.getStatus());
  }

  @Test
  public void constructionNullTitle() {
    var content = "Content";

    assertThrows(IllegalArgumentException.class, () -> new Proposal(null, content));
  }

  @Test
  public void constructionBlankTitle() {
    var title = "";
    var content = "Content";

    assertThrows(IllegalArgumentException.class, () -> new Proposal(title, content));
  }

  @Test
  public void modifyContentNull() {
    var title = "Title";
    var content = "Content";

    var proposal = new Proposal(title, content);

    assertThrows(IllegalArgumentException.class, () -> proposal.updateContent(null));
  }

  @Test
  public void modifyContentBlank() {
    var title = "Title";
    var content = "Content";

    var proposal = new Proposal(title, content);

    assertThrows(IllegalArgumentException.class, () -> proposal.updateContent(""));
  }

}