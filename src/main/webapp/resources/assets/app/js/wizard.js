//== Class definition
var WizardDemo = function () {
    //== Base elements
    var wizardEl = $('#m_wizard');
    var formEl = $('#m_form');
    var validator;
    var wizard;
    var isformSubmitted = false;
    
    //== Private functions
    var initWizard = function () {
        //== Initialize form wizard
        wizard = wizardEl.mWizard({
            startStep: 1
        });

        //== Validation before going to next page
        wizard.on('beforeNext', function(wizard) {
            if (validator.form() !== true) {
                return false;  // don't go to the next step
            }
            if(wizard.currentStep == 1 && !isformSubmitted) {
                formEl.ajaxSubmit({
                    url:"/admin/lots/add",
                    success: function(response, status, xhr, $form){
                        if(response.status) {
                            //mApp.unblock(formEl);
                            swal({
                                "title": "",
                                "text": response.msg,
                                "type": "success",
                                "confirmButtonClass": "btn btn-secondary m-btn m-btn--wide"
                            });
                            isformSubmitted = true;
                        } else {
                            swal({
                                "title": "",
                                "text": response.msg,
                                "type": "error",
                                "confirmButtonClass": "btn btn-secondary m-btn m-btn--wide"
                            });
                            return false;
                        }
                    }
                });
            }

        })

        //== Change event
        wizard.on('change', function(wizard) {
            mApp.scrollTop();
        });
    }

    var initValidation = function() {
        validator = formEl.validate({
            //== Validate only visible fields
            ignore: ":hidden",

            //== Validation rules
            rules: {
                //=== Client Information(step 1)
                //== Client details
                name: {
                    required: true 
                },

                city: {
                    required: true 
                },
                province: {
                    required: true 
                },
                city: {
                    required: true 
                }

            },
            
            //== Display error  
            invalidHandler: function(event, validator) {     
                mApp.scrollTop();

                swal({
                    "title": "", 
                    "text": "There are some errors in your submission. Please correct them.", 
                    "type": "error",
                    "confirmButtonClass": "btn btn-secondary m-btn m-btn--wide"
                });
            },

            //== Submit valid form
            submitHandler: function (form) {
                
            }
        });   
    }

    var initSubmit = function() {
        var btn = formEl.find('[data-wizard-action="submit"]');

        btn.on('click', function(e) {
            e.preventDefault();

            if (validator.form()) {
                //== See: src\js\framework\base\app.js
                mApp.progress(btn);
                //mApp.block(formEl); 

                //== See: http://malsup.com/jquery/form/#ajaxSubmit
                // formEl.ajaxSubmit({
                //     url:"/admin/lots/add",
                //     success: function(response, status, xhr, $form){
                //         mApp.unprogress(btn);
                //         if(response.status) {
                //             //mApp.unblock(formEl);
                //             swal({
                //                 "title": "",
                //                 "text": response.msg,
                //                 "type": "success",
                //                 "confirmButtonClass": "btn btn-secondary m-btn m-btn--wide"
                //             });
                //         } else {
                //             swal({
                //                 "title": "",
                //                 "text": response.msg,
                //                 "type": "error",
                //                 "confirmButtonClass": "btn btn-secondary m-btn m-btn--wide"
                //             });
                //         }
                //     }
                // });
            }
        });
    }

    return {
        // public functions
        init: function() {
            wizardEl = $('#m_wizard');
            formEl = $('#m_form');

            initWizard(); 
            initValidation();
            initSubmit();
        }
    };
}();

jQuery(document).ready(function() {
    var token = $('meta[name="_csrf"]').attr('content');
    var header = $('meta[name="_csrf_header"]').attr('content');
    if(token.length > 0 && header.length > 0) {
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header,token);
        })
    }
    WizardDemo.init();
});