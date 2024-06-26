package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.CustomImgDTO;
import org.zerock.domain.CustomOrderDTO;
import org.zerock.domain.OrderDTO;
import org.zerock.domain.ShopGoodsVO;
import org.zerock.domain.ShoppingCartVO;
import org.zerock.service.CustomOrderService;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CustomOrderController {
	
	@Setter(onMethod_ = @Autowired )
	CustomOrderService service;

	
	
	@PreAuthorize("permitAll")
	@PostMapping("/orderCustom")
	public String orderCustom(CustomImgDTO customimginput, String modelinput, String codeinput, String customcontent,
				String quantity , String totalprice , String userid,String caseimgurl, String casename, String price,Model model) {
		//커스텀케이스 구매 페이지로 이동하는 컨트롤러 
		
		CustomOrderDTO dto = new CustomOrderDTO();
		/* dto.setCustom_image(customimginput.getUploadPath()); */
		dto.setCaseimgurl(caseimgurl);
		dto.setCasename(casename);
		dto.setCustom_content(customcontent);
		dto.setQuantity(quantity);
		dto.setTotalprice(totalprice);
		dto.setUserid(userid);
		dto.setGno(codeinput);
		dto.setPrice(price);
		dto.setModel_name(modelinput);
				
		CustomImgDTO imgdto = new CustomImgDTO();
		imgdto.setFileName(customimginput.getFileName());		
		imgdto.setUploadPath(customimginput.getUploadPath());
		imgdto.setUuid(customimginput.getUuid());
		imgdto.setImage(customimginput.isImage());
		
		model.addAttribute("dto", dto); //구매예정내역
		model.addAttribute("imgdto",imgdto ); //이미지 정보 
		
		
		return "/orderCustom";
	}
	
	//그냥 컨트롤러에서 rest방식 연습..!
	@PreAuthorize("permitAll")
	@GetMapping("/displayCustom")	
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {
		
		log.info("============display 컨트롤러========================");
		log.info("fileName: " + fileName);

		File file = new File("c:\\upload\\"+fileName+".png");
		
		log.info("file: " + file);
		log.info("========================================");
		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	@PreAuthorize("permitAll")
	@PostMapping("/orderCompleteCustom")
	public String decideOrderCustom(CustomOrderDTO dto, Model model) {
		//커스텀주문용
		
		String resultStr = "";
		
		/*
		 * log.info("==================주문 컨트롤러===================");
		 * 
		 * log.info(dto.getCasename());
		 * 
		 * log.info("==================주문 컨트롤러===================");
		 */
		
		if(dto.getOrderpw() == "" || dto.getOrderpw()==null) {
			resultStr = service.memberCustomOrder(dto); //주문확인비밀번호가 없다면(회원)
			
		}else {
			resultStr = service.noMemberCustomOrder(dto); //비회원주문
		}

		if(resultStr.equals("success")) {
			
			
			model.addAttribute("useremail", dto.getEmail());
			model.addAttribute("username", dto.getUsername());
			
			return "/completeOrder"; //주문완료 페이지로 이동
			
		}else{
			
			return "/index"; //실패시 홈으로 
			
		}
	}
	
	@PreAuthorize("permitAll")
	@PostMapping("/orderComplete")
	public String decideOrder(OrderDTO orderDto , String member_seq, @RequestParam(value="cart_no") String[] cart_no, @RequestParam(value="image") String[] image,@RequestParam(value="gno") String[] gno,@RequestParam(value="gname") String[] gname,
			@RequestParam(value="price") String[] price, @RequestParam(value="quantity") String[] quantity,@RequestParam(value="modelname") String[] modelname , Model model ) {
		//일반 주문용
		
		List<ShoppingCartVO> lists = new ArrayList<ShoppingCartVO>();

		  for(int i=0;i<cart_no.length;i++) {
		  
		  ShoppingCartVO vo =new ShoppingCartVO();
		  vo.setCart_no(cart_no[i]);
		  vo.setImage(image[i]);
		  vo.setGno(gno[i]);
		  vo.setGname(gname[i]);
		  vo.setModel(modelname[i]);
		  vo.setPrice(price[i]);
		  vo.setQuantity(quantity[i]);
		  if(member_seq != null) {
			  //회원 주문이라면 회원번호 넣음
			  vo.setMember_seq(Long.parseLong(member_seq));
		  }

		  lists.add(vo);
		  } 
		  
		String resultStr = "";
		if(orderDto.getOrderpw() == "" || orderDto.getOrderpw()==null) {
			//회원주문			
			resultStr = service.memberOrder(orderDto, lists);

		}else {
			//비회원주문
			resultStr = service.noMemberOrder(orderDto, lists);
		}

		if(resultStr.equals("success")) {
			
			model.addAttribute("useremail", orderDto.getEmail());
			model.addAttribute("username", orderDto.getUsername());
			
			return "/completeOrder"; //주문완료 페이지로 이동
			
		}else{
			
			return "/index"; //실패시 홈으로 
		}

	}
	

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/putShoppingCart")
	public String putShoppingCart(Long member_seq , String caseimgurl , String cquantity , String codeinput, String modelinput, Model model) {
		//쇼핑카트에 추가하는 컨트롤러
		
		ShoppingCartVO cartVo = new ShoppingCartVO();
		List<ShoppingCartVO> cartLists ;
		ShopGoodsVO goodsVo = service.getGoddsInfo(codeinput); //케이스정보
		
		cartVo.setMember_seq(member_seq);
		cartVo.setGno(codeinput);
		cartVo.setImage(caseimgurl);		
		cartVo.setQuantity(cquantity);
		cartVo.setModel(modelinput);
				
		String result = service.putShoppingCart(cartVo);

		if(result.equals("success")) { //쇼핑카트에 넣기 성공했다면
			
			cartLists = service.getCartList(member_seq); //쇼핑카트 리스트
			int cartElemets = service.CountCartElements(member_seq); //카트에 담긴 상품 수 
		
			model.addAttribute("cartList", cartLists); //쇼핑카트 리스트
			model.addAttribute("cartElemets", cartElemets); //카트에 담긴 상품 수 
	
			return "/shoppingCart";
			
		}else {
			//실패했을시
			
			return "/index";
		}

	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/deleteCartElement")
	public ResponseEntity<String> deleteCartElement(String memberSeq , String cart_no){
		
		long member_seq = Long.parseLong(memberSeq);
		
		int result = service.removeCartElement(member_seq, cart_no);
		
		if(result>0) {
			
			return new ResponseEntity<String>("1" , HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("0", HttpStatus.OK);
		}

	}
	
	
	/*
	 * @PreAuthorize("isAuthenticated()")
	 * 
	 * @PostMapping(value = "/orderGoods", produces =
	 * {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_JSON_VALUE})
	 * 
	 * @ResponseBody public ResponseEntity<List<ShoppingCartVO>>
	 * orderGoods(@RequestParam(value="cart_no[]") String[]
	 * cart_no, @RequestParam(value="image[]") String[]
	 * image,@RequestParam(value="gno[]") String[]
	 * gno,@RequestParam(value="gname[]") String[]
	 * gname, @RequestParam(value="model[]") String[] model,
	 * 
	 * @RequestParam(value="price[]") String[]
	 * price, @RequestParam(value="quantity[]") String[] quantity, String totalPrice
	 * , String member_seq ) {
	 * 
	 * List<ShoppingCartVO> lists = new ArrayList<ShoppingCartVO>();
	 * 
	 * 
	 * 
	 * for(int i=0;i<cart_no.length;i++) {
	 * 
	 * ShoppingCartVO vo =new ShoppingCartVO(); vo.setCart_no(cart_no[i]);
	 * vo.setImage(image[i]); vo.setGno(gno[i]); vo.setGname(gname[i]);
	 * vo.setModel(model[i]); vo.setPrice(price[i]); vo.setQuantity(quantity[i]);
	 * vo.setMember_seq(Long.parseLong(member_seq));
	 * 
	 * lists.add(vo);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * log.info("===============주문컨트롤러===========================");
	 * log.info(lists); log.info("==========================================");
	 * 
	 * return new ResponseEntity<List<ShoppingCartVO>>(lists,HttpStatus.OK); }
	 */
	
	
	@PreAuthorize("permitAll()")
	@PostMapping("/orderGoods")
	public String orderGoods(Model model, @RequestParam(value = "member_seq", required = false ) String member_seq , String totalPrice, @RequestParam(value="cart_no") String[] cart_no, @RequestParam(value="image") String[] image,@RequestParam(value="gno") String[] gno,@RequestParam(value="gname") String[] gname,
			@RequestParam(value="price") String[] price, @RequestParam(value="quantity") String[] quantity,@RequestParam(value="modelname") String[] modelname , String cartElments ) {
		
		//쇼핑카트에서 주문페이지로 넘어가는 컨트롤러
		
		List<ShoppingCartVO> lists = new ArrayList<ShoppingCartVO>();
		
		  for(int i=0;i<cart_no.length;i++) {
		  
		  ShoppingCartVO vo =new ShoppingCartVO();
		  vo.setCart_no(cart_no[i]);
		  vo.setImage(image[i]);
		  vo.setGno(gno[i]);
		  vo.setGname(gname[i]);
		  vo.setModel(modelname[i]);
		  vo.setPrice(price[i]);
		  vo.setQuantity(quantity[i]);
		  if(member_seq != null) {
			  vo.setMember_seq(Long.parseLong(member_seq));
		  }
		  lists.add(vo);

		  }
 
		model.addAttribute("cartList", lists);
		model.addAttribute("cartElements", cartElments);
		model.addAttribute("totalPrice", totalPrice);
	
		
		return "/order";
	}
	

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/myOrderList")
	@ResponseBody
	public ResponseEntity<List<OrderDTO>> myOrderList(String start_date, String end_date , String userid) {

			
		  List<OrderDTO> lists = service.myOrderedList(start_date, end_date, userid);

		return new ResponseEntity<List<OrderDTO>>(lists ,HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/myCustomOrderList")
	@ResponseBody
	public ResponseEntity<List<CustomOrderDTO>> myCustomOrderList(String start_date, String end_date , String userid) {

			
		  List<CustomOrderDTO> lists = service.myCustomOrderedList(start_date, end_date, userid);

		return new ResponseEntity<List<CustomOrderDTO>>(lists ,HttpStatus.OK);
	}
	
}
