/**
 *Jumawax web login window 
 */

 Ext.define('Jumawax.view.LoginWindow',{
 	extend: 'Ext.window.Window',
 	alias: 'widget.loginwindow',
 	id: 'loginwindow',
 	title: 'Enter Username & Password',
 	width: 400,
 	autoHeight: true,
	closable: false,
	resizable: false,
	draggable: true,
	layout: 'fit',
	iconCls: 'icon-key',
	modal: true,
	initComponent: function() {
		Ext.apply(this,{
			items: [{
				xtype: 'form',
				plain: true,
				frame: true,
				border: 0,
				bodyPadding: 5,
				items: [{
					itemId: 'userName',
					xtype: 'textfield',
					fieldLabel: 'Username',
					name: 'userName',
					allowBlank: false,
					anchor: '100%',
					selectOnFocus: true
				},
				{
					itemId: 'password',
					xtype: 'textfield',
					fieldLabel: 'Password',
					name: 'password',
					allowBlank: false,
					inputType: 'password',
					anchor: '100%',
					selectOnFocus: true
				}]
			}]
		});
		this.callParent(arguments);
	},
	buttons: [{
		itemId: 'login',
		text: 'Login',
		type: 'submit',
		action: 'login',
		formBind: true,
		iconCls: 'icon-login'
	}]
 });