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
				<form class="m-login__form m-form" action="/login" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <#--<div class="input-group m-input__group">-->
                        <#--<input type="text" class="form-control  m-input"  placeholder="Mobile" name="mobile" autocomplete="off">-->
                        <#--<div class="input-group-append">-->
                            <#--<button class="btn btn-primary" type="button">-->
                                <#--Get Code-->
							<#--</button>-->
						<#--</div>-->
                        <#--<div id="mobile-error" class="form-control-feedback">${mobileError!}</div>-->
					<#--</div>-->
                    <div class="form-group m-form__group">
						<input class="form-control m-input" type="text" placeholder="Mobile" name="mobile" autocomplete="off">
						<div id="mobile-error" class="form-control-feedback">${mobileError!}</div>
					</div>
					<div class="form-group m-form__group collapse" id="code-holder">
						<input class="form-control m-input m-login__form-input--last" type="text" placeholder="Code" name="confirm_mobile">
					</div>
					<#--<div class="row m-login__form-sub">-->
						<#--<div class="col m--align-left m-login__form-left">-->
							<#--<label class="m-checkbox  m-checkbox--light">-->
								<#--<input type="checkbox" checked value="true" name="remember_me">-->
								<#--Remember me-->
								<#--<span></span>-->
							<#--</label>-->
						<#--</div>-->
						<#--<div class="col m--align-right m-login__form-right">-->
							<#--<a href="javascript:;" id="m_login_forget_password" class="m-link">-->
								<#--Forget Password ?-->
							<#--</a>-->
						<#--</div>-->
					<#--</div>-->
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