package kz.olzhas.restaurantservice.feign;


import kz.olzhas.restaurantservice.config.FeignClientConfig;
import kz.olzhas.restaurantservice.dto.EmployeeRequest;
import kz.olzhas.restaurantservice.dto.JobDto;
import kz.olzhas.restaurantservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "employeeClient", url = "${feign.employee-service}", configuration = FeignClientConfig.class)
public interface EmployeeClient {
    @GetMapping("/getAll")
    List<EmployeeRequest> getEmployees(@RequestParam("resId") Long resId);

    @GetMapping("/getRoles")
    List<JobDto> getRoles(@RequestParam("resId") Long resId);
}
