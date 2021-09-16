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

    public Summary buildSummaryWithStatus(Organisation org, int statusCode) {
        Summary summary;
        switch (statusCode) {
            case 200:
                summary = buildSummary(org, Status._200_OK);
                break;
            case 201:
                summary = buildSummary(org, Status._201_CREATED);
                break;
            case 400:
                summary = buildSummary(org, Status._400_BAD_REQUEST);
                break;
            case 401:
                summary = buildSummary(org, Status._401_UNATHORIZED);
                break;
            case 403:
                summary = buildSummary(org, Status._403_FORBIDDEN);
                break;
            case 404:
                summary = buildSummary(org, Status._404_NOT_FOUND);
                break;
            case 409:
                summary = buildSummary(org, Status._409_DUPLICATE_RESOURCE);
                break;
            case 429:
                summary = buildSummary(org, Status._429_TOO_MANY_REQUESTS);
                break;
            case 500:
                summary = buildSummary(org, Status._500_INTERNAL_SERVER_ERROR);
                break;
            case 503:
                summary = buildSummary(org, Status._503_SERVICE_UNAVAILABLE_LIMIT_EXCEEDED);
                break;
            case 504:
                summary = buildSummary(org, Status._504_GATEWAY_TIMEOUT);
                break;
            default:
                summary = buildSummary(org, Status._505_HTTP_VERSION_NOT_SUPPORTED);
                break;
        }
        return summary;
    }

    private Summary buildSummary(Organisation org, Status status) {
        Summary summary = new Summary();
        summary.setIdentifierId(org.getIdentifierId());
        summary.setSchemeId(org.getSchemeId());
        summary.setRightToBuy(org.isRightToBuy());
        if (null != org.getOrgRoles()) {
            summary.setOrgRoles(org.getOrgRoles());
        }
        summary.addStatusItem(status);
        return summary;
    }


}
