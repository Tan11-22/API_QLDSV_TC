package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.DTO.LoginDTO;
import ptithcm.API_QLDSV_TC.Repository.TaiKhoanRepository;
import ptithcm.API_QLDSV_TC.Security.Jwt.JwtTokenProvider;

@Service
public class AuthServiceImpl implements IAuthService{
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TaiKhoanRepository taiKhoanRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;



    @Override
    public String login(LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
}
