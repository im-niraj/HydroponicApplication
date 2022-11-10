package hydroponic.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class NewUserRequest {

    @NotNull(message = "Required")
    @Pattern(regexp = "^[a-zA-Z]{3,25}", message = "length must be >=3")
    private String firstName;

    @NotNull(message = "Required")
    @Pattern(regexp = "^[a-zA-Z]{3,25}", message = "length must be >=3")
    private String lastName;

    @NotNull(message = "Username should not be null")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,25}", message = "length must be >=3")
    private String username;

    @NotNull(message = "Password should not be null")
//    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
    private String password;

    private String city;
    private String district;
    private String state;
    private String pincode;
    private String streetAndLandmark;
    private Boolean isClient;
}
