package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.CustomOrderDTO;
import org.zerock.domain.OrderDTO;
import org.zerock.domain.ShopGoodsVO;
import org.zerock.domain.ShoppingCartVO;


public interface CustomOrderService {

	public String memberCustomOrder(CustomOrderDTO dto); //회원주문 (커스텀)
	public String noMemberCustomOrder(CustomOrderDTO dto); //비회원주문(커스텀)
	
	
	public String memberOrder(OrderDTO dto , List<ShoppingCartVO> cartList );//회원주문 (커스텀)
	public String noMemberOrder(OrderDTO dto, List<ShoppingCartVO> cartList );//비회원주문(커스텀)
	
	
	public ShopGoodsVO getGoddsInfo(String dno); //상품코드로 정보가져오기
	
	public int CountCartElements (long member_seq); //멤버 시퀀스로 쇼핑카트 제품수 가져오기
	public String putShoppingCart (ShoppingCartVO vo); //쇼핑카트 넣기
	public List<ShoppingCartVO> getCartList(long member_seq); //멤버시퀀스로 쇼핑카트리스트 가져오기
	
	public int removeCartElement(long member_seq,String cart_no); //해당멤버의 쇼핑카트 제품 삭제
	
	
	
	public List<OrderDTO> myOrderedList(String start_date , String end_date, String userid);//해당 유저의 구매 목록을 가져옴
	public List<CustomOrderDTO> myCustomOrderedList(String start_date , String end_date, String userid);//해당 유저의 커스텀 구매 목록을 가져옴
	
}
