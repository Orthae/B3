package orthae.com.github.b3.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import orthae.com.github.b3.core.application.ProposalQueryService;
import orthae.com.github.b3.core.application.ProposalService;
import orthae.com.github.b3.core.application.ProposalStatusService;
import orthae.com.github.b3.core.application.PublishProposalService;
import orthae.com.github.b3.core.application.cqrs.*;
import orthae.com.github.b3.core.domain.proposal.status.Status;
import orthae.com.github.b3.dto.ProposalDto;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/proposal")
@AllArgsConstructor
public class ProposalController {
  private final ProposalStatusService proposalStatusService;
  private final ProposalService proposalService;
  private final ProposalQueryService proposalQueryService;
  private final PublishProposalService publishProposalService;

  @PutMapping("{id}/reject")
  public void rejectProposal(@PathVariable UUID id, @RequestBody RejectProposalCommand command) {
    proposalStatusService.rejectProposal(id, command);
  }

  @PutMapping("{id}/delete")
  public void deleteProposal(@PathVariable UUID id, @RequestBody DeleteProposalCommand command) {
    proposalStatusService.deleteProposal(id, command);
  }

  @PutMapping("{id}/verify")
  public void verifyProposal(@PathVariable UUID id) {
    proposalStatusService.verifyProposal(id);
  }

  @PutMapping("{id}/accept")
  public void acceptProposal(@PathVariable UUID id) {
    proposalStatusService.acceptProposal(id);
  }

  @PostMapping()
  public void createProposal(@Valid @RequestBody CreateProposalCommand command) {
    proposalService.createProposal(command);
  }

  @GetMapping
  public List<ProposalDto> queryProposals(
      @RequestParam(required = false) String title,
      @RequestParam(required = false) Status status,
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer size
  ) {
    var query = new ProposalQuery.Builder()
        .title(title)
        .status(status)
        .page(page)
        .size(size)
        .build();
    return proposalQueryService.queryProposals(query);
  }

  @PatchMapping("{id}/content")
  public void modifyContent(@PathVariable UUID id, @Valid @RequestBody ModifyContentCommand command) {
    proposalService.modifyContent(id, command);
  }


  @PutMapping("{id}/publish")
  public void publishProposal(@PathVariable UUID id) {
    publishProposalService.publishProposal(id);
  }
}
