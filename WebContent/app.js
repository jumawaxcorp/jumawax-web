/**
 * this is jumawax app script
 */

 Ext.application({
 	name: 'Jumawax',
 	appFolder: '../app',
 	controllers: [],
 	autoCreateView: true,
 	launch: function() {
 		Ext.create('Ext.container.Viewport',{
 			layout: 'fit',
 			items: [
 				{
 					title: 'Welcome to Jumawax Management and Report Web'
 				}
 			]
 		});
 	}
 });