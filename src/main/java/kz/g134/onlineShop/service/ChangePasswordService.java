package kz.g134.onlineShop.service;

import kz.g134.onlineShop.dto.request.ForgetPasswordDTO;

public interface ChangePasswordService {
    Void changePassword(ForgetPasswordDTO dto);
}
