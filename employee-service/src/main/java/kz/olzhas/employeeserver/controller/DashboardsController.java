package kz.olzhas.employeeserver.controller;

import kz.olzhas.employeeserver.dto.kpi.KpiUserDto;
import kz.olzhas.employeeserver.service.KpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboards")
@RequiredArgsConstructor
public class DashboardsController {
    private final KpiService kpiService;

    @GetMapping("/{resId}")
    public ResponseEntity<List<KpiUserDto>> getListEmployeeByResId(@PathVariable Long resId) {
        return ResponseEntity.ok(kpiService.getAllByUser(resId));
    }

    @GetMapping("/{resId}/{role}")
    public ResponseEntity<List<KpiUserDto>> getListEmployeeByRole(@PathVariable("role") Long role,@PathVariable("resId") Long resId) {
        return ResponseEntity.ok(kpiService.getAllByRole(resId, role));
    }
}
