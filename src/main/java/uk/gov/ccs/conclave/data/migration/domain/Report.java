package uk.gov.ccs.conclave.data.migration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Report")
@Getter
@Setter
public class Report {

    @Id
    @Column(name = "report_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;

    private long totalOrganisations;

    private long totalUsers;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private double duration;

    private String status;

    private long processedUsers;

    private long failedUsers;

}
