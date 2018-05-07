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
                <div class="m-login__head">
                    <h3 class="m-login__title">
                        Add your plate number
                    </h3>
                    <div class="m-login__desc">
                        Add your current plate number!
                    </div>
                </div>

                <form class="m-login__form m-form" action="/addPlate" method="post">
                    <div class="form-group m-form__group">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input class="form-control m-input" type="text" placeholder="Plate number" name="plateNumber" autocomplete="off">
                    </div>
                    <div class="m-login__form-action">
                        <button id="m_login_forget_password_submit" class="btn m-btn m-btn--pill m-btn--custom m-btn--air m-login__btn m-login__btn--primary">
                            Send
                        </button>
                        &nbsp;&nbsp;
                        <button id="m_login_forget_password_cancel" class="btn m-btn m-btn--pill m-btn--custom m-btn--air m-login__btn">
                            Cancel
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</@layout>