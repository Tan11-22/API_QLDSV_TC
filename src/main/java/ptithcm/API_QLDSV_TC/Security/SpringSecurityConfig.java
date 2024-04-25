package ptithcm.API_QLDSV_TC.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ptithcm.API_QLDSV_TC.Security.Jwt.JwtAuthenticationEntryPoint;
import ptithcm.API_QLDSV_TC.Security.Jwt.JwtAuthenticationFilter;
import ptithcm.API_QLDSV_TC.Security.Service.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    @Bean
    public JwtAuthenticationFilter authenticationJwtTokenFilter() {
        return new JwtAuthenticationFilter();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers("/api/auth/user/login").permitAll();
                    authorize.requestMatchers("/api/sinh-vien/quen-mat-khau").permitAll();
//                    authorize.requestMatchers("/api/auth/check-role").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/hoc-phi/hoc-ky").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/hoc-phi/sinh-vien").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/hoc-phi/ke-toan").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/hoc-phi/dong-hoc-phi").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/hoc-phi/ap-hoc-phi").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/lop-tin-chi/lopsv-dang-ky").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/lop-tin-chi/ds-dang-ky").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/lop-tin-chi/da-dang-ky").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/lop-tin-chi/dang-ky").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/lop-tin-chi/bo-dang-ky").hasAuthority("SINHVIEN");
                    authorize.requestMatchers("/api/sinh-vien/tim-sinh-vien").hasAuthority("SINHVIEN");
//                    authorize.requestMatchers("/api/auth/check-role-gv").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/tim-sinh-vien").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/danh-sach-lop").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/loc-ma-lop").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/danh-sach-sv-lop").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/them-sinh-vien-moi").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/update-sinh-vien").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/xoa-sinh-vien").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/mon-hoc/danh-sach-mon-hoc").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/mon-hoc/them-mon-hoc-moi").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/mon-hoc/update-mon-hoc").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/mon-hoc/xoa-mon-hoc").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/sinh-vien/da-nghi-hoc").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/giang-vien/tim-giang-vien").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/giang-vien/loc-ma-khoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/giang-vien/danh-sach-gv-khoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/giang-vien/them-giang-vien-moi").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/giang-vien/update-giang-vien").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/giang-vien/xoa-giang-vien").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/danh-sach-khoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/danh-sach-nganh").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/add-khoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/edit-khoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/delete-khoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/danh-sach-tai-khoan").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/reset-pass").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/set-status").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/auth/get-ctdt").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/ds-hocphi-theolop").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/ds-lop").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/ds-nienkhoa").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/").hasAuthority("GIANGVIEN");
                    authorize.requestMatchers("/api/").hasAuthority("GIANGVIEN");
                    authorize.anyRequest().authenticated();
                });
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
