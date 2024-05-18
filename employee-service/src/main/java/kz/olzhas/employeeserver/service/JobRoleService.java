package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.model.employee.JobRole;
import org.apache.coyote.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface JobRoleService {
    void deleteRole(Long id);

    List<ResponseRoleDto> getAll();
    Optional<JobRole> getByRole(String role);

     void createRoles(RequestRoleDto requestRoleDto);

    void updateRole(JobRole role) throws BadRequestException;
    Optional<JobRole> getJob(String role);
}
