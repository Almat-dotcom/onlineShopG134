package kz.g134.onlineShop.service;

import kz.g134.onlineShop.dto.request.UserRegisterRequestDTO;

public interface RegisterService {
    Void registerUser(UserRegisterRequestDTO request);
}
