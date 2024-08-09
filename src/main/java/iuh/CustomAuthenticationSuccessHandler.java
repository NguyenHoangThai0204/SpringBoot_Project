package iuh;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Kiểm tra vai trò của người dùng từ Authorities
        String redirectUrl = "/"; // Mặc định là trang chính

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            redirectUrl = "/admin/index"; // Trang dành cho quản trị viên
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            redirectUrl = "/index"; // Trang dành cho người dùng
        }

        response.sendRedirect(redirectUrl);
    }
}
