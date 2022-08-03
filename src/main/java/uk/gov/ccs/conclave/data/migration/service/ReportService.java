package uk.gov.ccs.conclave.data.migration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.domain.Report;
import uk.gov.ccs.conclave.data.migration.repository.ReportRepository;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;
import uk.gov.ccs.swagger.dataMigration.model.Status;
import uk.gov.ccs.swagger.dataMigration.model.Summary;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    private static long userCount(Organisation o) {
        return isNotEmpty(o.getUser()) ? o.getUser().size() : 0;
    }

    public void generateReport(LocalDateTime startTime, LocalDateTime endTime, List<Organisation> organisations, long failedUserCount, long processesUserCount, String migrationStatus) {
        Report report = new Report();
        report.setStartTime(startTime);
        report.setEndTime(endTime);
        report.setDuration(ChronoUnit.MILLIS.between(startTime, endTime));
        report.setTotalOrganisations(organisations.size());
        report.setStatus(migrationStatus);
        long userCount = organisations.stream().mapToLong(ReportService::userCount).sum();
        report.setTotalUsers(userCount);
        report.setProcessedUsers(processesUserCount);
        report.setFailedUsers(failedUserCount);
        reportRepository.save(report);

    }

    public Summary buildSummary(Organisation org, Status status) {
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
