/**
 * 
 */
 Ext.define('Jumawax.view.MenuContent',{
 	extend: 'Ext.grid.Panel',
 	alias: 'widget.menucontent',
 	xtype: 'menucontent',
 	store: 'JourneyPlan',
 	hideHeaders: true,

 	initComponent: function() {
 		this.columns = [{
 			dataIndex: 'planId',
 			flex: 1
 		}];

 		this.callParent();
 	}

 });