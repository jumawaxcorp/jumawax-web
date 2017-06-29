package com.jumawax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jumawax.jdbc.ProductCatalogue;
import com.jumawax.model.Catalogue;
import com.jumawax.model.Product;
import org.springframework.web.context.request.WebRequest;
@Controller
@RequestMapping({"product"})
public class ProductCatalogueController {
	
	@Autowired
	ProductCatalogue prodCat;
	
	@RequestMapping(value={"list/jsonp/product/catalogue"}, produces={"application/json"})
	@ResponseBody public List<Catalogue> getProductCatalogue() {
		List<Catalogue> listCat = new ArrayList<>();
		listCat = prodCat.listCatalogue();
		return listCat;
	}
	
	@RequestMapping(value={"list/jsonp/product/sku"}, produces={"application/json"})
	@ResponseBody public List<Product> getProduct(WebRequest request) {
		List<Product> listProd = new ArrayList<>();
		listProd = prodCat.listProduct(request.getParameter("storeId"),request.getParameter("catalogueId"));
		return listProd;
	}
}
