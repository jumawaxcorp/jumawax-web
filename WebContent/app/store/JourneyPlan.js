/**
 * 
 */
 var endpoint = 'http://192.168.1.100:8080/';

 Ext.define('Jumawax.store.JourneyPlan',{
 	extend: 'Ext.data.Store',
 	requires: 'Jumawax.model.JourneyPlan',
 	model: 'Jumawax.model.JourneyPlan',
 	proxy: {
 		type: 'jsonp',
 		url: endpoint+'jumawax-web/journeyplan/list/jsonp/plan',
 		callbackKey: 'callback'
 	}
 });