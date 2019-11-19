package com.example.user.rumus.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseLogin{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("sukses")
	private boolean sukses;

	@SerializedName("logresku")
	private List<LogreskuItem> logresku;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setSukses(boolean sukses){
		this.sukses = sukses;
	}

	public boolean isSukses(){
		return sukses;
	}

	public void setLogresku(List<LogreskuItem> logresku){
		this.logresku = logresku;
	}

	public List<LogreskuItem> getLogresku(){
		return logresku;
	}
}