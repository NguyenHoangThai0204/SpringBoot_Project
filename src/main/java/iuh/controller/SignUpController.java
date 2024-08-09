package iuh.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.modal.User;
import iuh.services.DangKiService;

@Controller
public class SignUpController {

	@Autowired
	private DangKiService dangKiService;
	
	@GetMapping("signup")
	public String signup() {
		return "dangKiTaiKhoan";
	}
	
	@PostMapping("signup/dk")
	    public String handleSignup(
	            @RequestParam("textDN") String textDN,
	            @RequestParam("textpw") String textpw,
	            @RequestParam("hoten") String hoten,
	            @RequestParam("Ngaysinh") LocalDate Ngaysinh,
	            @RequestParam("gender") String gender,
	            @RequestParam("dc") String dc,
	            @RequestParam("phone") String phoneNumber,
	            @RequestParam("txtEmail") String txtEmail) {
	        
	        // Xử lý dữ liệu đăng ký
		
			User user = new User();
			user.setUsername(textDN);
			user.setPassword(textpw);
			user.setFullName(hoten);
			user.setBirthday(Ngaysinh);
			user.setSex(gender);
			user.setAddress(dc);
			user.setPhone(phoneNumber);
			user.setEmail(txtEmail);
			
			// Dùng service để lưu user vào database
			dangKiService.addUser(user);
			
		
	        // ...
	        return "baohanh"; // Chuyển hướng đến trang thành công hoặc bất kỳ trang nào khác
	    }
	
	
}
