package com.example.demo.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.AbstractDocument.BranchElement;

import com.example.demo.entity.Fee;
import com.example.demo.utils.ConnectionFactory;

public class FeeRepository {

	Connection con =null;
	
	private String insertsql="insert into tieto_fee values(?,?,?,?)";
	private  String findAllSql="select * from tieto_fee";
	private String findByIdSql="select * from tieto_fee where id =? ";
	private String removeByIdSql="delete from tieto_fee where id = ?";
	private String updateByBranchSql="update  tieto_fee set amount=? where branch=?";
	
	public FeeRepository() {
		super();
		// TODO Auto-generated constructor stub
	
		this.con=ConnectionFactory.getMyOracleConnection();
	}
	
	//post//insert
	public int add(Fee entity)  throws SQLException {
		int rowAdded = 0;
		try(PreparedStatement pstmt = con.prepareStatement(insertsql)) {
			pstmt.setInt(1, entity.getId());
			pstmt.setString(2, entity.getBranch());
			pstmt.setString(3, entity.getYear());
			pstmt.setDouble(4, entity.getAmount());
			
			rowAdded=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
			//e.printStackTrace();
		}
		return rowAdded;
	}
	
	//get
	public List<Fee> findAll(){
		List<Fee> list = new ArrayList<>();
		
		try(PreparedStatement pstmt = con.prepareStatement(findAllSql)) {
			
			ResultSet rs =pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String branch = rs.getString("branch");
				String year = rs.getString("year");
				double amount = rs.getDouble("amount");
				
				Fee rowRef = new Fee(id,branch,year,amount);
				
				list.add(rowRef);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public Optional<Fee> findById(int key) {
		
		Optional<Fee> found = Optional.empty();
				
		try(PreparedStatement pstmt = con.prepareStatement(findByIdSql)) {
					
			pstmt.setInt(1, key);
			
			ResultSet rs =pstmt.executeQuery();
					
			if(rs.next()) {
						
				int id = rs.getInt("id");
				String branch = rs.getString("branch");
				String year = rs.getString("year");
				double amount = rs.getDouble("amount");
						
				Fee foundObject = new Fee(id,branch,year,amount);
						
				found = Optional.of(foundObject);
			}
					
		}catch(SQLException e) {
				e.printStackTrace();
		}
				
			
		return found;
	}
	
	//delete
	public int removeById(int id) {
		int rowDeleted=0;
		try(PreparedStatement pstmt = con.prepareStatement(removeByIdSql)) {
			pstmt.setInt(1, id);
			rowDeleted =pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
			
		return rowDeleted;
	}
	
	public int update(String branch,double amount) {
		int rowsUpdated=0;
		try(PreparedStatement pstmt=con.prepareStatement(updateByBranchSql)){
			pstmt.setDouble(1, amount);
			pstmt.setString(2,branch);
			rowsUpdated=pstmt.executeUpdate();
			}catch(SQLException e) {
					e.printStackTrace();
				}
		return rowsUpdated;
	}
	


}
