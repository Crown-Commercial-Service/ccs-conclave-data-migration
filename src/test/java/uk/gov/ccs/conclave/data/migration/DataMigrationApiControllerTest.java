package uk.gov.ccs.conclave.data.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uk.gov.ccs.conclave.data.migration.controller.DataMigrationApiController;
import uk.gov.ccs.conclave.data.migration.service.MigrationService;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.User;
import uk.gov.ccs.swagger.dataMigration.model.UserTitle;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataMigrationApiController.class)
@AutoConfigureMockMvc
public class DataMigrationApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MigrationService service;

    private Organisation getTestOrganisation() {
        return new Organisation().identifierId("identifier").schemeId("scheme").rightToBuy(false).user(List.of(new User().firstName("first").lastName("last").email("email").title(UserTitle.DOCTOR)));
    }

    @Test
    public void shouldBeSuccessful() throws Exception {
        String organisations = new ObjectMapper().writeValueAsString(List.of(getTestOrganisation()));

        this.mockMvc.perform(post("/data-migration/migrate/format/json").contentType(MediaType.APPLICATION_JSON).content(organisations)).andExpect(status().isOk());
    }

    @Test
    public void shouldRejectInvalidOrganisation() throws Exception {
        String organisations = new ObjectMapper().writeValueAsString(List.of(new Organisation()));

        this.mockMvc.perform(post("/data-migration/migrate/format/json").contentType(MediaType.APPLICATION_JSON).content(organisations)).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldRejectInvalidTitle() throws Exception {
        String valid_organisations = new ObjectMapper().writeValueAsString(List.of(getTestOrganisation()));
        String invalid_organisations = valid_organisations.replace("Doctor", "invalid_title");

        this.mockMvc.perform(post("/data-migration/migrate/format/json").contentType(MediaType.APPLICATION_JSON).content(invalid_organisations)).andExpect(status().isBadRequest());
    }
}
