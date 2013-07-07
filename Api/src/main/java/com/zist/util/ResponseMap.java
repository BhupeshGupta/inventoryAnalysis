package com.zist.util;

import java.util.HashMap;

public class ResponseMap extends HashMap<String, Object> {
	private static final long serialVersionUID = -7408313786777974564L;

	public ResponseMap() {
		super();
		this.put("status", "0");
		this.put("message", "Message Not Supplied");
	}
	
	public void setStatus(String status){
		this.put("status", status);
	}
	
	public String getStatus(){
		return (String)this.get("status");
	}
	
	public void setMessage(String message){
		this.put("status", message);
	}
	
	public String getMessage(){
		return (String)this.get("message");
	}
	
	public void setError(String error){
		this.setStatus("1");
		this.setMessage(error);
	}

}
