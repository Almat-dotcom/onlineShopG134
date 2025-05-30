package kz.g134.onlineShop.controller;

import jakarta.validation.Valid;
import kz.g134.onlineShop.dto.request.ForgetPasswordDTO;
import kz.g134.onlineShop.dto.request.UserRegisterRequestDTO;
import kz.g134.onlineShop.exception.PasswordNotMatchException;
import kz.g134.onlineShop.exception.UserNotExistException;
import kz.g134.onlineShop.exception.UsernameAlreadyExistException;
import kz.g134.onlineShop.service.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/change-password")
@RequiredArgsConstructor
@Slf4j
public class ChangePasswordController {
    private final ChangePasswordService changePasswordService;

    @PostMapping
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ForgetPasswordDTO dto) {
        try {
            return new ResponseEntity<>(changePasswordService.changePassword(dto), HttpStatus.ACCEPTED);
        }catch (UserNotExistException | PasswordNotMatchException e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
