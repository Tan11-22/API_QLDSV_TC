package ptithcm.API_QLDSV_TC.Security.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.TaiKhoan;
import ptithcm.API_QLDSV_TC.Repository.TaiKhoanRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username"));
        GrantedAuthority authority =  new SimpleGrantedAuthority(taiKhoan.getQuyen().getTenQuyen());
        return new org.springframework.security.core.userdetails.User(
                username,
                taiKhoan.getPassword(),
                Collections.singleton(authority)
        );
    }


}
