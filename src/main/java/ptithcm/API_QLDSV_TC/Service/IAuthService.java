package ptithcm.API_QLDSV_TC.Service;

import ptithcm.API_QLDSV_TC.DTO.LoginDTO;

public interface IAuthService {
    String login(LoginDTO loginDto);
}
