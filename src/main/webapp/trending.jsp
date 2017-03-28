<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CESAR Challenge</title>
</head>

<body style="overflow: hidden;">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="mdl/material.min.js"></script>
<link rel="stylesheet" href="mdl/material.min.css">
<script src="jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(window)
			.load(
					function() {
						$
								.ajax({
									url : "TrendingHashtags",
									type : 'GET',
									contentType : "application/json; charset=utf-8",
									dataType : "json",
									async : true,
									success : function(data) {
										var trHTML = '';

										trHTML = '<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 100%;">'
												+ '<thead><tr><th class="mdl-data-table__cell--non-numeric">Hashtags</th>'
												+ '</tr></thead><tbody>';

										$
												.each(
														data,
														function(i, item) {
															trHTML += '<tr><td class="mdl-data-table__cell--non-numeric"><a href="tweetsnumber?hashtag='
																	+ item
																			.substring(1)
																	+ '">'
																	+ item
																	+ '</a>'
																	+ '</td></tr>';
														});

										trHTML += '</tbody></table>';

										$('#trendings').append(trHTML);
										$('#spinloading').removeAttr("class");
										$('#spinloading').attr("class",
												"mdl-spinner mdl-js-spinner");
									},
									error : function(xhr, type) {
										alert('Error fetching trending hashtags');
										$('#spinloading').removeAttr("class");
										$('#spinloading').attr("class",
												"mdl-spinner mdl-js-spinner");
									}
								});
					});
</script>
</head>
<body>
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title -->
				<span class="mdl-layout-title" id="topico_title">Trending
					Hashtags</span>
				<!-- Add spacer, to align navigation to the right -->
				<div class="mdl-layout-spacer"></div>

				<!-- Navigation. We hide it in small screens. -->
				<nav class="mdl-navigation mdl-layout--large-screen-only">
					<a class="mdl-navigation__link" href="index.jsp">Home</a>
				</nav>

				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
					<label class="mdl-button mdl-js-button mdl-button--icon"
						for="waterfall-exp"> <i class="material-icons">search</i>
					</label>
					<div class="mdl-textfield__expandable-holder">
						<form action="tweetsnumber" method="GET">
							<input class="mdl-textfield__input" type="text" name="hashtag"
								id="waterfall-exp">
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">CESAR Challenge</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="index.jsp">Home</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
		<div class="page-content">
			<section class="mdl-grid" id="my-table">
				<div class="mdl-layout-spacer"></div>
				<div id="spinloading" class="mdl-spinner mdl-js-spinner is-active"
					style="position: fixed; top: 50%; left: 50%"></div>
				<div id="trendings"
					class="mdl-cell mdl-cell--6-col-tablet mdl-cell--4-col-phone mdl-cell--5-col-desktop mdl-cell--stretch">
				</div>
				<div class="mdl-layout-spacer"></div>
			</section>
		</div>
		</main>
	</div>
</body>
</html>

</body>
</html>