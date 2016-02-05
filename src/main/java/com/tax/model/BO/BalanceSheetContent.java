package com.tax.model.BO;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class BalanceSheetContent {
	
	
	public BalanceSheetContent(String jsonContent) {
		JSONObject json = new JSONObject(jsonContent);
		try {
			tax_code = json.getString("tax_code");
			repost_date = json.getString("repost_date");
			list = new ArrayList<BalanceSheetContentRows>();
			JSONArray array = (JSONArray) json.get("rows");
			for (int i = 0; i < array.length(); i++) {
				BalanceSheetContentRows rows = new BalanceSheetContentRows();
				JSONObject obj = (JSONObject) array.get(i);
				rows.setAsset(obj.getString("asset"));
				rows.setBalance_begin1(obj.getString("balance_begin1"));
				rows.setBalance_begin2(obj.getString("balance_begin2"));
				rows.setIndex1(obj.getString("index1"));
				rows.setIndex2(obj.getString("index2"));
				rows.setLiabilities(obj.getString("liabilities"));
				rows.setBalance_end1(obj.getString("balance_end1"));
				rows.setBalance_end2(obj.getString("balance_end2"));
				list.add(rows);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	private String tax_code;
	private String repost_date;
	private List<BalanceSheetContentRows> list;
	
	
	public List<BalanceSheetContentRows> getList() {
		return list;
	}


	public void setList(List<BalanceSheetContentRows> list) {
		this.list = list;
	}


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




	public class BalanceSheetContentRows{
		private String asset;
		private String index1;
		private String balance_end1;
		private String balance_begin1;
		private String liabilities;
		private String index2;
		private String balance_end2;
		private String balance_begin2;
		public String getAsset() {
			return asset;
		}
		public void setAsset(String asset) {
			this.asset = asset;
		}
		public String getIndex1() {
			return index1;
		}
		public void setIndex1(String index1) {
			this.index1 = index1;
		}
		public String getBalance_end1() {
			return balance_end1;
		}
		public void setBalance_end1(String balance_end1) {
			this.balance_end1 = balance_end1;
		}
		public String getBalance_begin1() {
			return balance_begin1;
		}
		public void setBalance_begin1(String balance_begin1) {
			this.balance_begin1 = balance_begin1;
		}
		public String getLiabilities() {
			return liabilities;
		}
		public void setLiabilities(String liabilities) {
			this.liabilities = liabilities;
		}
		public String getIndex2() {
			return index2;
		}
		public void setIndex2(String index2) {
			this.index2 = index2;
		}
		public String getBalance_end2() {
			return balance_end2;
		}
		public void setBalance_end2(String balance_end2) {
			this.balance_end2 = balance_end2;
		}
		public String getBalance_begin2() {
			return balance_begin2;
		}
		public void setBalance_begin2(String balance_begin2) {
			this.balance_begin2 = balance_begin2;
		}
		
		
		
	}
	

	
}

