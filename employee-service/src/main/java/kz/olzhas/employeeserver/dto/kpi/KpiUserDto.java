package kz.olzhas.employeeserver.dto.kpi;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class KpiUserDto {
    private Long emlId;
    private Double kpi;
    private String month;
    private String year;
    private String username;

    public KpiUserDto() {}
}
