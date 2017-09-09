/**
 * Main Viewport class
 */

 Ext.define('Jumawax.view.Viewport',{
 	extend: 'Ext.container.Viewport',
 	alias: 'widget.viewport',
 	layout: 'fit',
 	stores: ['User'],
 	requires: ['Jumawax.view.MenuContent'],
 	// requires: [
 	// 	'Ext.layout.container.Border'
 	// ],
 	// layout: 'border',
 	// componentLayout: '',
 	initComponent: function() {
 		var store = Ext.getStore("User");
 		var user = store.first();
 		console.log(user);
 		this.items = {
 			dockedItems: [{
 				dock: 'top',
 				xtype: 'toolbar',
 				height: 50,
 				items: [{
 					iconCls: 'icon-webinfo'
 				},{
 					flex: 1	
 				},{
 					xtype: 'component',
 					html: 'Jumawax<br>Report & Management<br>welcome '+user.data.agentname
 				}]
 			}],
 			layout: {
 				type: 'hbox',
 				align: 'stretch'
 			},
 			items: [{
 				width: 250,
 				xtype: 'treepanel',
 				title: 'Main Menu',
 				bodyPadding: 5,
 				id: 'west-region',
 				layout: {
 					type: 'vbox',
 					align: 'stretch'
 				},
 				items: [{
 					xtype: 'menucontent',
 					flex: 1
 				}]
 			}]
 		};

 		this.callParent();
 	} 
 });