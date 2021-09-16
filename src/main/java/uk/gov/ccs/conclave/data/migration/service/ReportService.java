package uk.gov.ccs.conclave.data.migration.service;

import org.springframework.stereotype.Service;
import uk.gov.ccs.conclave.data.migration.domain.Report;
import uk.gov.ccs.conclave.data.migration.repository.ReportRepository;
import uk.gov.ccs.swagger.dataMigration.model.Organisation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    private static long userCount(Organisation o) {
        return o.getUser() != null ? o.getUser().size() : 0;
    }

    public void generateReport(LocalDateTime startTime, LocalDateTime endTime, List<Organisation> organisations) {
        Report report = new Report();
        report.setStartTime(startTime);
        report.setEndTime(endTime);
        report.setDuration(ChronoUnit.MILLIS.between(startTime, endTime));
        report.setTotalOrganisations(organisations.size());

        long userCount = organisations.stream().mapToLong(ReportService::userCount).sum();
        report.setTotalUsers(userCount);
        reportRepository.save(report);


    }
}
