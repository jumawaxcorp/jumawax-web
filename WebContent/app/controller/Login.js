/**
 * Login controller script
 */

Ext.define('Jumawax.controller.Login',{
	extend: 'Ext.app.Controller',
	views: ['LoginWindow'],
	stores: ['User','JourneyPlan'],
	init: function(application) {
		this.control({
			"loginwindow button#login":
			{
				click: this.onButtonClickSubmit
			}
		});
	},
	onButtonClickSubmit: function(button,e,options) {
		var formField = button.up('loginwindow').down('form');
		var user = formField.down('textfield[name=userName]').getValue();
		var passwd = formField.down('textfield[name=password]').getValue();

		var store = Ext.getStore("User");
		store.getProxy().extraParams = {
			username: user,
			password: passwd
		};

		var el = Ext.get("loginwindow");
		el.mask("Authenticating... Please wait...", 'loading');
		store.load({
			scope: this,
			callback: function(records,operation,success) {
				if(success) {
					el.unmask();
					if(records[0].data.msg=="Success") {
						var pjpstore = Ext.getStore("JourneyPlan");
						pjpstore.getProxy().extraParams = {
							username: user
						}
						pjpstore.load();
						Ext.WindowManager.each(function(cmp) {
							cmp.destroy();
						});
						Ext.create('Jumawax.view.Viewport',{}).show();
					}
					else {
						alert(records[0].data.msg);
					}
				}
				else {
					console.log("Error Login Due to Network Issue")
				}
			}
		});
	}
});