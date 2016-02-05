package com.tax.model.BO;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class ProfitContent {
	
	public ProfitContent(String jsonString){
		JSONObject json = new JSONObject(jsonString);
		try {
			tax_code = json.getString("tax_code");
			repost_date = json.getString("repost_date");
			list = new LinkedList<ProfitContentRow>();
			JSONArray array = (JSONArray) json.get("rows");
			for (int i = 0; i < array.length(); i++) {
				ProfitContentRow row = new ProfitContentRow();
				JSONObject obj = (JSONObject) array.get(i);
				row.setIndex(obj.getString("index"));
				row.setItem(obj.getString("item"));
				row.setYear_amount(obj.getString("year_amount"));
				row.setMonth_amount(obj.getString("month_amount"));
				list.add(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	private String tax_code;
	private String repost_date;
	
	private List<ProfitContentRow> list;
	
	
	
	public String getTax_code() {
		return tax_code;
	}



	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}



	public String getRepost_date() {
		return repost_date;
	}



	public void setRepost_date(String repost_date) {
		this.repost_date = repost_date;
	}



	public List<ProfitContentRow> getList() {
		return list;
	}



	public void setList(List<ProfitContentRow> list) {
		this.list = list;
	}



	public class ProfitContentRow{
		private String item;
		private String index;
		private String year_amount;
		private String month_amount;
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		public String getIndex() {
			return index;
		}
		public void setIndex(String index) {
			this.index = index;
		}
		public String getYear_amount() {
			return year_amount;
		}
		public void setYear_amount(String year_amount) {
			this.year_amount = year_amount;
		}
		public String getMonth_amount() {
			return month_amount;
		}
		public void setMonth_amount(String month_amount) {
			this.month_amount = month_amount;
		}
	
	
	}
	

}
