package uk.gov.ccs.conclave.data.migration.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {
    @Test
    public void testTitleEnumsMatch() {
        var dmTitles = Arrays.stream(uk.gov.ccs.swagger.dataMigration.model.UserTitle.values())
                .map(uk.gov.ccs.swagger.dataMigration.model.UserTitle::toString).collect(Collectors.toSet());
        var ssoTitles = Arrays.stream(uk.gov.ccs.swagger.sso.model.UserTitle.values())
                .map(uk.gov.ccs.swagger.sso.model.UserTitle::toString).collect(Collectors.toSet());

        assertThat(ssoTitles).isEqualTo(dmTitles);
    }
}
