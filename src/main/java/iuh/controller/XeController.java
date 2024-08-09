package iuh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.modal.XeProduct;
import iuh.services.PhuKienService;
import iuh.services.XeProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import iuh.modal.PhuKien;

@Controller
public class XeController {

	@Autowired
	private XeProductService xeProductService;
	
	@Autowired
	private PhuKienService phuKienService;
	
	
	
	@GetMapping("/thongtin")
    public String getThongTinChiTiet(Model model, @RequestParam("id") String id) {
        XeProduct xe = xeProductService.findById(id);
        model.addAttribute("chiTietXe", xe);
        model.addAttribute("quantity", 1);
        System.out.println(xe);
        return "thongTinSanPham";
    }
	

	

	@GetMapping("/xemay")
	public String getDanhSachXe(Model model, @RequestParam("id") String id) {
    	List<XeProduct> listTayGa = xeProductService.findXeTayGa();
    	List<XeProduct> listXeSo = xeProductService.findXeSo();
		if (id.equals("tayga")) {
			model.addAttribute("Title", "Danh sách xe tay ga");
			model.addAttribute("list", listTayGa);
		} else if (id.equals("xecon")) {
			model.addAttribute("Title", "Danh sách xe số và xe côn");
			model.addAttribute("list", listXeSo);
		}
		return "danhSachXe";
	}
	
	
	
	
	
	
	
	

	

	
}
