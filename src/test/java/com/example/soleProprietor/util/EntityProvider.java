package com.example.soleProprietor.util;

import java.sql.Timestamp;

import com.example.soleProprietor.model.Owner;

public class EntityProvider {
	
	public static Owner getJames() {
        Owner james = new Owner();
    	james.setId(1);
    	james.setName("James");
    	james.setStatus(1);
    	james.setUpdatedBy("Administrator");
    	james.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    	return james;
	}
}
