/**
 * 
 */
 

Ext.define('Jumawax.view.MenuContent',{
 	extend: 'Ext.tree.Panel',
 	alias: 'widget.menucontent',
 	xtype: 'menucontent',
 	store: 'JourneyPlan',
 	rootVisible: false,
 	width: 300,
    height: 200,
    margin: 10,

 	initComponent: function() {
 		var store = Ext.getStore('MenuContent');
 		console.log('=========='+store);
 		this.callParent();
 	}

 });
 
 