package com.jumawax.model;

public class Visit {

	private String pjpId;
	private String storeCode;
	private String skuId;
	private String collectDtm;
	private String oosPromo;
	private String oos;
	private String oosPartial;
	public String getOosPartial() {
		return oosPartial;
	}
	public void setOosPartial(String oosPartial) {
		this.oosPartial = oosPartial;
	}
	private String msg;
	public String getPjpId() {
		return pjpId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setPjpId(String pjpId) {
		this.pjpId = pjpId;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getCollectDtm() {
		return collectDtm;
	}
	public void setCollectDtm(String collectDtm) {
		this.collectDtm = collectDtm;
	}
	public String getOosPromo() {
		return oosPromo;
	}
	public void setOosPromo(String oosPromo) {
		this.oosPromo = oosPromo;
	}
	public String getOos() {
		return oos;
	}
	public void setOos(String oos) {
		this.oos = oos;
	}
	
	
}
