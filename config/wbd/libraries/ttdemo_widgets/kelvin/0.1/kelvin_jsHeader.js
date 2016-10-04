
var Kelvin = function() {
	return {
		myVariable: null,

		init: function() {
			alert("Kelvin.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".Kelvin .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("Kelvin.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(Kelvin.init()); // Run after page loads