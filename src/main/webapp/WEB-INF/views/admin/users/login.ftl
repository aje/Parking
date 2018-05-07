<#include "../empty-layout.ftl">



<#macro otherSripts>
<script src='<@spring.url value="${jsPath}login.js" />' type="text/javascript"></script>
</#macro>

<@layout  title='Login'>
<div class="m-grid__item m-grid__item--fluid m-grid m-grid--hor m-login m-login--signin m-login--2 m-login-2--skin-1" id="m_login" style="background-image: url(${imgPath}bg/bg-1.jpg);">
	<div class="m-grid__item m-grid__item--fluid m-login__wrapper">
		<div class="m-login__container">
			<div class="m-login__logo">
				<a href="#">
					<img src="${imgPath}logos/logo-1.png">
				</a>
			</div>
			<div class="m-login__signin">
				<div class="m-login__head m--margin-bottom-20">
					<h3 class="m-login__title">
						Sign In To Parking
					</h3>
					<div id="login-error" class="form-control-feedback">${msg!}</div>
				</div>
				<form class="m-login__form m-form" action="/login" method="post" target="csrfIframe1">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="form-group m-form__group">
						<input class="form-control m-input" type="number" minlength="11" maxlength="11" size="11" required placeholder="Mobile" name="mobile" autocomplete="off">
						<div id="mobile-error" class="form-control-feedback">${mobileError!}</div>
					</div>
					<div class="form-group m-form__group collapse" id="code-holder">
						<input class="form-control m-input m-login__form-input--last" type="text" placeholder="Code" name="confirm_mobile">
					</div>
					<div class="m-login__form-action">
						<button id="m_login_getcode_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air  m-login__btn m-login__btn--primary">
							Get Code
						</button>
						<button id="m_login_signin_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air  m-login__btn m-login__btn--primary">
							Login
						</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>

</@layout>