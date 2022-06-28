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

    @Test
    public void shouldBeSuccessful() throws Exception {
        String organisations = new ObjectMapper().writeValueAsString(List.of(new Organisation().identifierId("identifier").schemeId("scheme").rightToBuy(false)));

        this.mockMvc.perform(post("/data-migration/migrate/format/json").contentType(MediaType.APPLICATION_JSON).content(organisations)).andExpect(status().isOk());
    }
}
