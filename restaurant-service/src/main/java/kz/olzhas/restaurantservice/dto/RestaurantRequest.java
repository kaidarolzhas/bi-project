package kz.olzhas.restaurantservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantRequest {

    String name;

    String address;

    String city;

    String phoneNumber;
}
