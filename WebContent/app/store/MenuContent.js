/**
 * 
 */
Ext.define('Jumawax.store.MenuContent',{
	extend: 'Ext.data.TreeStore',
	fields: ['name','surename'],
	data: [{
		'name': 'test',
		'surename': 'tis'
	}]
});
