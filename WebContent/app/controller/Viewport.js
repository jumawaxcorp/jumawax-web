/**
 * 
 */

 Ext.define('Jumawax.controller.Viewport',{
 	extend: 'Ext.app.Controller',
 	views: ['Viewport','LoginWindow'],
 	stores: ['User'],
 	init: function() {
 		this.control({
 			'viewport': {
 				render: this.onViewportRendered
 			}
 		});
 	},

 	onViewportRendered: function(p) {
 		console.log(p);
 		var loginContainer = p.getComponent(0);
 		var store = Ext.getStore("User");
 		store.load({
 			scope:this,
 			callback: function(records,operation,success) {
 				if(success) {
 					if(records[0].data.role=="") {
 						var cont = new Ext.container.Container({
 							region: 'center'
 						});
 						var logWindow = new Jumawax.view.LoginWindow({
 							renderTo: cont.body
 						}).show();
 						loginContainer.add(cont);
 						//loginContainer.getChildByElement("loginwindow").show();
 						loginContainer.doLayout();
 						console.log(loginContainer);
 					}
 				}
 			}
 		});
 	}

 });