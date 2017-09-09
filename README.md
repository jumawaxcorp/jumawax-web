"# jumawax-web" 
"Jumawax project started here" 
--List Service--
Root=>http://localhost:8080/jumawax-web
Login=>/user/login?callback=functionCallback&username={usr}&password={pass}
	return=>role,agentname,token,username
ListPJP=>/journeyplan/list/jsonp/plan?callback=functionCallback&username={usr}
	return=>planId,submitDate,agent,owner,status
ListStore=>/journeyplan/list/jsonp/plan/store?callback=functionCallback&planid={planId}&latitude={latitude}&longitude={longitude}
	return=>planid,storeCode,storeName,address,name,phonenumber,email,latitude,longitude,isReached
ListCatalogue=>/product/list/jsonp/product/catalogue?callback=functionCallback
	return=>catalogueId,catalogueName
ListSKU=>/product/list/jsonp/product/sku?callback=functionCallback&storeId={storecode}&catalogueId={idcatalog}
	return=>skuId,catalogueId,skuName,storeId
StoreImage=>/file/upload
			//List Question OOS,OSA(common,patial,promo)//

Apakah item tersedia? Ya Tidak
jika tidak, apakah pricetag ada di rak?

Apakah item memiliki promo? Ya Tidak 

Apakah item tersedia di rak lain?


/* UPDATE skubyplan SET status = ''; */

//*
  *
  *
  *
  *	JouneyPlan --> Store --> Category --> SKU --> Submit
					 |			|			|		|
					 |			|			|		|
					 |			|			|_______|		
					 |			|				|
					 |			|________________|				
					 |					|	
					_|___________________|
			