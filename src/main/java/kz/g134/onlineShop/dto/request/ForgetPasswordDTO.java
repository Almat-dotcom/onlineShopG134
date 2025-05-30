package kz.g134.onlineShop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgetPasswordDTO {
    @NotNull
    private String username;
    @NotNull
    private String newPassword;
    @NotNull
    private String reNewPassword;
}
