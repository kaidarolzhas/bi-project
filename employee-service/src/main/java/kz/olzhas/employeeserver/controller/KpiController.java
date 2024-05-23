package kz.olzhas.employeeserver.controller;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.dto.kpi.KpiStandardDto;
import kz.olzhas.employeeserver.mapper.kpi.KpiStandardMapper;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.service.KpiFactService;
import kz.olzhas.employeeserver.service.KpiStandardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee/kpi")
@RequiredArgsConstructor
public class KpiController {
    private final KpiStandardService kpiStandardService;
    private final KpiStandardMapper kpiStandardMapper;
    private final KpiFactService kpiFactService;

    @GetMapping("/{job}")
    @ResponseStatus(HttpStatus.OK)
    public List<KpiStandardDto> getKpiStandard(@PathVariable String job) {
        return kpiStandardMapper.toDtoList(kpiStandardService.getAllByRole(job.toUpperCase()));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<KpiStandardDto> getAllKpiStandards() {
        return kpiStandardMapper.toDtoList(kpiStandardService.getAll());
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus createKpi(@RequestBody KpiStandardDto kpiStandardDto) {
        KpiStandard kpiStandard = kpiStandardMapper.toEntity(kpiStandardDto);
        return kpiStandardService.save(kpiStandard) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PostMapping("/update/kpi/weak")
    @ResponseStatus(HttpStatus.OK)
    public void getKpiWeak(@RequestBody EmployeeRequest employeeRequest){
        kpiFactService.setKpiWeak(employeeRequest);
    }

    @PostMapping("/update/kpi/month")
    @ResponseStatus(HttpStatus.OK)
    public void getKpiMonth(@RequestBody EmployeeRequest employeeRequest){
        kpiFactService.setKpiMonth(employeeRequest);
    }

}
