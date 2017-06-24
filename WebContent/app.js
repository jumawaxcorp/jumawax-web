/**
 * this is jumawax app script
 */

 Ext.application({
 	name: 'Jumawax',
 	appFolder: 'app',
 	controllers: ['Login'],
 	autoCreateView: true,
 	launch: function() {
 		Ext.create('Jumawax.view.LoginWindow',{}).show();
 	}
 });