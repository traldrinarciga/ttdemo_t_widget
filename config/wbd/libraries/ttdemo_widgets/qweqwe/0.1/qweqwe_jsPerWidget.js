
var Qweqwe_[[widgetId]] = function() {
	return {
		myVariable: null,

		init: function() {
			alert("Qweqwe_[[widgetId]].init");
			
//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".Qweqwe .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("Qweqwe.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(Qweqwe_[[widgetId]].init()); // Run after page loads