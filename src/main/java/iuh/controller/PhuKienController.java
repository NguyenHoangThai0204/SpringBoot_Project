package iuh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.modal.PhuKien;
import iuh.services.PhuKienService;

@Controller
public class PhuKienController {
	@Autowired
	private PhuKienService phuKienService;

	@GetMapping("/phukien")
	public String lienhe() {
		return "phukien";
	}
	
	
	@GetMapping("/thongtinPK")
    public String getThongTinChiTietPK(Model model, @RequestParam("id") int id) {
        PhuKien xe = phuKienService.findById(id);
        model.addAttribute("chiTietXe", xe);
        System.out.println(xe);
        return "phuKienInfor";
    }
	
	
	
	
	
	
	
	
	@GetMapping("/listPK")
	public String list(Model model) {
		
		List<PhuKien> listPK = phuKienService.findAll();
		model.addAttribute("listPK", listPK);
		
		return "danhSachPK";
	}
	
	

	
}
