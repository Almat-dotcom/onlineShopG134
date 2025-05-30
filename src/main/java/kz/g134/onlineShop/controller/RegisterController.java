package kz.g134.onlineShop.controller;

import jakarta.validation.Valid;
import kz.g134.onlineShop.dto.request.UserRegisterRequestDTO;
import kz.g134.onlineShop.exception.PasswordNotMatchException;
import kz.g134.onlineShop.exception.UsernameAlreadyExistException;
import kz.g134.onlineShop.service.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserRegisterRequestDTO request) {
        try {
            return new ResponseEntity<>(registerService.registerUser(request), HttpStatus.CREATED);
        }catch (UsernameAlreadyExistException | PasswordNotMatchException e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
