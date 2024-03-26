<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> -->
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="kr">

<style>
body {
	height: auto;
}

.dropdown-menu {
	width: 94%;
	overflow: auto;
}

/* 분류 버튼 */
.dropdown-toggle {
	width: 100%;
}

.dropdown-menu-apple, .dropdown-menu-sam {
	display: none;
}

input[type=file]::file-selector-button {
	width: 150px;
	height: 30px;
	background: #fff;
	border: 1px solid rgb(77, 77, 77);
	border-radius: 3px;
	cursor: pointer; &: hover { background : rgb( 77, 77, 77);
	color: #fff;
}

}

/* 기본 크기 */
.checkout.spad {
	min-height: 1160px; /* 기본 최소 높이 */
}

/* 화면 너비가 768px 이하인 경우 */
@media ( max-width : 768px) {
	.checkout.spad {
		min-height: 300px; /* 더 작은 높이로 조정 */
	}
}

/* 화면 너비가 576px 이하인 경우 */
@media ( max-width : 576px) {
	.checkout.spad {
		min-height: 1600px; /* 더 작은 높이로 조정 */
	}
}
</style>

<!-- Header Section Begin -->

<jsp:include page="../includes/header.jsp"></jsp:include>

<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero-normal">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="#">Fresh Meat</a></li>
						<li><a href="#">Vegetables</a></li>
						<li><a href="#">Fruit & Nut Gifts</a></li>
						<li><a href="#">Fresh Berries</a></li>
						<li><a href="#">Ocean Foods</a></li>
						<li><a href="#">Butter & Eggs</a></li>
						<li><a href="#">Fastfood</a></li>
						<li><a href="#">Fresh Onion</a></li>
						<li><a href="#">Papayaya & Crisps</a></li>
						<li><a href="#">Oatmeal</a></li>
						<li><a href="#">Fresh Bananas</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<!-- <div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">
								All Categories <span class="arrow_carrot-down"></span>
							</div>
							<input type="text" placeholder="What do yo u need?">
							<button type="submit" class="site-btn">SEARCH</button>
						</form> -->
				</div>
				<div class="hero__search__phone">
					<div class="hero__search__phone__icon">
						<i class="fa fa-phone"></i>
					</div>
					<div class="hero__search__phone__text">
						<h5>+65 11.188.888</h5>
						<span>support 24/7 time</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
<!-- Hero Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg"
	data-setbg="/resources/img/bg1.png">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>상품 상세 정보</h2>
					<div class="breadcrumb__option">
						<a href="./index.html">Home</a> <a href="./index.html">Vegetables</a>
						<span>Vegetable’s Package</span>
					</div>
				</div>
			</div>
		</div>
		row

	</div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
	<div class="container" style="max-width: 1370px;">
			<div class="row">

				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
					
						<div class="product__details__pic__item">
						<!-- <div class="checkout__input"> -->
							<img class="product__details__pic__item--large"
								src="/resources/img/product/details/product-details-1.jpg"
								alt="">
						</div>
						
						<div class="product__details__pic__slider owl-carousel">
							<img
								data-imgbigurl="/resources/img/product/details/product-details-2.jpg"
								src="/resources/img/product/details/thumb-1.jpg" alt=""> <img
								data-imgbigurl="/resources/img/product/details/product-details-3.jpg"
								src="/resources/img/product/details/thumb-2.jpg" alt=""> <img
								data-imgbigurl="/resources/img/product/details/product-details-5.jpg"
								src="/resources/img/product/details/thumb-3.jpg" alt=""> <img
								data-imgbigurl="/resources/img/product/details/product-details-4.jpg"
								src="/resources/img/product/details/thumb-4.jpg" alt="">
						</div>
						
					</div> <!-- product__details__pic__item -->
				</div>

				<div class="col-lg-6 col-md-6" style="box-sizing: border-box;">

					<!-- 예쁜 레이아웃 쀼쀼 -->
					<div class="product__details__text">

						<div class="checkout__input row">
							<div class="col">
								<p>
									상품번호<span>*</span>
								</p>
							</div>
							<div class="col">
								<input name="gno" type="text" value='${goods.gno}'
									style="color: black; border: 0;" readonly="readonly" />
							</div>
						</div>

						<div class="checkout__input row"
							style="margin-top: 50px; color: #252525; font-weight: 700; margin-bottom: 16px;">
							<div class="col">
								<p>
									상품명<span>*</span>
								</p>
							</div>
							<div class="col">
								<input name="gname" type="text"
									value='${goods.gname}'
									style="color: black; border: 0;" readonly="readonly">
							</div>
						</div>

						<div class="checkout__input row">
							<div class="col">
								<p>판매가</p>
							</div>
							<div class="col row">
								<div class="col-9" style="padding: 0;">
									<input name="price" type="text"
										class="checkout__input__add product__details__price"
										value='${goods.price}'
										style="color: black; border: 0;" readonly="readonly">
								</div>
								<div class="col-3">
									<span class="product__details__price" style="color: black";>원</span>
								</div>
							</div>
						</div>

						<div class="checkout__input row" style="height: 80px">
							<p>
								기종 카테고리<span>*</span>
							</p>
							<!-- 대분류 -->
							<div class="dropdown col">
								<button class="btn btn-light dropdown-toggle brandBtn"
									style="border-radius: 0;" type="button" aria-expanded="false">브랜드</button>
								<ul class="dropdown-menu"
									style="border-radius: 0; border: none; background-color: #f5f5f5;">
									<li><a class="dropdown-item dropdown-brand1">애플</a></li>
									<li><a class="dropdown-item dropdown-brand2">삼성</a></li>
									<li><a class="dropdown-item dropdown-brand3">구글</a></li>
								</ul>
							</div>
							<!-- 중분류 -->
							<div class="dropdown col">
								<button class="btn btn-light dropdown-toggle" type="button"
									style="border-radius: 0;" aria-expanded="false">기기명</button>

								<ul class="dropdown-menu dropdown-menu-apple"
									style="border-radius: 0; border: none; background-color: #f5f5f5;">
									<li><a class="dropdown-item">아이폰 S</a></li>
								</ul>
								<ul class="dropdown-menu dropdown-menu-sam"
									style="border-radius: 0; border: none; background-color: #f5f5f5;">
									<li><a class="dropdown-item" href="">갤럭시 S</a></li>
								</ul>
							</div>
						</div>

						<ul>
							<li><b>Availability</b> <span>In Stock</span></li>
							<li><b>Shipping</b> <span>01 day shipping. <samp>Free
										pickup today</samp></span></li>
							<li><b>Weight</b> <span>0.5 kg</span></li>
							<li><b>Share on</b>
								<div class="share">
									<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
										class="fa fa-twitter"></i></a> <a href="#"><i
										class="fa fa-instagram"></i></a> <a href="#"><i
										class="fa fa-pinterest"></i></a>
								</div></li>
						</ul>
					</div>
					<!-- details -->

					<!-- <div class="checkout__input">
						<p>
							재고수량<span>*</span>
						</p>
						<input type="text">
					</div> -->

					<!-- <div class="checkout__input__checkbox">
                                <label for="acc">
                                    Create an account?
                                    <input type="checkbox" id="acc">
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <p>Create an account by entering the information below. If you are a returning customer
                            please login at the top of the page</p> -->
				</div>
				<!-- col-lg-7 -->
			</div>
			<!-- row -->

			<div class="checkout__input" style="text-align: center;">
				<button type="reset" class="btn btn-default" data-oper='modify'
					style="padding: 15px 60px; font-size: 1rem; border: 1px solid grey">수정</button>
					
				<button type="submit" class="btn btn-info" data-oper='list'
					style="margin-top: 160px; padding: 15px 60px; font-size: 1rem;">목록</button>
					
				<form id="operForm" action="/goods/modify" method="get">
				<input type="hidden" id="gno" name="gno" value='${goods.gno}'>
				</form>	
			</div> <!-- checkout__input -->


	</div>
	<!-- container -->

	<div class="col-lg-12">
		<div class="product__details__tab">
			<ul class="nav nav-tabs" role="tablist">
				<li class="nav-item"style="border: 1px grey solid; padding: 20px 50px;"><a class="nav-link active"
					data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">상품정보</a>
				</li>
				<li class="nav-item" style="border: 1px grey solid; padding: 20px 50px;"><a class="nav-link" data-toggle="tab"
					href="#tabs-2" role="tab" aria-selected="false">Q&A</a></li>
				<li class="nav-item" style="border: 1px grey solid; padding: 20px 50px;"><a class="nav-link" data-toggle="tab"
					href="#tabs-3" role="tab" aria-selected="false">리뷰<span>(1)</span></a>
				</li>
			</ul>
			<div class="tab-content">
			
				<div class="tab-pane active" id="tabs-1" role="tabpanel">
					<div class="product__details__tab__desc mx-auto" style="width: 80%;">
						<textarea name="information" type="text" rows="5"
								style="width: 80%; font-size: 20px; color: black; line-height: 26px; margin: 0 0 15px 0; border: 0;"
							 readonly="readonly">${goods.information}</textarea>
					</div> <!-- product__details__tab__desc -->
				</div> <!-- tabpane -->
				
				<div class="tab-pane" id="tabs-2" role="tabpanel">
					<div class="product__details__tab__desc">
						<h6>Products Infomation</h6>
						<p>Vestibulum ac diam sit amet quam vehicula elementum sed sit
							amet dui. Pellentesque in ipsum id orci porta dapibus. Proin eget
							tortor risus. Vivamus suscipit tortor eget felis porttitor
							volutpat. Vestibulum ac diam sit amet quam vehicula elementum sed
							sit amet dui. Donec rutrum congue leo eget malesuada. Vivamus
							suscipit tortor eget felis porttitor volutpat. Curabitur arcu
							erat, accumsan id imperdiet et, porttitor at sem. Praesent sapien
							massa, convallis a pellentesque nec, egestas non nisi. Vestibulum
							ac diam sit amet quam vehicula elementum sed sit amet dui.
							Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
							posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam
							vel, ullamcorper sit amet ligula. Proin eget tortor risus.</p>
						<p>Praesent sapien massa, convallis a pellentesque nec,
							egestas non nisi. Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Mauris blandit aliquet elit, eget tincidunt nibh
							pulvinar a. Cras ultricies ligula sed magna dictum porta. Cras
							ultricies ligula sed magna dictum porta. Sed porttitor lectus
							nibh. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar
							a.</p>
					</div>
				</div> <!-- tab-pane -->
				
				<div class="tab-pane" id="tabs-3" role="tabpanel">
					<div class="product__details__tab__desc">
						<h6>Products Infomation</h6>
						<p>Vestibulum ac diam sit amet quam vehicula elementum sed sit
							amet dui. Pellentesque in ipsum id orci porta dapibus. Proin eget
							tortor risus. Vivamus suscipit tortor eget felis porttitor
							volutpat. Vestibulum ac diam sit amet quam vehicula elementum sed
							sit amet dui. Donec rutrum congue leo eget malesuada. Vivamus
							suscipit tortor eget felis porttitor volutpat. Curabitur arcu
							erat, accumsan id imperdiet et, porttitor at sem. Praesent sapien
							massa, convallis a pellentesque nec, egestas non nisi. Vestibulum
							ac diam sit amet quam vehicula elementum sed sit amet dui.
							Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
							posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam
							vel, ullamcorper sit amet ligula. Proin eget tortor risus.</p>
					</div>
				</div> <!-- tab-pane -->
				
			</div>
		</div>
	</div>
	</div>
	</div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
	<div class="container" style="max-width: 1370px;">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title related__product__title">
					<h2>Related Product</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="/resources/img/product/product-1.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="/resources/img/product/product-2.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="/resources/img/product/product-3.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-4 col-sm-6">
				<div class="product__item">
					<div class="product__item__pic set-bg"
						data-setbg="/resources/img/product/product-7.jpg">
						<ul class="product__item__pic__hover">
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="#"><i class="fa fa-retweet"></i></a></li>
							<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
						</ul>
					</div>
					<div class="product__item__text">
						<h6>
							<a href="#">Crab Pool Security</a>
						</h6>
						<h5>$30.00</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Related Product Section End -->

<script>
	$(document).ready(function() {
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e) { //수정 버튼을 누를 경우
			operForm.attr("action", "/goods/modify").submit(); //input[type='hidden']의 gno를 보내고 이동
		});
		
		$("button[data-oper='list']").on("click", function(e) { //목록 버튼을 누를 경우
			operForm.find("#gno").remove();  //gno 삭제
			operForm.attr("action", "/goods/goodsList"); //list로 이동
			operForm.submit();
		});
	});
</script>

<!-- Footer Section Begin -->

<jsp:include page="../includes/footer.jsp"></jsp:include>

<!-- Footer Section End -->