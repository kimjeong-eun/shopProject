<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge"> -->

<!-- Header Section Begin -->

<jsp:include page="./includes/header.jsp"></jsp:include>

<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero">

	<div class="container">

		<!-- margin: 0 auto; -->
		<div style="height: 80px;">
			<div class="row">

				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>All departments</span>
						</div>
						<ul class="cateUl"
							style="position: relative; z-index: 999; background-color: white;">
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
				<!-- col-lg-3 -->

				<div class="col-lg-6">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									All Categories <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="What do you need?">
								<button type="submit" class="site-btn">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>
					</div>

				</div>
				<!-- col-lg-6 -->
				
				<div class="col-lg-3">
				<div class="hero__cart">
						<ul>
							<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
							<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
						</ul>
						<!--   <div class="header__cart__price">item: <span>$150.00</span></div> -->
					</div>
				</div>
			</div>
			<!-- .row -->
		</div>

		<!-- 히어로 -->
		<div class="hero__item">
			<!-- <div class="hero__text">
                            <span>매일이 크리스마스처럼...</span>
                            <h2> 산타의 <br />선물 상자</h2>
                            <p>장난감, 문구류 할인 및 배달 가능</p>
                            <a href="#" class="primary-btn">상품보러 가기</a>
                        </div> -->
			<video src="/resources/vid/case1.webm" style="width: 100%; height: 100%;" autoplay muted loop></video>
			
			<!-- 이것도 퍼오긴 했는데 동영상 비율이 달라서 배너? 등으로 사용하면 좋을 것 같아요 -->
			<!-- <video src="/resources/vid/case2.mp4" style="width: 100%; height: 100%;" autoplay muted loop></video> -->
		</div>
	</div>
	<!-- .container -->
</section>
<!-- Hero Section End -->

<!-- Categories Section Begin -->
<section class="categories" style="max-width: 1400px; margin: 0 auto;">
	<div class="container">
		<div class="row">
			<div class="categories__slider owl-carousel">
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="/resources/img/categories/cat-1.jpg">
						<h5>
							<a href="#">Fresh Fruit</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="/resources/img/categories/cat-2.jpg">
						<h5>
							<a href="#">Dried Fruit</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="/resources/img/categories/cat-3.jpg">
						<h5>
							<a href="#">Vegetables</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="/resources/img/categories/cat-4.jpg">
						<h5>
							<a href="#">drink fruits</a>
						</h5>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="categories__item set-bg"
						data-setbg="/resources/img/categories/cat-5.jpg">
						<h5>
							<a href="#">drink fruits</a>
						</h5>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Categories Section End -->

<!-- Blog Section Begin -->
<section class="from-blog spad" style="max-width: 1400px; margin: 0 auto;">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title from-blog__title">
					<h2>From The Blog</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="blog__item">
					<div class="blog__item__pic">
						<img src="/resources/img/blog/blog-1.jpg" alt="">
					</div>
					<div class="blog__item__text">
						<ul>
							<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
							<li><i class="fa fa-comment-o"></i> 5</li>
						</ul>
						<h5>
							<a href="#">Cooking tips make cooking simple</a>
						</h5>
						<p>Sed quia non numquam modi tempora indunt ut labore et
							dolore magnam aliquam quaerat</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="blog__item">
					<div class="blog__item__pic">
						<img src="/resources/img/blog/blog-2.jpg" alt="">
					</div>
					<div class="blog__item__text">
						<ul>
							<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
							<li><i class="fa fa-comment-o"></i> 5</li>
						</ul>
						<h5>
							<a href="#">6 ways to prepare breakfast for 30</a>
						</h5>
						<p>Sed quia non numquam modi tempora indunt ut labore et
							dolore magnam aliquam quaerat</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
				<div class="blog__item">
					<div class="blog__item__pic">
						<img src="/resources/img/blog/blog-3.jpg" alt="">
					</div>
					<div class="blog__item__text">
						<ul>
							<li><i class="fa fa-calendar-o"></i> May 4,2019</li>
							<li><i class="fa fa-comment-o"></i> 5</li>
						</ul>
						<h5>
							<a href="#">Visit the clean farm in the US</a>
						</h5>
						<p>Sed quia non numquam modi tempora indunt ut labore et
							dolore magnam aliquam quaerat</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Blog Section End -->

<script>
	$(document).ready(function() {
		$('.cateUl').hide(); //웹페이지 로딩 후 카테고리 숨김

		$('.cateUl').click(function() { //이벤트 리스너 추가

			// 현재 .cateUl의 display 속성
			var currentDisplay = $(this).css('display');

			if (currentDisplay === 'none' || currentDisplay === 'hidden') {
				$(this).show();
			} else {
				$(this).hide();
			}
		});
	});
</script>
<!-- Footer Section Begin -->

<jsp:include page="./includes/footer.jsp"></jsp:include>

<!-- Footer Section End -->