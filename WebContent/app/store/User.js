/**
 * 
 */
var endpoint = 'http://192.168.0.100:8080/';

 Ext.define('Jumawax.store.User',{
 	extend: 'Ext.data.Store',
 	model: 'Jumawax.model.User',
 	proxy: {
 		type: 'jsonp',
 		url: endpoint+'jumawax-web/user/login',
 		callbackKey: 'callback'
 	}
 });