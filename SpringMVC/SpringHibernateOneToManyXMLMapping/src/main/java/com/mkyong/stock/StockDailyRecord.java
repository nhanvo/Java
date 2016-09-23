package com.mkyong.stock;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

public class StockDailyRecord implements java.io.Serializable{
	private Integer recordId;
	private Stock stock;
	private Float priceOpen;
	private Float priceClose;
	private Float priceChange;
	private Long volume;
	private Date date;
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Float getPriceOpen() {
		return priceOpen;
	}
	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}
	public Float getPriceClose() {
		return priceClose;
	}
	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}
	public Float getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
