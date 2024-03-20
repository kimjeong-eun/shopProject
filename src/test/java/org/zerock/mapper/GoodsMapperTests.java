package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.GoodsVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
@Log4j2
public class GoodsMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private GoodsMapper mapper;
	
	@Test
	public void testInsert() {
		GoodsVO goods = new GoodsVO();
		goods.setGname("테스트 상품G");
		goods.setPrice(9999);
		goods.setQuantity(99);

		mapper.insert(goods);

		log.info(goods);
	}
	
	@Test
	public void testRead() {
		GoodsVO goods = mapper.read(2L);
		
		log.info(goods);
	}
	
	@Test
	public void testInsertSelectKey() {
		GoodsVO goods = new GoodsVO();
		goods.setGname("새로 작성하는 상품");
		goods.setPrice(22222);
		goods.setQuantity(22);
		//goods.setInformation("새로 작성하는 상품 설명");
		
		mapper.insertSelectKey(goods);
		
		log.info(goods);
		//goods.setTitle
	}
}
