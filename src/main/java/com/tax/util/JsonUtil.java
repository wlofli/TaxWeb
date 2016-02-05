package com.tax.util;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tax.model.DO.AddedValueTax;
import com.tax.model.DO.Balancesheet;
import com.tax.model.DO.Profitstatement;
import com.tax.model.DO.TaxOrgInfo;

/**
 * author lzc

 */
public class JsonUtil {
	 public static AddedValueTax[] parseByJson(String jsonStr)throws Exception{
	        if (jsonStr==null || jsonStr.equals(""))
	            throw new Exception("json数据为空");

	        JSONArray jsonarray = null;

	        try {
	            jsonarray = new JSONArray(jsonStr);
	        }
	        catch (JSONException e){
	            throw new Exception("解析json错误["+e.getMessage()+"]");
	        }

	        int len = jsonarray.length();
	        AddedValueTax[] vatList = new AddedValueTax[len];
	        for (int i=0;i<len;i++){
	            JSONObject jsonObj = jsonarray.getJSONObject(i);
	            AddedValueTax vat = new AddedValueTax();
	            vat.setTaxCode(jsonObj.getString("tax_code"));
	            vat.setStartdate(Integer.parseInt(jsonObj.getString("start_date"))); 
	            vat.setEnddate(Integer.parseInt(jsonObj.getString("end_date")));
	            vat.setDeclaredate(Integer.parseInt(jsonObj.getString("declare_date"))); 
	            vat.setAmountTax(new BigDecimal(jsonObj.getString("amount_tax"))); 
	            vat.setAddtime(new Date()); 
	            vatList[i] = vat;
	        }
	        return vatList;
	    }
	 
	 public static Balancesheet getBalanceSheet(HttpServletRequest request){
		 Balancesheet balancesheet = new Balancesheet();
		 balancesheet.setTaxCode(request.getParameter("tax_code").trim());
		 balancesheet.setReportDate(Integer.parseInt(request.getParameter("report_date")));
		 balancesheet.setReportContent(Base64.getFromBase64(request.getParameter("jsondata")));
		 return balancesheet;
	 }
	 
	 
	 public static Profitstatement getProfit(HttpServletRequest request){
		 Profitstatement profitstatement = new Profitstatement();
		 profitstatement.setTaxCode(request.getParameter("tax_code").trim());
		 profitstatement.setReportDate(Integer.parseInt(request.getParameter("report_date")));
		 profitstatement.setReportContent(Base64.getFromBase64(request.getParameter("jsondata")));
		 return profitstatement;
	 }
	 
	 
	 public static TaxOrgInfo getTaxOrgInfo(String jsonString) throws Exception{
		  if (jsonString==null || jsonString.equals(""))
              throw new Exception("json数据为空");

          JSONObject jsonobj = null;

          try {
              jsonobj = new JSONObject(jsonString);
          }
          catch (JSONException e){
              throw new Exception("解析json错误["+e.getMessage()+"]");
          }
          TaxOrgInfo orgInfo = new TaxOrgInfo();

          orgInfo.setName(jsonobj.getString("name").trim());
          orgInfo.setAddress(jsonobj.getString("address").trim());
          orgInfo.setTaxCode(jsonobj.getString("tax_code").trim());
          orgInfo.setTaxOrg(jsonobj.getString("tax_org").trim());
          orgInfo.setRegtype(jsonobj.getString("regtype").trim());
          orgInfo.setIndustry(jsonobj.getString("industry").trim());
          orgInfo.setTel( jsonobj.getString("tel").trim());
          orgInfo.setLegalPerson(jsonobj.getString("legal_person").trim());
          orgInfo.setmOrg(jsonobj.getString("m_org").trim());
          orgInfo.setcOrg(jsonobj.getString("c_org").trim());
          orgInfo.setChargeCode(jsonobj.getString("charge_code").trim());
          orgInfo.setMobile(jsonobj.getString("mobile").trim());
          return orgInfo;
	 }
	
	
	

}
