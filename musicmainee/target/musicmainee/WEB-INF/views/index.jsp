<html>
<div>
	<%@include file="navbar.jsp"%>
</div>

<!--  inner nav  -->
<ul class="nav nav-tabs">
	<li class="active"><a href="<c:url value="/"/>">All Product</a></li>
	<div class="btn-group">
		<button type="button" data-toggle="dropdown"class="btn btn-default dropdown-toggle">
			Category <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<c1:forEach items="${lcategorydetails}" var="list">
				<li><a href="<c:url value="/cat/${list.getCategory_id()}"/>">${list.getCategory_name()}</a></li>
			</c1:forEach>
		</ul>
</ul>
</div>
<!--  end of inner nav  -->


<!-- #region Jssor Slider Begin -->
<!-- Generator: Jssor Slider Maker -->
<!-- Source: http://www.jssor.com -->
<!-- This code works with jquery library. -->
<script src="${js}/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${js}/jssor.slider-21.1.5.mini.js" type="text/javascript"></script>
<script type="text/javascript">
        jQuery(document).ready(function ($) {
            
            var jssor_1_options = {
              $AutoPlay: true,
              $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
              },
              $ThumbnailNavigatorOptions: {
                $Class: $JssorThumbnailNavigator$,
                $Cols: 9,
                $SpacingX: 3,
                $SpacingY: 3,
                $Align: 260
              }
            };
            
            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);
            
            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizing
            function ScaleSlider() {
                var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
                if (refSize) {
                    refSize = Math.min(refSize, 1000);
                    jssor_1_slider.$ScaleWidth(refSize);
                }
                else {
                    window.setTimeout(ScaleSlider, 30);
                }
            }
            ScaleSlider();
            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end
        });
        
    </script>
<style>
/* jssor slider arrow navigator skin 02 css */
/*
        .jssora02l                  (normal)
        .jssora02r                  (normal)
        .jssora02l:hover            (normal mouseover)
        .jssora02r:hover            (normal mouseover)
        .jssora02l.jssora02ldn      (mousedown)
        .jssora02r.jssora02rdn      (mousedown)
        */
.jssora02l, .jssora02r {
	display: block;
	position: absolute;
	/* size of arrow element */
	width: 55px;
	height: 55px;
	cursor: pointer;
	background: url('${img}/a02.png') no-repeat;
	overflow: hidden;
}

.jssora02l {
	background-position: -3px -33px;
}

.jssora02r {
	background-position: -63px -33px;
}

.jssora02l:hover {
	background-position: -123px -33px;
}

.jssora02r:hover {
	background-position: -183px -33px;
}

.jssora02l.jssora02ldn {
	background-position: -3px -33px;
}

.jssora02r.jssora02rdn {
	background-position: -63px -33px;
}

/* jssor slider thumbnail navigator skin 03 css */
/*
        .jssort03 .p            (normal)
        .jssort03 .p:hover      (normal mouseover)
        .jssort03 .pav          (active)
        .jssort03 .pdn          (mousedown)
        */
.jssort03 .p {
	position: absolute;
	top: 0;
	left: 0;
	width: 62px;
	height: 32px;
}

.jssort03 .t {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border: none;
}

.jssort03 .w, .jssort03 .pav:hover .w {
	position: absolute;
	width: 60px;
	height: 30px;
	border: white 1px dashed;
	box-sizing: content-box;
}

.jssort03 .pdn .w, .jssort03 .pav .w {
	border-style: solid;
}

.jssort03 .c {
	position: absolute;
	top: 0;
	left: 0;
	width: 62px;
	height: 32px;
	background-color: #000;
	filter: alpha(opacity = 45);
	opacity: .45;
	transition: opacity .6s;
	-moz-transition: opacity .6s;
	-webkit-transition: opacity .6s;
	-o-transition: opacity .6s;
}

.jssort03 .p:hover .c, .jssort03 .pav .c {
	filter: alpha(opacity = 0);
	opacity: 0;
}

.jssort03 .p:hover .c {
	transition: none;
	-moz-transition: none;
	-webkit-transition: none;
	-o-transition: none;
}

* html .jssort03 .w {
	width /**/: 62px;
	height /**/: 32px;
}
</style>
<div id="jssor_1"
	style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; visibility: hidden;">
	<!-- Loading Screen -->
	<div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
		<div
			style="filter: alpha(opacity = 70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
		<div
			style="position:absolute;display:block;background:url('${img}/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
	</div>
	<div data-u="slides"
		style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image1.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-002.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image2.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-003.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image30.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-004.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image4.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-005.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image28.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-006.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image6.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-007.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image34.jpg" />
			<%--                 <img data-u="thumb" src="${img}/008.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image16.jpg" />
			<%--                 <img data-u="thumb" src="${img}/009.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image29.jpg" />
			<%--                 <img data-u="thumb" src="${img}/010.jpg" /> --%>
		</div>
		<div data-p="112.50" style="display: none;">
			<img data-u="image" src="${img}/image18.jpg" />
			<%--                 <img data-u="thumb" src="${img}/thumb-011.jpg" /> --%>
		</div>
		<a data-u="any" href="http://www.jssor.com" style="display: none">Image
			Slider 2</a>
	</div>
	<!-- Thumbnail Navigator -->
	<div u="thumbnavigator" class="jssort03"
		style="position: absolute; left: 0px; bottom: 0px; width: 600px; height: 60px;"
		data-autocenter="1">
		<div
			style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: #000; filter: alpha(opacity = 30.0); opacity: 0.3;"></div>
		<!-- Thumbnail Item Skin Begin -->
		<div u="slides" style="cursor: default;">
			<div u="prototype" class="p">
				<div class="w">
					<div u="thumbnailtemplate" class="t"></div>
				</div>
				<div class="c"></div>
			</div>
		</div>
		<!-- Thumbnail Item Skin End -->
	</div>
	<!-- Arrow Navigator -->
	<span data-u="arrowleft" class="jssora02l"
		style="top: 0px; left: 8px; width: 55px; height: 55px;"
		data-autocenter="2"></span> <span data-u="arrowright"
		class="jssora02r"
		style="top: 0px; right: 8px; width: 55px; height: 55px;"
		data-autocenter="2"></span>
</div></br>
<!-- #endregion Jssor Slider End -->




<div class="Container">
<!-- 	<div class="row"> -->
<!-- 		<div class="col-sm-4"> -->
<%-- 			<img src="${img}\image13.jpg" class="img-circle" alt="Jellyfish" --%>
<!-- 				style="width: 240px; height: 200px"> -->
<!-- 		</div> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-sm-4"> -->
<%-- 				<img src="${img}\image15.jpg" class="img-circle" alt="Koala" --%>
<!-- 					style="width: 240px; height: 200px"> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-sm-4"> -->
<%-- 					<img src="${img}\Desert.jpg" class="img-circle" alt="Desert" --%>
<!-- 						style="width: 240px; height: 200px"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			</div> -->
<!-- 			</div> -->
			</br>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Product Id</th>
						<th>Category Name</th>
						<!--         <th>supplier_id</th> -->
						<th>Product Price</th>
						<th>Product Quantity</th>
						<th>Product Description</th>
						<th>Product Image</th>
						<security:authorize access="permitAll">
						<th>View</th>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<th>Edit</th>
						</security:authorize>
					</tr>
				</thead>

				<c1:forEach items="${list}" var="list">
					<tr>
						<td><a href="#">${list.getProduct_name()}</a></td>
						<td><a href="#">${list.getProduct_id()}</a></td>
						<td><a href="#">${list.getCategory().getCategory_name()}</a>
						<td><a href="#">${list.getProduct_price()}</a></td>
						<td><a href="#">${list.getProduct_quantity()}</a></td>
						<td><a href="#">${list.getProduct_description()} </a></td>
						<td><img src="${img}/${list.getImage()}" alt="Image not found" style="width:20%"></a></td>
						<security:authorize access="permitAll">
                        <td><a href='<c:url value="/View/${list.getProduct_id()}"></c:url>'>View</a></td>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
<!-- 					 <td><input type="submit" class="btn btn-primary" value="Edit" /></td> -->
						 <td><a href='<c:url value="/pedit/${list.product_id}"></c:url>'>Edit</a></td>
						</security:authorize>
<%-- 						<c:url value="/addtocart" var="url"/> --%>
<%-- 						<a href="${url}" type="submit" class="btn btn-primary"/>AddToCart</a> --%>
					</tr>
				</c1:forEach>
			</table>

			<footer class="container">
				<a href="#"><i class="fa fa-facebook-official"></i></a> <i
					class="fa fa-twitter-square" aria-hidden="true"></i>
			</footer>
</html>
