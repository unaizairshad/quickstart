package com.example.demo.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Fee;
import com.example.demo.repos.FeeRepository;

public class FeeServices {
	private FeeRepository repo=null;

	public FeeServices() {
		super();
		this.repo=new FeeRepository();
		// TODO Auto-generated constructor stub
	}
	
	public Fee add(Fee entity)  throws SQLException {
		return this.repo.add(entity)==1?entity:null;
	}
	
	public List<Fee> findAll(){
		return this.repo.findAll();
	}
	public Optional<Fee> findById(int key){
		return this.repo.findById(key);
	}
	public int removeById(int key) {
		return this.repo.removeById(key);
	}
	 public int update(String branch,double amount) {
			return this.repo.update(branch, amount);
			
		}
}
