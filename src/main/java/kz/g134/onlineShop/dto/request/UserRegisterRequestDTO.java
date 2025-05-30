package kz.g134.onlineShop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDTO {
    @NotNull
    private String username;
    @NotNull
    private String fullName;
    private Integer age;
    @NotNull
    private String password;
    @NotNull
    private String rePassword;
}
