package orthae.com.github.b3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProposalDto(
    UUID id,
    Long publicationId,
    String title,
    String content,
    StatusDto status,
    List<StatusDto> history
) {
}
