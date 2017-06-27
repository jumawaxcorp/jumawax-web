/**
 * Login controller script
 */

Ext.define('Jumawax.controller.Login',{
	extend: 'Ext.app.Controller',
	views: ['LoginWindow'],
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
		var store = Ext.create('Ext.data.Store',{
			fields: ['role','agentname','token','username'],
			proxy: {
				type: 'jsonp',
				url: 'http://192.168.1.100:8080/jumawax-web/user/login',
				callbackKey: 'callback',
				extraParams: {
					username: user,
					password: passwd
				}
			}
		});
		store.load();
		var user = store.first();
		console.log("Agent Name : "+user);
	}
});