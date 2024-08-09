/*
 * @ (#) Controller.java  1  6/27/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package iuh.controller;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 6/27/2024
 * @version: 1.0
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.modal.Cart;
import iuh.modal.PhuKien;
import iuh.modal.XeProduct;
import iuh.services.CartService;
import iuh.services.PhuKienService;
import iuh.services.XeProductService;

@RequestMapping
@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private XeProductService xeProductService;
	@Autowired
	private PhuKienService phuKienService;
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public String hello(Model model) {
		List<PhuKien> listPhuKien = phuKienService.findAll();
		List<XeProduct> listTayGa = xeProductService.findXeTayGa(6);
		List<XeProduct> listXeSo = xeProductService.findXeSo(6);
		model.addAttribute("listTayGa", listTayGa);
		model.addAttribute("listXeSo", listXeSo);
		model.addAttribute("listPhuKien", listPhuKien);
		return "index";
	}
	
	
	@GetMapping("/gioithieu")
	public String lienhe() {
		return "lienhe";
	}

	@GetMapping("/baohanh")
	public String baohanh() {
		return "baohanh";
	}
	
	
	@GetMapping("/signin/addCart")
	public String addCart(Model model, @RequestParam("id") String id,
			@RequestParam("price") double price,
			@RequestParam("soluong") int soluong) {
		
		Cart cart = cartService.save(id, price, soluong);

		XeProduct list = xeProductService.findById(id);
		model.addAttribute("list", list);
		model.addAttribute("cart", cart);
		
		return "user/gioHang";
	}
}
