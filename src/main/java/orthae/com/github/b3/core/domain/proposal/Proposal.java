package orthae.com.github.b3.core.domain.proposal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import orthae.com.github.b3.core.domain.proposal.status.ProposalActionAuthorizer;
import orthae.com.github.b3.core.domain.proposal.status.ProposalStatus;
import orthae.com.github.b3.core.domain.proposal.status.ProposalStatusChangeValidator;
import orthae.com.github.b3.core.domain.proposal.status.impl.ProposalCreatedStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Document(collection = "proposal")
public class Proposal {
  @Id
  @Getter
  private UUID id;

  @Getter
  @Setter
  @Indexed(unique = true)
  private Long publicationId;

  @Getter
  private String title;

  @Getter
  private String content;

  @Getter
  private ProposalStatus status;

  private List<ProposalStatus> history;

  public Proposal(String title, String content) {
    this.id = UUID.randomUUID();
    this.publicationId = null;
    setTitle(title);
    setContent(content);
    this.status = new ProposalCreatedStatus();
    this.history = new ArrayList<>();
  }

  public List<ProposalStatus> getHistory() {
    return Collections.unmodifiableList(history);
  }

  private void setTitle(String title) {
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("Title is null or blank.");
    }
    this.title = title;
  }

  private void setContent(String content) {
    if (content == null || content.isBlank()) {
      throw new IllegalArgumentException("Content is null or blank.");
    }
    this.content = content;
  }

  public void updateContent(String content) {
    ProposalActionAuthorizer.authorizeModifyContent(status);
    setContent(content);
  }

  public void updateStatus(ProposalStatus newStatus) {
    ProposalStatusChangeValidator.validate(status, newStatus);
    this.history.add(status);
    this.status = newStatus;
  }
}
