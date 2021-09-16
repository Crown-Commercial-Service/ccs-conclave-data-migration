package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.repository.OrganisationRepository;
import uk.gov.ccs.swagger.dataMigration.model.OrgRoles;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Status;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import java.util.stream.Collectors;

@Service
public class ErrorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorService.class);

    public static final String CII_ORG_ERROR_MESSAGE = "Error while creating CII organisation. ";
    public static final String SSO_ORG_ERROR_MESSAGE = "Error while creating SSO Organisation. ";
    public static final String SSO_ORG_CONTACT_ERROR_MESSAGE = "Error while creating SSO Organisation Contact. ";


    private final OrganisationRepository organisationRepository;


    public ErrorService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }


    public void logError(Organisation organisation, String message, Integer statusCode) {
        LOGGER.error(message);
        //saveError(organisation, message, statusCode);

    }

    private void saveError(Organisation organisation, String message, Integer statusCode) {
        Org org = new Org();
        org.setIdentifierId(organisation.getIdentifierId());
        org.setSchemeId(organisation.getSchemeId());
        org.setRightToBuy(organisation.isRightToBuy());
        var orgRoles = organisation.getOrgRoles();
        if (null != orgRoles) {
            var roles = orgRoles.stream().map(OrgRoles::getName).collect(Collectors.toList());
            org.setOrgRoles(String.join(",", roles));
        }
        org.setStatus(statusCode);
        org.setStatusDescription(message);
        organisationRepository.save(org);
    }

}
