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
<style>
.card-wide.mdl-card {
	width: 512px;
}

.card-wide>.mdl-card__title {
	color: #fff;
	height: 176px;
	background: url("images/cardimage.png") center/cover;
}

.card-wide>.mdl-card__menu {
	color: #fff;
}
</style>
</head>
<body>
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title -->
				<span class="mdl-layout-title" id="topico_title">CESAR
					Challenge</span>
				<!-- Add spacer, to align navigation to the right -->
				<div class="mdl-layout-spacer"></div>
				<!-- Navigation. We hide it in small screens. -->
				<nav class="mdl-navigation mdl-layout--large-screen-only">
					<a class="mdl-navigation__link" href="hashtags">Trending
						Hashtags</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">CESAR Challenge</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="hashtags">Trending
					Hashtags</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
		<div class="page-content">
			<section class="mdl-grid" id="my-table">
				<div class="mdl-layout-spacer"></div>
				<div
					class="mdl-cell mdl-cell--6-col-tablet mdl-cell--4-col-phone mdl-cell--5-col-desktop mdl-cell--stretch">
					<div class="card-wide mdl-card mdl-shadow--2dp"
						style="width: 100%;">
						<div class="mdl-card__title">
							<h2 class="mdl-card__title-text">Welcome</h2>
						</div>
						<div class="mdl-card__supporting-text">This application was
							developed for the challenge proposed by the C.E.S.A.R - Recife
							Center for Advanced Studies and Systems. The trending hashtags page
							displays a list of the most popular hashtags and also allows the
							user to search for any hashtag of their interest. When the user
							searches or selects a hashtag from the list, the application
							plots a bar graph with the number of tweets per Brazilian state
							related to the hashtag.</div>
						<div class="mdl-card__actions mdl-card--border">
							<a href="hashtags"
								class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
								Go to Trending Hashtags </a>
						</div>
						<!-- <div class="mdl-card__menu">
							<button
								class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
								<i class="material-icons">share</i>
							</button>
						</div> -->
					</div>
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