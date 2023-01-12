package com.java.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.java.mvc.model.Store;

public class StoreDaoImpl {
	
	private JdbcTemplate jdbcTemplate;
	
	public StoreDaoImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	//Add
	
	public String addStore(Store store) {
		
		String cmd = "Insert into Store(storeId,productName,quantity,price) "
				+ "values(?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {store.getStoreId(), store.getProductName(), store.getQuantity(), store.getPrice()} );
		return "Record Inserted...";
	}
	
	//Show 
	
	public List<Store> showStore() {
		String cmd = "select * from store";
		List<Store> liststore = jdbcTemplate.query(cmd, new RowMapper<Store>() {

		
			 
	        @Override
	        public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Store store = new Store();
	            store.setStoreId(rs.getInt("storeId"));
	            store.setProductName(rs.getString("productName"));
	            store.setQuantity(rs.getInt("quantity"));
	            store.setPrice(rs.getInt("price"));
	 
	            return store;
	        }
	 
	    });
	 
	    return liststore;

	}
	
	public void deleteStore(int storeId) {
		String cmd = "Delete From store where storeId=?";
		jdbcTemplate.update(cmd, new Object[] {storeId});
	}
	
	public Store searchStore(int storeId) {
		String sql = "select * from store where storeId=?";
	    return jdbcTemplate.query(sql,new Object[] {storeId}, new ResultSetExtractor<Store>() {
	        public Store extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	 Store store = new Store();
	 	            store.setStoreId(rs.getInt("storeId"));
	 	            store.setProductName(rs.getString("productName"));
	 	            store.setQuantity(rs.getInt("quantity"));
	 	            store.setPrice(rs.getInt("price"));
		 
		            return store;
		            
	            }
	            return null;
	        }
	    });
}
	
	public void updateStore(Store store) {
		String cmd = "Update store set productName=?, quantity=?, price=? "
				+ " WHERE storeId=?";
		 jdbcTemplate.update(cmd, store.getProductName(),
				store.getQuantity(),
		        store.getPrice(),
		        store.getStoreId());
	}
}
