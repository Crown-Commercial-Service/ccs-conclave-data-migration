package uk.gov.ccs.conclave.data.migration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import uk.gov.ccs.conclave.data.migration.domain.Org;
import uk.gov.ccs.conclave.data.migration.repository.OrganisationRepository;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Status;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

@Service
public class SummaryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummaryService.class);

    public static StringBuilder ciiOrgMessage = new StringBuilder("Error while creating CII organisation. ");
    public static StringBuilder ssoOrgMessage = new StringBuilder("Error while creating SSO Organisation. ");


    private final OrganisationRepository organisationRepository;

    public SummaryService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public void logError(Organisation organisation, StringBuilder message, Exception exception) {
        LOGGER.error(message.append(exception.getMessage()).toString());

        Org org = new Org();
        org.setIdentifierId(Long.valueOf(organisation.getIdentifierId()));
        org.setSchemeId(organisation.getSchemeId());
        org.setRightToBuy(organisation.isRightToBuy());
        if (organisation.getOrgRoles() != null) {
            org.setOrgRoles(StringUtils.arrayToCommaDelimitedString(organisation.getOrgRoles().toArray()));
        }
        org.setStatus(message.append(exception.getMessage()).toString());
        organisationRepository.save(org);

    }

    public Summary buildSummaryWithStatus(Organisation org, int statusCode) {
        if (statusCode == 200) {
            return buildSummary(org, Status._200_OK);
        } else if (statusCode == 201) {
            return buildSummary(org, Status._201_CREATED);
        } else if (statusCode == 400) {
            return buildSummary(org, Status._400_BAD_REQUEST);
        } else if (statusCode == 401) {
            return buildSummary(org, Status._401_UNATHORIZED);
        } else if (statusCode == 403) {
            return buildSummary(org, Status._403_FORBIDDEN);
        } else if (statusCode == 404) {
            return buildSummary(org, Status._404_NOT_FOUND);
        } else if (statusCode == 409) {
            return buildSummary(org, Status._409_DUPLICATE_RESOURCE);
        } else if (statusCode == 429) {
            return buildSummary(org, Status._429_TOO_MANY_REQUESTS);
        } else if (statusCode == 500) {
            return buildSummary(org, Status._500_INTERNAL_SERVER_ERROR);
        } else if (statusCode == 503) {
            return buildSummary(org, Status._503_SERVICE_UNAVAILABLE_LIMIT_EXCEEDED);
        } else if (statusCode == 504) {
            return buildSummary(org, Status._504_GATEWAY_TIMEOUT);
        } else if (statusCode == 505) {
            return buildSummary(org, Status._505_HTTP_VERSION_NOT_SUPPORTED);
        } else {
            return buildSummary(org, Status._505_HTTP_VERSION_NOT_SUPPORTED);
        }
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
