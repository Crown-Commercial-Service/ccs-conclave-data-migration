package uk.gov.ccs.conclave.data.migration.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uk.gov.ccs.conclave.data.migration.domain.Org;

@Getter
@Setter
@AllArgsConstructor
public class OrgMigrationResponse {

    private String organisationId;

    private Integer identityProviderId;

    private Org organisation;

}
