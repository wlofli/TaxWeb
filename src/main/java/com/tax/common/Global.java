package com.tax.common;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class Global {
	public static final String TAX_CODE = "tax_code";//税号
	public static final String TAX_PWD  ="tax_pwd";//税号密码
	public static final String VPDN_USER = "vpdn_user";//vpdn用户
	public static final String VPDN_PWD = "vpdn_pwd";//vpdn密码
	public static final String COMPANY_NAME = "company";//纳税人名称
	public static final String SESSION_CHECK_CODE = "session_check_code";//验证码
	public static final String USER_BANK ="user_bank";
	public static final String USER_NAME = "user_name";
	public static final String USER_COMPANY = "user_company";
	public static final String USER_PHONE = "user_phone";
	public static final String USER_ID = "user_id";
	
	public static final int PAGE_SIZE = 12;
	

	
	public static final String RESULT_STATUS = "result";//json返回状态
	public static final String RESULT_MESSAGE = "message";//json返回信息
	
	
	//add by maozj at 2016/1/28 start
	public static final String DOWNLOAD_VAT_TABLE_NAME = "增值税表";
	public static final String DOWNLOAD_VAT_CODE = "纳税人识别号";
	public static final String DOWNLOAD_VAT_NAME = "纳税人名称";
	public static final String DOWNLOAD_VAT_START = "所属开始日期";
	public static final String DOWNLOAD_VAT_END = "所属终止日期";
	public static final String DOWNLOAD_VAT_AMOUNT = "税额";
	
	public static final String DOWNLOAD_BALANCE_SHEET_TABLE_NAME = "资产负债表";
	public static final String DOWNLOAD_BALANCE_SHEET_ASSET = "资产";
	public static final String DOWNLOAD_BALANCE_SHEET_INDEX = "序号";
	public static final String DOWNLOAD_BALANCE_SHEET_START = "期初";
	public static final String DOWNLOAD_BALANCE_SHEET_END = "期末";
	public static final String DOWNLOAD_BALANCE_SHEET_DEBT = "负债";
	
	public static final String DOWNLOAD_PROFIT_TABLE_NAME = "利润表";
	public static final String DOWNLOAD_PROFIT_ITEM = "项目";
	public static final String DOWNLOAD_PROFIT_MONTH_TOTAL = "本月累计";
	public static final String DOWNLOAD_PROFIT_INDEX = "序号";
	public static final String DOWNLOAD_PROFIT_YEAR_TOTAL = "本年累计";
	//add by maozj at 2016/1/28 end
}
