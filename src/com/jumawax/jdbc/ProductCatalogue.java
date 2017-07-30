package com.jumawax.jdbc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jumawax.model.Catalogue;
import com.jumawax.model.Product;

@Component
public interface ProductCatalogue {
	
	public abstract List<Catalogue> listCatalogue();
	public abstract List<Product> listProduct(String storeId,String catalogueId,String pjpId);
	
}
