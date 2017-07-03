/**
 * Main Viewport class
 */

 Ext.define('Jumawax.view.MainPort',{
 	extend: 'Ext.container.Viewport',
 	requires: [
 		'Ext.layout.container.Border'
 	],
 	layout: 'border',
 	componentLayout: '',
 	items: [
 		{
 			region: 'center',
 			layout: 'fit'
 		}
 	]
 });