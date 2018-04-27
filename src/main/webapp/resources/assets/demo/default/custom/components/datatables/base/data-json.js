//== Class definition

var DatatableJsonRemoteDemo = function () {
	//== Private functions
	// basic demo
	var demo = function () {

		var datatable = $('.m_datatable').mDatatable({
			// datasource definition
			data: {
				type: 'remote',
				source: 'http://localhost:8080/admin/users/json',
				pageSize: 10,
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
				field: "name",
				title: "Name",
				// callback function support for column rendering
				template: function (row) {
					var status = {
						false: {'title': 'Deleted', 'class': 'm-badge--danger'},
						true: {'title': 'Working', 'class': 'm-badge--success'}
					};
					return '<span class="m--font-boldest">' + row.name + '</span><span class="m-badge ' + status[row.status].class + ' m-badge--wide">' + status[row.status].title + '</span>';
				}
			}, {
				field: "email",
				title: "Email",
				// template: function (row) {
				// 	// callback function support for column rendering
				// 	return row.ShipCountry + ' - ' + row.ShipCity;
				// }
			}, {
				field: "plate",
				title: "Plate Number"
			}, {
				field: "mobile",
				title: "Mobile",
				responsive: {visible: 'lg'}
			}, {
				field: "order_counts",
				title: "Parked",
				responsive: {visible: 'lg'}
			}, {
				field: "created_at",
				title: "Sign Up",
				type: "date",
				format: "MM/DD/YYYY",
				// callback function support for column rendering
				template: function (row) {
					var d = new Date(row.created_at);
					return  d.getFullYear()+ '/' + (d.getMonth()+1) + '/' + d.getDate();
				}
			}, {
				field: "type",
				title: "Type",
				// callback function support for column rendering
				template: function (row) {
					var status = {
						1: {'title': 'User', 'state': 'danger'},
						2: {'title': 'Operator', 'state': 'primary'},
						5: {'title': 'Admin', 'state': 'accent'}
					};
					return '<span class="m-badge m-badge--' + status[row.type].state + ' m-badge--dot"></span>&nbsp;<span class="m--font-bold m--font-' + status[row.type].state + '">' + status[row.type].title + '</span>';
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
	DatatableJsonRemoteDemo.init();
	$('#m_form_status, #m_form_type').selectpicker();
});