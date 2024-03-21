package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.domain.CustomOrderDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CustomOrderController {

	
	@PostMapping("/orderCustom")
	public String orderCustom(String customimginput, String modelinput, String codeinput, String customcontent,
				String quantity , String totalprice , Model model) {
		
		
		CustomOrderDTO dto = new CustomOrderDTO();
		dto.setCodeinput(codeinput);
		dto.setCustomcontent(customcontent);
		dto.setFilePath(customimginput);
		dto.setModelinput(modelinput);
		dto.setQuantity(quantity);
		dto.setTotalprice(totalprice);
		
		model.addAttribute("dto", dto);
		
		log.info("================그냥컨트롤라====================");
		log.info(customimginput);
		log.info("====================================");
		
		return "/orderCustom";
	}
}
