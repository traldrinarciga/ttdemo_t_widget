var Placeholder = function() {
	return {
		init : function() {
			$.ajax({
				type: "POST",
				async : false,
				url : location.href,
				op : "op=cloudmall_widgets.placeholder.placeholder&subop=placeholder",
				data: {
					userId: userId,
				},
				success: function(data) {
					if(data && data.success){
						
					} else {
						
					}
				}
			});
		},
	};
}();
jQuery(Placeholder.init());
