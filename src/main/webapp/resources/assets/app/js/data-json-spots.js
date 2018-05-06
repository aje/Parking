//== Class definition

var DatatableJsonRemoteDemo = function () {
    //== Private functions
    // basic demo
    var demo = function () {
        var segment_str = window.location.pathname; // return segment1/segment2/segment3/segment4
        var segment_array = segment_str.split( '/' );
        var last_segment = segment_array[segment_array.length - 1];
        var  source = (last_segment == "all")?"json":last_segment;
        console.log(source);
        var datatable = $('.m_datatable').mDatatable({
            data: {
                type: 'remote',
                source: 'http://localhost:8080/admin/spots/'+source,
                pageSize: 10
            },

            // layout definition
            layout: {
                theme: 'default', // datatable theme
                class: '', // custom wrapper class
                scroll: false, // enable/disable datatable scroll both horizontal and vertical when needed.
                footer: false // display/hide footer
            },

            // column sorting
            sortable: true,

            pagination: true,

            search: {
                input: $('#generalSearch')
            },

            // columns definition
            columns: [{
                field: "id",
                title: "#",
                width: 50,
                sortable: false,
                selector: false,
                textAlign: 'center'
            }, {
                field: "loraSerial",
                title: "Lora Serial Number",
                // callback function support for column rendering
                // template: function (row) {
                //     var status = {
                //         0: {'title': 'Deleted', 'class': 'm-badge--danger'},
                //         1: {'title': 'Working', 'class': 'm-badge--success'}
                //     };
                //     return '<span class="m--font-boldest">' + row.name + '</span><br><span class="m-badge ' + status[row.status].class + ' m-badge--wide">' + status[row.status].title + '</span>';
                // }
            }, {
                field: "status",
                title: "Status",
                template: function (row) {
                    var status = {
                        0: {'title': 'Deleted', 'class': 'm-badge--danger'},
                        1: {'title': 'Working', 'class': 'm-badge--success'}
                    };
                    return '<span class="m-badge ' + status[row.status].class + ' m-badge--wide">' + status[row.status].title + '</span>';
                }
            }, {
                field: "usedCount",
                title: "Used Count",
            }, {
                field: "createdAt",
                title: "Sign Up",
                type: "date",
                format: "MM/DD/YYYY",
                // callback function support for column rendering
                template: function (row) {
                    var d = new Date(row.createdAt);
                    return  d.getFullYear()+ '/' + (d.getMonth()+1) + '/' + d.getDate();
                }
            }, {
                field: "lot.name",
                title: "Parking Lot"
            }, {
                field: "lot.id",
                title: "Address",
                // callback function support for column rendering
                template: function (row) {
                    return '<span class="">' + row.lot.name + '</span>, <span class="">' + row.lot.addressLot.city + '</span>';
                }
            }, {
                field: "Actions",
                width: 110,
                title: "Actions",
                sortable: false,
                overflow: 'visible',
                template: function (row, index, datatable) {
                    var dropup = (datatable.getPageSize() - index) <= 4 ? 'dropup' : '';
                    return '\
						<div class="dropdown ' + dropup + '">\
							<a href="#" class="btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" data-toggle="dropdown">\
                                <i class="la la-ellipsis-h"></i>\
                            </a>\
						  	<div class="dropdown-menu dropdown-menu-right">\
						    	<a class="dropdown-item" href="#"><i class="la la-edit"></i> Edit Details</a>\
						    	<a class="dropdown-item" href="#"><i class="la la-leaf"></i> Update Status</a>\
						    	<a class="dropdown-item" href="#"><i class="la la-print"></i> Generate Report</a>\
						  	</div>\
						</div>\
						<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" title="Download">\
							<i class="la la-download"></i>\
						</a>\
						<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Edit settings">\
							<i class="la la-cog"></i>\
						</a>\
					';
                }
            }]
        });

        var query = datatable.getDataSourceQuery();

        $('#m_form_status').on('change', function () {
            datatable.search($(this).val(), 'status');
        }).val(typeof query.status !== 'undefined' ? query.status : '');

        $('#m_form_type').on('change', function () {
            datatable.search($(this).val(), 'type');
        }).val(typeof query.type !== 'undefined' ? query.type : '');

        $('#m_form_status, #m_form_type').selectpicker();

        $('#refresh-datatable').on('click', function(event) {
            event.preventDefault();
            datatable.ajax.reload();
        });

    };

    return {
        // public functions
        init: function () {
            demo();
        }
    };
}();

jQuery(document).ready(function () {
    var token = $('meta[name="_csrf"]').attr('content');
    var header = $('meta[name="_csrf_header"]').attr('content');
    if(token.length > 0 && header.length > 0) {
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header,token);
        })
    }
    DatatableJsonRemoteDemo.init();
    $('#m_form_status, #m_form_type').selectpicker();
});