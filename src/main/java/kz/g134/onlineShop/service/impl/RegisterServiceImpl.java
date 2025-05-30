package kz.g134.onlineShop.service.impl;

import kz.g134.onlineShop.dto.request.UserRegisterRequestDTO;
import kz.g134.onlineShop.entity.Role;
import kz.g134.onlineShop.exception.PasswordNotMatchException;
import kz.g134.onlineShop.exception.UsernameAlreadyExistException;
import kz.g134.onlineShop.mapper.UserMapper;
import kz.g134.onlineShop.repository.RoleRepository;
import kz.g134.onlineShop.repository.UserRepository;
import kz.g134.onlineShop.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public Void registerUser(UserRegisterRequestDTO request) {
//        boolean isExist = userRepository.findByUsername(request.getUsername()).isPresent();
//        if (isExist) {
//            throw new UsernameAlreadyExistException("Username already exsits: " + request.getUsername());
//        }
        userRepository.findByUsername(request.getUsername()).ifPresent(user -> {
            throw new UsernameAlreadyExistException("Username already exsits: " + request.getUsername());
        });

        if(!request.getPassword().equals(request.getRePassword())){
            throw new PasswordNotMatchException("Passwords do not match");
        }

        var user=userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role userRole=roleRepository.findRoleUser();
        user.setRoles(Collections.singletonList(userRole));

        userRepository.save(user);
        return null;
    }
}
