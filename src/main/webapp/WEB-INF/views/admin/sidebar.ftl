<#assign url =  springMacroRequestContext.getRequestUri() />
<#assign sidebarnav = [
    {
        "title" : "Dashboard",
        "icon" : "flaticon-line-graph",
        "link" : "/admin/dashboard"
    },{
        "title" : "Sales",
        "icon" : "flaticon-cart",
        "link" : "/admin/sales",
        "submenu" : [ {
                "title" : "Sales Dashboard",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "/admin/users/dashboard"
            },{
                "title" : "All Sales",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "/admin/users/all"
            }, {
                "title" : "Reserves",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "#"
            }, {
                "title" : "Anomalies",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "#"
            }
        ]
    },{
        "title" : "Users",
        "icon" : "flaticon-users",
        "link" : "/admin/users",
        "submenu" : [ {
                "title" : "User Dashboard",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "/admin/users/dashboard"
            },{
                "title" : "All users",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "/admin/users/all"
            }, {
                "title" : "Operators",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "#"
            }
        ]
    },{
        "title" : "Parkings",
        "icon" : "flaticon-truck",
        "link" : "/admin/parkings",
        "submenu" : [ {
                "title" : "Parkings Dashboard",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "#"
            }, {
                "title" : "All Parking Lots",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "/admin/lots/all"
            }, {
                "title" : "Add Parking Lot",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "/admin/lots/add"
            }, {
                "title" : "Map",
                "icon" : "m-menu__link-bullet--dot",
                "link" : "#"
            }
        ]
    }
]>

<button class="m-aside-left-close m-aside-left-close--skin-dark" id="m_aside_left_close_btn">
    <i class="la la-close"></i>
</button>
<div id="m_aside_left" class="m-grid__item  m-aside-left  m-aside-left--skin-dark ">
    <!-- BEGIN: Aside Menu -->
    <div id="m_ver_menu"
         class="m-aside-menu  m-aside-menu--skin-dark m-aside-menu--submenu-skin-dark m-aside-menu--dropdown "
         data-menu-vertical="true" data-menu-dropdown="true" data-menu-scrollable="true"
         data-menu-dropdown-timeout="500">
        <ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
            <#list sidebarnav as nav>
                <li class="m-menu__item <#if nav.submenu??>m-menu__item--submenu</#if> <#if url?contains(nav.link)> m-menu__item--active</#if> m-menu__item--submenu  ${nav.class!}"  <#if url?contains(nav.link)> aria-haspopup="true"  </#if>
                    <#if nav.submenu??> data-menu-submenu-toggle="hover" </#if> >
                    <a href="${nav.link!}" class="m-menu__link  <#if nav.submenu??> m-menu__toggle </#if>">
                        <span class="m-menu__item-here"></span>
                        <i class="m-menu__link-icon ${nav.icon!}"></i>
                        <span class="m-menu__link-text">
                            ${nav.title!}
                    </span>
                        <i class="m-menu__ver-arrow la la-angle-right"></i>
                    </a>
                    <#if nav.submenu??>
                    <#list nav.submenu>
                    <div class="m-menu__submenu ">
                        <span class="m-menu__arrow"></span>
                        <ul class="m-menu__subnav">
                            <li class="m-menu__item  m-menu__item--parent" aria-haspopup="true">
                            <span class="m-menu__link">
                                <span class="m-menu__item-here"></span>
                                <span class="m-menu__link-text">
                                    Layouts
                                </span>
                            </span>
                            </li>
                            <#items as sub>
                            <li class="m-menu__item " aria-haspopup="true">
                                <a href="${sub.link!}" class="m-menu__link ">
                                    <i class="m-menu__link-bullet ${sub.icon!}">
                                        <span></span>
                                    </i>
                                    <span class="m-menu__link-text">
                                    ${sub.title!}
                                </span>
                                </a>
                            </li>
                            </#items>
                        </ul>
                    </div>
                    </#list>
                    </#if>
                </li>
            </#list>
            <li class="m-menu__item  m-menu__item--submenu" aria-haspopup="true"
                data-menu-submenu-toggle="hover">
                <a href="#" class="m-menu__link m-menu__toggle">
                    <span class="m-menu__item-here"></span>
                    <i class="m-menu__link-icon flaticon-layers"></i>
                    <span class="m-menu__link-title">
                        <span class="m-menu__link-wrap">
                            <span class="m-menu__link-text">
                                Reports
                            </span>
                            <span class="m-menu__link-badge">
                                <span class="m-badge m-badge--danger">
                                    2
                                </span>
                            </span>
                        </span>
                    </span>
                    <i class="m-menu__ver-arrow la la-angle-right"></i>
                </a>
                <div class="m-menu__submenu ">
                    <span class="m-menu__arrow"></span>
                    <ul class="m-menu__subnav">
                        <li class="m-menu__item  m-menu__item--parent" aria-haspopup="true">
                            <span class="m-menu__link">
                                <span class="m-menu__item-here"></span>
                                <span class="m-menu__link-title">
                                    <span class="m-menu__link-wrap">
                                        <span class="m-menu__link-text">
                                            Reports
                                        </span>
                                        <span class="m-menu__link-badge">
                                            <span class="m-badge m-badge--danger">
                                                2
                                            </span>
                                        </span>
                                    </span>
                                </span>
                            </span>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-icon flaticon-pie-chart"></i>
                                <span class="m-menu__link-text">
                                    Finance Reports
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-icon flaticon-line-graph"></i>
                                <span class="m-menu__link-text">
                                    Accouning Audit
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-icon flaticon-statistics"></i>
                                <span class="m-menu__link-text">
                                    Investments
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-icon flaticon-coins"></i>
                                <span class="m-menu__link-text">
                                    Sales
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="m-menu__item  m-menu__item--submenu" aria-haspopup="true"
                data-menu-submenu-toggle="hover" data-redirect="true">
                <a href="#" class="m-menu__link m-menu__toggle">
                    <span class="m-menu__item-here"></span>
                    <i class="m-menu__link-icon flaticon-lifebuoy"></i>
                    <span class="m-menu__link-text">
                        Support
                    </span>
                    <i class="m-menu__ver-arrow la la-angle-right"></i>
                </a>
                <div class="m-menu__submenu ">
                    <span class="m-menu__arrow"></span>
                    <ul class="m-menu__subnav">
                        <li class="m-menu__item  m-menu__item--parent" aria-haspopup="true"
                            data-redirect="true">
                            <span class="m-menu__link">
                                <span class="m-menu__item-here"></span>
                                <span class="m-menu__link-text">
                                    Support
                                </span>
                            </span>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Reports
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item  m-menu__item--submenu" aria-haspopup="true"
                            data-menu-submenu-toggle="hover" data-redirect="true">
                            <a href="#" class="m-menu__link m-menu__toggle">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Cases
                                </span>
                                <i class="m-menu__ver-arrow la la-angle-right"></i>
                            </a>
                            <div class="m-menu__submenu ">
                                <span class="m-menu__arrow"></span>
                                <ul class="m-menu__subnav">
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-computer"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Pending
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--warning m-badge--wide">
                                                            10
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-signs-2"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Urgent
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--danger m-badge--wide">
                                                            6
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-clipboard"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Done
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--success m-badge--wide">
                                                            2
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-multimedia-2"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Archive
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--info m-badge--wide">
                                                            245
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Clients
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Audit
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="m-menu__item  m-menu__item--submenu" aria-haspopup="true"
                data-menu-submenu-toggle="hover" data-redirect="true">
                <a href="#" class="m-menu__link m-menu__toggle">
                    <span class="m-menu__item-here"></span>
                    <i class="m-menu__link-icon flaticon-share"></i>
                    <span class="m-menu__link-text">
                        Feedbacks
                    </span>
                    <i class="m-menu__ver-arrow la la-angle-right"></i>
                </a>
                <div class="m-menu__submenu ">
                    <span class="m-menu__arrow"></span>
                    <ul class="m-menu__subnav">
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-title">
                                    <span class="m-menu__link-wrap">
                                        <span class="m-menu__link-text">
                                            Product Feedbacks
                                        </span>
                                        <span class="m-menu__link-badge">
                                            <span class="m-badge m-badge--accent">
                                                3
                                            </span>
                                        </span>
                                    </span>
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Customer Reviews
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Product Ratings
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Customer Support
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="m-menu__item  m-menu__item--submenu m-menu__item--bottom-2" aria-haspopup="true"
                data-menu-submenu-toggle="hover">
                <a href="#" class="m-menu__link m-menu__toggle">
                    <i class="m-menu__link-icon flaticon-settings"></i>
                    <span class="m-menu__link-text">
                        Settings
                    </span>
                    <i class="m-menu__ver-arrow la la-angle-right"></i>
                </a>
                <div class="m-menu__submenu m-menu__submenu--up">
                    <span class="m-menu__arrow"></span>
                    <ul class="m-menu__subnav">
                        <li class="m-menu__item  m-menu__item--parent m-menu__item--bottom-2"
                            aria-haspopup="true">
                            <span class="m-menu__link">
                                <span class="m-menu__link-text">
                                    Settings
                                </span>
                            </span>
                        </li>
                        <li class="m-menu__item  m-menu__item--submenu" aria-haspopup="true"
                            data-menu-submenu-toggle="hover" data-redirect="true">
                            <a href="inner.html" class="m-menu__link m-menu__toggle">
                                <i class="m-menu__link-bullet m-menu__link-bullet--line">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Profile
                                </span>
                                <i class="m-menu__ver-arrow la la-angle-right"></i>
                            </a>
                            <div class="m-menu__submenu ">
                                <span class="m-menu__arrow"></span>
                                <ul class="m-menu__subnav">
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-computer"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Pending
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--warning">
                                                            10
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-signs-2"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Urgent
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--danger">
                                                            6
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-clipboard"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Done
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--success">
                                                            2
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                    <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                                        <a href="inner.html" class="m-menu__link ">
                                            <i class="m-menu__link-icon flaticon-multimedia-2"></i>
                                            <span class="m-menu__link-title">
                                                <span class="m-menu__link-wrap">
                                                    <span class="m-menu__link-text">
                                                        Archive
                                                    </span>
                                                    <span class="m-menu__link-badge">
                                                        <span class="m-badge m-badge--info m-badge--wide">
                                                            245
                                                        </span>
                                                    </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--line">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Accounts
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--line">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Help
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--line">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Notifications
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="m-menu__item  m-menu__item--submenu m-menu__item--bottom-1" aria-haspopup="true"
                data-menu-submenu-toggle="hover">
                <a href="#" class="m-menu__link m-menu__toggle">
                    <i class="m-menu__link-icon flaticon-info"></i>
                    <span class="m-menu__link-text">
                        Help
                    </span>
                    <i class="m-menu__ver-arrow la la-angle-right"></i>
                </a>
                <div class="m-menu__submenu m-menu__submenu--up">
                    <span class="m-menu__arrow"></span>
                    <ul class="m-menu__subnav">
                        <li class="m-menu__item  m-menu__item--parent m-menu__item--bottom-1"
                            aria-haspopup="true">
                            <span class="m-menu__link">
                                <span class="m-menu__link-text">
                                    Help
                                </span>
                            </span>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Support
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Blog
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Documentation
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Pricing
                                </span>
                            </a>
                        </li>
                        <li class="m-menu__item " aria-haspopup="true" data-redirect="true">
                            <a href="inner.html" class="m-menu__link ">
                                <i class="m-menu__link-bullet m-menu__link-bullet--dot">
                                    <span></span>
                                </i>
                                <span class="m-menu__link-text">
                                    Terms
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
    <!-- END: Aside Menu -->
</div>