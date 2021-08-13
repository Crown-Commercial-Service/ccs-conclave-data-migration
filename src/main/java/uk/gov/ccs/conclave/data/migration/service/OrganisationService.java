package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.client.CiiOrgClient;
import uk.gov.ccs.conclave.data.migration.client.ConclaveClient;
import uk.gov.ccs.swagger.cii.ApiException;
import uk.gov.ccs.swagger.cii.model.Address;
import uk.gov.ccs.swagger.cii.model.Identifier;
import uk.gov.ccs.swagger.cii.model.OrgMigration;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.sso.model.OrganisationAddress;
import uk.gov.ccs.swagger.sso.model.OrganisationDetail;
import uk.gov.ccs.swagger.sso.model.OrganisationIdentifier;
import uk.gov.ccs.swagger.sso.model.OrganisationProfileInfo;

@Service
public class OrganisationService {

    private final CiiOrgClient ciiOrgClient;

    private final ConclaveClient conclaveClient;

    public OrganisationService(CiiOrgClient ciiOrgClient, ConclaveClient conclaveClient) {
        this.ciiOrgClient = ciiOrgClient;
        this.conclaveClient = conclaveClient;
    }


    public String migrateOrganisation(Organisation org) throws ApiException, uk.gov.ccs.swagger.sso.ApiException {
        OrgMigration ciiResponse = migrateOrgToCii(org);
        return migrateOrgToConclave(ciiResponse, org);
    }

    private OrgMigration migrateOrgToCii(Organisation org) throws ApiException {
        return ciiOrgClient.createCiiOrganisation(org.getSchemeId(), org.getIdentifierId());
    }

    private String migrateOrgToConclave(OrgMigration ciiResponse, Organisation org) throws uk.gov.ccs.swagger.sso.ApiException {
        OrganisationProfileInfo conclaveOrgProfile = populateConclaveOrg(ciiResponse, org);
        return conclaveClient.createConclaveOrg(conclaveOrgProfile);
    }

    private OrganisationProfileInfo populateConclaveOrg(OrgMigration ciiResponse, Organisation org) {
        Identifier identifier = ciiResponse.getIdentifier();
        Address address = ciiResponse.getAddress();

        OrganisationProfileInfo conclaveOrgProfile = new OrganisationProfileInfo();

        OrganisationAddress organisationAddress = populateOrgAddress(address);
        conclaveOrgProfile.address(organisationAddress);

        OrganisationIdentifier organisationIdentifier = populateOrgIdentifier(identifier);
        conclaveOrgProfile.identifier(organisationIdentifier);

        OrganisationDetail organisationDetail = populateOrgDetail(ciiResponse, org);
        conclaveOrgProfile.detail(organisationDetail);

        return conclaveOrgProfile;
    }

    private OrganisationDetail populateOrgDetail(OrgMigration ciiResponse, Organisation org) {
        OrganisationDetail organisationDetail = new OrganisationDetail();
        organisationDetail.setOrganisationId(ciiResponse.getOrganisationId());
        organisationDetail.isActive(true);
        organisationDetail.setRightToBuy(org.isRightToBuy());
        return organisationDetail;
    }

    private OrganisationIdentifier populateOrgIdentifier(Identifier ciiIdentifier) {
        OrganisationIdentifier organisationIdentifier = new OrganisationIdentifier();
        organisationIdentifier.setLegalName(ciiIdentifier.getLegalName());
        organisationIdentifier.setUri(ciiIdentifier.getUri());
        return organisationIdentifier;
    }

    private OrganisationAddress populateOrgAddress(Address ciiAddress) {
        OrganisationAddress organisationAddress = new OrganisationAddress();
        organisationAddress.setCountryCode(ciiAddress.getCountryName());
        organisationAddress.setStreetAddress(ciiAddress.getStreetAddress());
        organisationAddress.setLocality(ciiAddress.getLocality());
        organisationAddress.setPostalCode(ciiAddress.getPostalCode());
        organisationAddress.setRegion(ciiAddress.getRegion());
        return organisationAddress;
    }


}
