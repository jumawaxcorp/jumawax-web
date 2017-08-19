/**
 * Logout controller script
 */
 Ext.define('Jumawax.controller.Logout',{
	extend: 'Ext.app.Controller',
	views: ['Viewport'],
	stores: ['User','JourneyPlan'],
	init: function(application) {
		this.control({
			"toolbar button#ToolbarLogout":
			{
				click: this.onButtonClickSubmit
			}
		});
	},

	onButtonClickSubmit: function(button,e,options) {
			alert('test');
			Ext.create('Jumawax.view.LoginWindows',{}).show();

	}
});