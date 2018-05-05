<#include "../layout.ftl">

<#macro otherSripts>
<script src='<@spring.url value="${jsPath}wizard.js" />' type="text/javascript"></script>
<script src='<@spring.url value="${jsPath}form-repeater.js" />' type="text/javascript"></script>
</#macro>

<@layout  title='Dashboard'>
<!--Begin::Main Portlet-->
<div class="m-portlet m-portlet--full-height">
    <!--begin: Portlet Head-->
    <div class="m-portlet__head">
        <div class="m-portlet__head-caption">
            <div class="m-portlet__head-title">
                <h3 class="m-portlet__head-text">
                    Adding Parking Lot
                </h3>
            </div>
        </div>
        <div class="m-portlet__head-tools">
            <ul class="m-portlet__nav">
                <li class="m-portlet__nav-item">
                    <a href="#" data-toggle="m-tooltip" class="m-portlet__nav-link m-portlet__nav-link--icon" data-direction="left" data-width="auto" title="Get help with filling up this form">
                        <i class="flaticon-info m--icon-font-size-lg3"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!--end: Portlet Head-->
    <!--begin: Portlet Body-->
    <div class="m-portlet__body m-portlet__body--no-padding">
        <!--begin: Form Wizard-->
        <div class="m-wizard m-wizard--3 m-wizard--success" id="m_wizard">
            <!--begin: Message container -->
            <div class="m-portlet__padding-x">
                <!-- Here you can put a message or alert -->
            </div>
            <!--end: Message container -->
            <div class="row m-row--no-padding">
                <div class="col-xl-4 col-lg-12">
                    <!--begin: Form Wizard Head -->
                    <div class="m-wizard__head">
                        <!--begin: Form Wizard Progress -->
                        <div class="m-wizard__progress">
                            <div class="progress">
                                <div class="progress-bar"  role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                        </div>
                        <!--end: Form Wizard Progress -->
                        <!--begin: Form Wizard Nav -->
                        <div class="m-wizard__nav">
                            <div class="m-wizard__steps">
                                <div class="m-wizard__step m-wizard__step--current" data-wizard-target="#m_wizard_form_step_1">
                                    <div class="m-wizard__step-info">
                                        <a href="#" class="m-wizard__step-number">
                                            <span>
                                                <span>
                                                    1
                                                </span>
                                            </span>
                                        </a>
                                        <div class="m-wizard__step-line">
                                            <span></span>
                                        </div>
                                        <div class="m-wizard__step-label">
                                            Lot Info
                                        </div>
                                    </div>
                                </div>
                                <div class="m-wizard__step" data-wizard-target="#m_wizard_form_step_2">
                                    <div class="m-wizard__step-info">
                                        <a href="#" class="m-wizard__step-number">
                                            <span>
                                                <span>
                                                    2
                                                </span>
                                            </span>
                                        </a>
                                        <div class="m-wizard__step-line">
                                            <span></span>
                                        </div>
                                        <div class="m-wizard__step-label">
                                            Spots Info
                                        </div>
                                    </div>
                                </div>
                                <#--<div class="m-wizard__step" data-wizard-target="#m_wizard_form_step_3">-->
                                    <#--<div class="m-wizard__step-info">-->
                                        <#--<a href="#" class="m-wizard__step-number">-->
                                            <#--<span>-->
                                                <#--<span>-->
                                                    <#--3-->
                                                <#--</span>-->
                                            <#--</span>-->
                                        <#--</a>-->
                                        <#--<div class="m-wizard__step-line">-->
                                            <#--<span></span>-->
                                        <#--</div>-->
                                        <#--<div class="m-wizard__step-label">-->
                                            <#--Billing Setup-->
                                        <#--</div>-->
                                    <#--</div>-->
                                <#--</div>-->
                                <div class="m-wizard__step" data-wizard-target="#m_wizard_form_step_3">
                                    <div class="m-wizard__step-info">
                                        <a href="#" class="m-wizard__step-number">
                                            <span>
                                                <span>
                                                    3
                                                </span>
                                            </span>
                                        </a>
                                        <div class="m-wizard__step-line">
                                            <span></span>
                                        </div>
                                        <div class="m-wizard__step-label">
                                            Confirmation
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end: Form Wizard Nav -->
                    </div>
                    <!--end: Form Wizard Head -->
                </div>
                <div class="col-xl-8 col-lg-12">
                    <!--begin: Form Wizard Form-->
                    <div class="m-wizard__form">
                        <!--
                            1) Use m-form--label-align-left class to alight the form input lables to the right
                            2) Use m-form--state class to highlight input control borders on form validation
                        -->
                        <form class="m-form m-form--label-align-left- m-form--state-" id="m_form" method="post">
                            <!--begin: Form Body -->
                            <div class="m-portlet__body m-portlet__body--no-padding">
                                <!--begin: Form Wizard Step 1-->
                                <div class="m-wizard__form-step m-wizard__form-step--current" id="m_wizard_form_step_1">
                                    <div class="m-form__section m-form__section--first">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Parking Lot Details
                                            </h3>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                * Name:
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <input type="text" name="name" class="form-control m-input" placeholder="" value="">
                                                <span class="m-form__help">
                                                    Please enter the name of parking lot
                                                </span>
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                * Capacity:
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <input type="number" name="capacity" class="form-control m-input" placeholder="" value="">
                                                <span class="m-form__help">
                                                    Capacity of parking lot, the number of spots
                                                </span>
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                Phone
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                            <i class="la la-phone"></i>
                                                        </span>
                                                    </div>
                                                    <input type="text" name="phone" class="form-control m-input" placeholder="" value="">
                                                </div>
                                                <span class="m-form__help">
                                                    Enter your valid phone
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                    <div class="m-form__section">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Address
                                                <i data-toggle="m-tooltip" data-width="auto" class="m-form__heading-help-icon flaticon-info" title="Some help text goes here"></i>
                                            </h3>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                * Address Line 1:
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <input type="text" name="addressLot.fullAddress" class="form-control m-input" placeholder="" value="">
                                                <span class="m-form__help">
                                                    Street address, P.O. box, company name, c/o
                                                </span>
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                Province
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <select name="addressLot.province" class="form-control m-input">
                                                    <option value="sichuan">Sichuan</option>
                                                    <option value="beijing">Beijing</option>
                                                    <option value="beijing">Beijing</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                * City:
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <#--<input type="text" name="city" class="form-control m-input" placeholder="" value="">-->
                                                <select name="addressLot.city" class="form-control m-input">
                                                    <option value="chengdu">Chengdu</option>
                                                    <option value="beijing">Beijing</option>
                                                    <option value="beijing">Beijing</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                Baidu map X location
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <input type="text" name="addressLot.locationX" class="form-control m-input" placeholder="" value="">
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <label class="col-xl-3 col-lg-3 col-form-label">
                                                Baidu map Y location
                                            </label>
                                            <div class="col-xl-9 col-lg-9">
                                                <input type="text" name="addressLot.locationY" class="form-control m-input" placeholder="" value="">
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <!--end: Form Wizard Step 1-->
                                <!--begin: Form Wizard Step 2-->
                                <div class="m-wizard__form-step" id="m_wizard_form_step_2">
                                    <div class="m-form__section m-form__section--first">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Parking Lot Info
                                            </h3>
                                        </div>
                                        <#--<div class="form-group m-form__group row">-->
                                            <#--<div class="col-lg-12">-->
                                                <#--<label class="form-control-label">-->
                                                    <#--* Number of spots:-->
                                                <#--</label>-->
                                                <#--<input type="url" name="account_url" class="form-control m-input" placeholder="" value="http://sinortech.vertoffice.com">-->
                                            <#--</div>-->
                                        <#--</div>-->
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-6 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * Floors:
                                                </label>
                                                <input type="text" name="account_username" class="form-control m-input" placeholder="" value="nick.stone">
                                                <span class="m-form__help">
                                                    Enter the number of floors
                                                </span>
                                            </div>
                                            <div class="col-lg-6 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * Rows:
                                                </label>
                                                <input type="password" name="account_password" class="form-control m-input" placeholder="" value="qwerty">
                                                <span class="m-form__help">
                                                    Each row can be a number of spots
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                    <div class="m-form__section">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Add Spots
                                            </h3>
                                        </div>
                                        <div id="m_repeater_1">
                                            <div data-repeater-list="">
                                                <div  data-repeater-item >
                                                    <div class="form-group m-form__group row">
                                                        <div class="col-lg-5 m-form__group-sub">
                                                            <label class="form-control-label">
                                                                * Floor:
                                                            </label>
                                                            <input type="text" name="floor" class="form-control m-input" placeholder="" value="">
                                                        </div>
                                                        <div class="col-lg-5 m-form__group-sub">
                                                            <label class="form-control-label">
                                                                * Row:
                                                            </label>
                                                            <input type="text" name="row" class="form-control m-input" placeholder="" value="">
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div data-repeater-delete="" class="btn-sm btn btn-danger m-btn m-btn--icon m-btn--pill m--margin-top-10">
																<span>
																	<i class="la la-trash-o"></i>
																	<span>
																		Delete
																	</span>
																</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group m-form__group row">
                                                <div class="col-lg-4 m-form__group-sub">
                                                    <label class="form-control-label">
                                                        * location X:
                                                    </label>
                                                    <input type="text" name="locationX" class="form-control m-input" placeholder="" value="">
                                                </div>
                                                <div class="col-lg-4 m-form__group-sub">
                                                    <label class="form-control-label">
                                                        * Location Y:
                                                    </label>
                                                    <input type="text" name="locationY" class="form-control m-input" placeholder="" value="">
                                                </div>
                                                <div class="col-lg-4 m-form__group-sub">
                                                    <label class="form-control-label">
                                                        * Lora Serial Number:
                                                    </label>
                                                    <input type="number" class="form-control m-input" name="loraSerial" placeholder="" value="450">

                                                </div>
                                            </div>
                                                </div>
                                            </div>
                                            <div class="m-form__group form-group row">
                                                <div class="col-lg-4">
                                                    <div data-repeater-create="" class="btn btn btn-sm btn-brand m-btn m-btn--icon m-btn--pill m-btn--wide">
														<span>
															<i class="la la-plus"></i>
															<span>
																Add
															</span>
														</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--end: Form Wizard Step 2-->
                                <!--begin: Form Wizard Step 3-->
                                <div class="m-wizard__form-step" id="m_wizard_form_step_3">
                                    <div class="m-form__section m-form__section--first">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Floor 1
                                            </h3>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-12">
                                                <label class="form-control-label">
                                                    * Row:
                                                </label>
                                                <input type="text" name="billing_card_name" class="form-control m-input" placeholder="" value="Nick Stone">
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-12">
                                                <label class="form-control-label">
                                                    * Number:
                                                </label>
                                                <input type="text" name="billing_card_number" class="form-control m-input" placeholder="" value="372955886840581">
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-4 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * Exp Month:
                                                </label>
                                                <input type="number" class="form-control m-input" name="billing_card_cvv" placeholder="" value="450">

                                            </div>
                                            <div class="col-lg-4 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * Exp Year:
                                                </label>
                                                <input type="number" class="form-control m-input" name="billing_card_cvv" placeholder="" value="450">

                                            </div>
                                            <div class="col-lg-4 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * CVV:
                                                </label>
                                                <input type="number" class="form-control m-input" name="billing_card_cvv" placeholder="" value="450">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                    <div class="m-form__section">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Billing Address
                                                <i data-toggle="m-tooltip" data-width="auto" class="m-form__heading-help-icon flaticon-info" title="If different than the corresponding address"></i>
                                            </h3>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-12">
                                                <label class="form-control-label">
                                                    * Address 1:
                                                </label>
                                                <input type="text" name="billing_address_1" class="form-control m-input" placeholder="" value="Headquarters 1120 N Street Sacramento 916-654-5266">
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-12">
                                                <label class="form-control-label">
                                                    Address 2:
                                                </label>
                                                <input type="text" name="billing_address_2" class="form-control m-input" placeholder="" value="P.O. Box 942873 Sacramento, CA 94273-0001">
                                            </div>
                                        </div>
                                        <div class="form-group m-form__group row">
                                            <div class="col-lg-5 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * City:
                                                </label>
                                                <input type="text" class="form-control m-input" name="billing_city" placeholder="" value="Polo Alto">
                                            </div>
                                            <div class="col-lg-5 m-form__group-sub">
                                                <label class="form-control-label">
                                                    * State:
                                                </label>
                                                <input type="text" class="form-control m-input" name="billing_state" placeholder="" value="California">
                                            </div>
                                            <div class="col-lg-2 m-form__group-sub">
                                                <label  class="form-control-label">
                                                    * ZIP:
                                                </label>
                                                <input type="text" class="form-control m-input" name="billing_zip" placeholder="" value="34890">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                    <div class="m-form__section">
                                        <div class="m-form__heading">
                                            <h3 class="m-form__heading-title">
                                                Delivery Type
                                            </h3>
                                        </div>
                                        <div class="form-group m-form__group">
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    <label class="m-option">
                                                        <span class="m-option__control">
                                                            <span class="m-radio m-radio--state-brand">
                                                                <input type="radio" name="billing_delivery" value="">
                                                                <span></span>
                                                            </span>
                                                        </span>
                                                        <span class="m-option__label">
                                                            <span class="m-option__head">
                                                                <span class="m-option__title">
                                                                    Standart Delevery
                                                                </span>
                                                                <span class="m-option__focus">
                                                                    Free
                                                                </span>
                                                            </span>
                                                            <span class="m-option__body">
                                                                Estimated 14-20 Day Shipping
                            (&nbsp;Duties end taxes may be due
                            upon delivery&nbsp;)
                                                            </span>
                                                        </span>
                                                    </label>
                                                </div>
                                                <div class="col-lg-6">
                                                    <label class="m-option">
                                                        <span class="m-option__control">
                                                            <span class="m-radio m-radio--state-brand">
                                                                <input type="radio" name="billing_delivery" value="">
                                                                <span></span>
                                                            </span>
                                                        </span>
                                                        <span class="m-option__label">
                                                            <span class="m-option__head">
                                                                <span class="m-option__title">
                                                                    Fast Delevery
                                                                </span>
                                                                <span class="m-option__focus">
                                                                    $&nbsp;8.00
                                                                </span>
                                                            </span>
                                                            <span class="m-option__body">
                                                                Estimated 2-5 Day Shipping
                            (&nbsp;Duties end taxes may be due
                            upon delivery&nbsp;)
                                                            </span>
                                                        </span>
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="m-form__help">
                                                <!--must use this helper element to display error message for the options-->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--end: Form Wizard Step 3-->
                                <!--begin: Form Wizard Step 4-->
                                <div class="m-wizard__form-step" id="m_wizard_form_step_4">
                                    <!--begin::Section-->
                                    <div class="m-accordion m-accordion--default" id="m_accordion_1" role="tablist">
                                        <!--begin::Item-->
                                        <div class="m-accordion__item active">
                                            <div class="m-accordion__item-head"  role="tab" id="m_accordion_1_item_1_head" data-toggle="collapse" href="#m_accordion_1_item_1_body" aria-expanded="  false">
                                                <span class="m-accordion__item-icon">
                                                    <i class="fa flaticon-user-ok"></i>
                                                </span>
                                                <span class="m-accordion__item-title">
                                                    1. Client Information
                                                </span>
                                                <span class="m-accordion__item-mode"></span>
                                            </div>
                                            <div class="m-accordion__item-body collapse show" id="m_accordion_1_item_1_body" class=" " role="tabpanel" aria-labelledby="m_accordion_1_item_1_head" data-parent="#m_accordion_1">
                                                <!--begin::Content-->
                                                <div class="tab-content active  m--padding-30">
                                                    <div class="m-form__section m-form__section--first">
                                                        <div class="m-form__heading">
                                                            <h4 class="m-form__heading-title">
                                                                Client Details
                                                            </h4>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Name:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Nick Stone
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Email:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    nick.stone@gmail.com
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Phone
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    +206-78-55034890
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                                    <div class="m-form__section">
                                                        <div class="m-form__heading">
                                                            <h4 class="m-form__heading-title">
                                                                Corresponding Address
                                                                <i data-toggle="m-tooltip" class="m-form__heading-help-icon flaticon-info" title="Some help text goes here"></i>
                                                            </h4>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Address Line 1:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Headquarters 1120 N Street Sacramento 916-654-5266
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Address Line 2:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    P.O. Box 942873 Sacramento, CA 94273-0001
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                City:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Polo Alto
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                State:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    California
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Country:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    USA
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--end::Section-->
                                            </div>
                                        </div>
                                        <!--end::Item-->
                                        <!--begin::Item-->
                                        <div class="m-accordion__item">
                                            <div class="m-accordion__item-head collapsed" role="tab" id="m_accordion_1_item_2_head" data-toggle="collapse" href="#m_accordion_1_item_2_body" aria-expanded="    false">
                                                <span class="m-accordion__item-icon">
                                                    <i class="fa  flaticon-placeholder"></i>
                                                </span>
                                                <span class="m-accordion__item-title">
                                                    2. Account Setup
                                                </span>
                                                <span class="m-accordion__item-mode"></span>
                                            </div>
                                            <div class="m-accordion__item-body collapse" id="m_accordion_1_item_2_body" class=" " role="tabpanel" aria-labelledby="m_accordion_1_item_2_head" data-parent="#m_accordion_1">
                                                <!--begin::Content-->
                                                <div class="tab-content  m--padding-30">
                                                    <div class="m-form__section m-form__section--first">
                                                        <div class="m-form__heading">
                                                            <h4 class="m-form__heading-title">
                                                                Account Details
                                                            </h4>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                URL:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    sinortech.vertoffice.com
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Username:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    sinortech.admin
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Password:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    *********
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                                    <div class="m-form__section">
                                                        <div class="m-form__heading">
                                                            <h4 class="m-form__heading-title">
                                                                Client Settings
                                                            </h4>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                User Group:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Customer
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Communications:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Phone, Email
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--end::Content-->
                                            </div>
                                        </div>
                                        <!--end::Item-->
                                        <!--begin::Item-->
                                        <div class="m-accordion__item">
                                            <div class="m-accordion__item-head collapsed" role="tab" id="m_accordion_1_item_3_head" data-toggle="collapse" href="#m_accordion_1_item_3_body" aria-expanded="    false">
                                                <span class="m-accordion__item-icon">
                                                    <i class="fa  flaticon-placeholder"></i>
                                                </span>
                                                <span class="m-accordion__item-title">
                                                    3. Billing Setup
                                                </span>
                                                <span class="m-accordion__item-mode"></span>
                                            </div>
                                            <div class="m-accordion__item-body collapse" id="m_accordion_1_item_3_body" class=" " role="tabpanel" aria-labelledby="m_accordion_1_item_3_head" data-parent="#m_accordion_1">
                                                <!--begin::Content-->
                                                <div class="tab-content  m--padding-30">
                                                    <div class="m-form__section m-form__section--first">
                                                        <div class="m-form__heading">
                                                            <h4 class="m-form__heading-title">
                                                                Billing Information
                                                            </h4>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Cardholder Name:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Nick Stone
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Card Number:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    *************4589
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Exp Month:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    10
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Exp Year:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    2018
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                CVV:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    ***
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                                    <div class="m-form__section">
                                                        <div class="m-form__heading">
                                                            <h4 class="m-form__heading-title">
                                                                Billing Address
                                                            </h4>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Address Line 1:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Headquarters 1120 N Street Sacramento 916-654-5266
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Address Line 2:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    P.O. Box 942873 Sacramento, CA 94273-0001
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                City:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    Polo Alto
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                State:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    California
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                ZIP:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    37505
                                                                </span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group m-form__group m-form__group--sm row">
                                                            <label class="col-xl-4 col-lg-4 col-form-label">
                                                                Country:
                                                            </label>
                                                            <div class="col-xl-8 col-lg-8">
                                                                <span class="m-form__control-static">
                                                                    USA
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--end::Content-->
                                            </div>
                                        </div>
                                        <!--end::Item-->
                                    </div>
                                    <!--end::Section-->
                                    <!--end::Section-->
                                    <div class="m-separator m-separator--dashed m-separator--lg"></div>
                                    <div class="form-group m-form__group m-form__group--sm row">
                                        <div class="col-xl-12">
                                            <div class="m-checkbox-inline">
                                                <label class="m-checkbox m-checkbox--solid m-checkbox--brand">
                                                    <input type="checkbox" name="accept" value="1">
                                                    Click here to indicate that you have read and agree to the terms presented in the Terms and Conditions agreement
                                                    <span></span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--end: Form Wizard Step 4-->
                            </div>
                            <!--end: Form Body -->
                            <!--begin: Form Actions -->
                            <div class="m-portlet__foot m-portlet__foot--fit m--margin-top-40">
                                <div class="m-form__actions">
                                    <div class="row">
                                        <div class="col-lg-6 m--align-left">
                                            <a href="#" class="btn btn-secondary m-btn m-btn--custom m-btn--icon" data-wizard-action="prev">
                                                <span>
                                                    <i class="la la-arrow-left"></i>
                                                    &nbsp;&nbsp;
                                                    <span>
                                                        Back
                                                    </span>
                                                </span>
                                            </a>
                                        </div>
                                        <div class="col-lg-6 m--align-right">
                                            <a href="#" class="btn btn-primary m-btn m-btn--custom m-btn--icon" data-wizard-action="submit">
                                                <span>
                                                    <i class="la la-check"></i>
                                                    &nbsp;&nbsp;
                                                    <span>
                                                        Submit
                                                    </span>
                                                </span>
                                            </a>
                                            <a href="#" class="btn btn-success m-btn m-btn--custom m-btn--icon" data-wizard-action="next">
                                                <span>
                                                    <span>
                                                        Save & Continue
                                                    </span>
                                                    &nbsp;&nbsp;
                                                    <i class="la la-arrow-right"></i>
                                                </span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--end: Form Actions -->
                        </form>
                    </div>
                    <!--end: Form Wizard Form-->
                </div>
            </div>
        </div>
        <!--end: Form Wizard-->
    </div>
    <!--end: Portlet Body-->
</div>
<!--End::Main Portlet-->
</@layout>