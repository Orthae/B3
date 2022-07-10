package orthae.com.github.b3.core.application.cqrs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import orthae.com.github.b3.core.domain.proposal.status.Status;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProposalQuery {
  private final String name;
  private final Status status;
  private final Integer page;
  private final Integer size;

  public Query toQuery() {
    var pageRequest = PageRequest.of(page, size);
    var query = new Query();
    if (name != null) {
      var pattern = String.format(".*%s.*", name);
      query.addCriteria(Criteria.where("title").regex(pattern, "i"));
    }

    if (status != null) {
      query.addCriteria(Criteria.where("status.status").is(status));
    }

    return query.with(pageRequest);
  }

  public static class Builder {
    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;
    private String title;
    private Status status;
    private Integer page;
    private Integer size;

    public Builder() {
      this.title = null;
      this.status = null;
      this.page = null;
      this.size = null;
    }

    public Builder title(String value) {
      this.title = value;
      return this;
    }

    public Builder status(Status value) {
      this.status = value;
      return this;
    }

    public Builder page(Integer value) {
      this.page = value;
      return this;
    }

    public Builder size(Integer value) {
      this.size = value;
      return this;
    }

    public ProposalQuery build() {
      return new ProposalQuery(
          title != null && !title.isBlank() ? title : null,
          status,
          page != null ? page : DEFAULT_PAGE,
          size != null ? size : DEFAULT_SIZE
      );
    }
  }
}
