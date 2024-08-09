package iuh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.modal.User;
import iuh.services.DangNhapService; // Thay đổi đường dẫn import cho phù hợp
@Controller

public class SignInController {

    @Autowired
    private DangNhapService dangNhapService;

    @GetMapping("/signin")
    public String signin(@RequestParam(value = "email", required = false) String email, 
                         @RequestParam(value = "pass", required = false) String pass, 
                         Model model) {
        boolean isAdmin = false;
        boolean isLoggedIn = false;
        
        if (email != null && pass != null) {
            User user = dangNhapService.login(email, pass);
            if (user != null) {
                isLoggedIn = true;
                isAdmin = Boolean.TRUE.equals(user.getRole());
                
                model.addAttribute("isAdmin", isAdmin);
                model.addAttribute("isLoggedIn", isLoggedIn);
                
                // Forward tới trang admin/index hoặc trang chủ dựa trên vai trò người dùng
                return isAdmin ? "admin/index" : "index";
            }
        }
        
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isLoggedIn", isLoggedIn);
        
        // Forward tới trang chính nếu không đăng nhập thành công
        return "forward:/";
    }


}
