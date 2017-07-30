package com.jumawax.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jumawax.model.Catalogue;
import com.jumawax.model.Product;

@Repository
public class ProductCatalogueImpl implements ProductCatalogue {

	@Autowired
	@Qualifier("ds")
	DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	} 
	
	@Override
	public List<Catalogue> listCatalogue() {
		// TODO Auto-generated method stub
		List<Catalogue> listCat = new ArrayList<>();
		String query = "SELECT * FROM productcatalogue";
		Connection con = null;
		
		try {
			con = ds.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Catalogue cat = new Catalogue();
				cat.setCatalogueId(rs.getString("catalogue_id"));
				cat.setCatalogueName(rs.getString("catalogue_name"));
				listCat.add(cat);
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCat;
	}

	@Override
	public List<Product> listProduct(String storeId,String catalogueId,String pjpId) {
		// TODO Auto-generated method stub
		List<Product> listProd = new ArrayList<>();
		String query = "SELECT * FROM pvskustore WHERE store_id = '"+storeId+"' AND catalogue_id = '"+catalogueId+"' AND pjp_id = '"+pjpId+"'";
		Connection con = null;
		try {
			con = ds.getConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				Product prod = new Product();
				prod.setCatalogueId(rs.getString("catalogue_id"));
				prod.setSkuId(rs.getString("sku_id"));
				prod.setSkuName(rs.getString("sku_name"));
				prod.setStoreId(rs.getString("store_id"));
				listProd.add(prod);
			}
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listProd;
	}

}
