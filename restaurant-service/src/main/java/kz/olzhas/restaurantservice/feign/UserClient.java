package kz.olzhas.restaurantservice.feign;

import kz.olzhas.restaurantservice.config.FeignClientConfig;
import kz.olzhas.restaurantservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userClient", url = "${feign.auth-service}", configuration = FeignClientConfig.class)
public interface UserClient {

    @GetMapping("/token-user")
    ResponseEntity<UserDto> getUserByToken(@RequestParam("token") String token);

    @GetMapping("/by-userId")
    ResponseEntity<UserDto> getUserByUserId(@RequestParam("userId") Long userId);
}
