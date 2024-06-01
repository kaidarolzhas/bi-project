package kz.olzhas.employeeserver.controller;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.dto.kpi.KpiStandardDto;
import kz.olzhas.employeeserver.mapper.kpi.KpiStandardMapper;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.service.JobRoleService;
import kz.olzhas.employeeserver.service.KpiFactService;
import kz.olzhas.employeeserver.service.KpiStandardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee/kpi")
@RequiredArgsConstructor
public class KpiController {
    private final KpiStandardService kpiStandardService;
    private final KpiStandardMapper kpiStandardMapper;
    private final KpiFactService kpiFactService;
    private final JobRoleService jobRoleService;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteKpi(@PathVariable("id") Long id) {
        kpiStandardService.deleteKpi(id);
    }

    @PutMapping("/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateKpiStandard(@RequestBody KpiStandardDto kpiStandardDto, @PathVariable("resId") Long resId
    ) throws BadRequestException {
        KpiStandard kpiStandard = kpiStandardMapper.toEntity(kpiStandardDto);
        Optional<JobRole> jobRole = jobRoleService.getByRole(kpiStandardDto.getJobRole().getRole(), resId);
        if(jobRole.isPresent()){
            kpiStandard.setJobRole(jobRole.get());
            kpiStandardService.updateKPI(kpiStandard);
        };
    }

    @PostMapping("/{resId}")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus createKpi(@RequestBody KpiStandardDto kpiStandardDto, @PathVariable("resId") Long resId) throws BadRequestException {
        KpiStandard kpiStandard = kpiStandardMapper.toEntity(kpiStandardDto);
        return kpiStandardService.save(kpiStandard, resId) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

//    @PostMapping("/update/kpi/weak")
//    @ResponseStatus(HttpStatus.OK)
//    public void getKpiWeak(@RequestBody EmployeeRequest employeeRequest){
//        kpiFactService.setKpiWeak(employeeRequest);
//    }

    @PostMapping("/update/kpi/month")
    @ResponseStatus(HttpStatus.OK)
    public void setKpiMonth(@RequestBody EmployeeRequest employeeRequest){
        kpiFactService.setKpiMonth(employeeRequest);
    }

    @PostMapping("/update/kpi/all-month/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public void setKpiAll(@PathVariable("resId") Long resId){
        kpiFactService.setKpiMonthAll(resId);
    }

}
