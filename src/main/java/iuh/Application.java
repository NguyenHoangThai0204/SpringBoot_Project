package iuh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


//
//package iuh;
//
//import iuh.services.DangNhapService;
//import iuh.services.XeProductService;
//import iuh.modal.User;
//import iuh.modal.XeProduct;
//import java.util.List;
//
//import org.aspectj.weaver.ast.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//@SpringBootApplication
//public class Application implements CommandLineRunner {
//	@Autowired
//	private XeProductService xeProductService;
//	@Autowired
//	private DangNhapService danhMucService;
//	
//	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(Test.class, args);
//	}
//	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Hello world");
//
//		User user = new User();
//		
//		boolean result = danhMucService.login("admin", "admin");
//		System.out.println(result);
//		
//	}
//}
