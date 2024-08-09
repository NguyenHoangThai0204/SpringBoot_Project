package iuh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.modal.PhuKien;
import iuh.modal.XeProduct;
import iuh.services.PhuKienService;
import iuh.services.XeProductService;

@Controller
@RequestMapping("/signin/admin")
public class AdminController {
	
	@Autowired
	private XeProductService xeProductService;
	
	@Autowired
	private PhuKienService phuKienService;

	
	@PostMapping("/updatePK")
	public String updatePK(Model model, @RequestParam("tenPhuKien") String ten, @RequestParam("gia") String giaString,
			@RequestParam("soLuong") int soLuong, @RequestParam("id") int id) {

		long gia = Long.parseLong(giaString.replace(".", "").replace(",", ""));

		PhuKien phuKien = phuKienService.findById(id);
		phuKien.setTenPhuKien(ten);
		phuKien.setGia(gia);
		phuKien.setSoLuong(soLuong);

		phuKienService.save(phuKien);

		return loadPk(model);
	}
			
	@GetMapping("/deletePK")
	public String deletePk(Model model, 
			@RequestParam("id") int id) {
		phuKienService.deletePhuKienById(id);
		return loadPk(model);
	}
	
	
	
	@GetMapping("/loadPK")
	public String loadPk(Model model) {

		List<PhuKien> list = phuKienService.findAll();
		model.addAttribute("list", list);
		
		return "admin/loadPK";  
	}
	
	

	@GetMapping("/loadXe")
	public String loadXe(Model model) {
		
		List<XeProduct> list = xeProductService.findAll();
		model.addAttribute("list", list);

		return "admin/loadXe";  
	}
	
	
	
	
	
	
	
	@PostMapping("/updateXe")
    public String updateXe(
    		Model model, @RequestParam("phienBan") String phienBan,
    		@RequestParam("maSP") String ma,
			@RequestParam("danhMuc") String danhMuc, 
			@RequestParam("xuatXu") String xuatXu,
			@RequestParam("nhanHieu") String nhanHieu, 
			@RequestParam("gia") String giaString,
			@RequestParam("thongTin") String thongTin,
			@RequestParam("soLuong") int soLuong) {
	
		XeProduct xeProduct = xeProductService.findById(ma);
		
		long gia = Long.parseLong(giaString.replace(".", "").replace(",", ""));
		
		xeProduct.setPhienBan(phienBan);
		xeProduct.setDanhMuc(danhMuc);
		xeProduct.setXuatXu(xuatXu);
		xeProduct.setNhanHieu(nhanHieu);
		xeProduct.setGia(gia);
		xeProduct.setThongTin(thongTin);
		xeProduct.setSoLuong(soLuong);
		
		xeProductService.save(xeProduct);
		
		return loadXe(model);
	}
	
	


	
	

	
	@GetMapping("/deleteXe")
	public String deleteXe(Model model,
			@RequestParam("id") String id) {
		xeProductService.deleteXeByMaSP(id);
		return loadXe(model);
	}
	
	

	@GetMapping("/addxe")
	public String addXe(Model model) {
		return "admin/themXe";  
	}
	
	@PostMapping("/addXeDb")
	public String addXeDb(Model model, @RequestParam("phienBan") String phienBan,
			@RequestParam("danhMuc") String danhMuc, @RequestParam("xuatXu") String xuatXu,
			@RequestParam("nhanHieu") String nhanHieu, @RequestParam("gia") long gia,
			@RequestParam("thongTin") String thongTin, @RequestParam("anhXe") String image,
			@RequestParam("soLuong") int soLuong) {
		String anh ="";
		String ma = "";
		if(danhMuc.equals("Xe tay ga")) {
			int size = xeProductService.findXeTayGa().size() +1;
			ma = "tg"+size;
			anh = "img/xetayga/" + image;
		}else {
			int size = xeProductService.findXeSo().size() +1;
			ma = "xs"+size;
			anh = "img/xeso/" + image;
		}
		XeProduct xeProduct = new XeProduct(ma, phienBan, danhMuc, xuatXu, nhanHieu, gia, thongTin, anh, soLuong);
		xeProductService.save(xeProduct);
		return "admin/themXe";
	}
	
	
	@GetMapping("/addpk")
	public String addPk(Model model) {
		return "admin/themPhuKien";  
	}
	
	@PostMapping("/addPKDb")
	public String addPkDb(Model model, @RequestParam("tenPK") String ten,
			@RequestParam("gia") long gia,
			@RequestParam("anhPK") String image, @RequestParam("soLuong") int soLuong) {
		
		String anh = "img/phukien/" + image;
		PhuKien phuKien = new PhuKien(ten, gia, soLuong,anh);
		phuKienService.save(phuKien);
		
		return "admin/themPhuKien";
	}
	
	
	@GetMapping("/loadDonHang")
	public String loadDonHang(Model model) {

		return "loadDonHang";  
	}

	@GetMapping("/thongKe")
	public String thongKe(Model model) {

		return "thongKe";  
	}
}
