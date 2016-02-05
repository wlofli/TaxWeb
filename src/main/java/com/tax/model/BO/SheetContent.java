package com.tax.model.BO;

import java.util.ArrayList;
import java.util.List;

/**
 * 多sheet下载用
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2016年1月29日
 */
public class SheetContent {

	private List<String[]> contents = new ArrayList<String[]>();
	
	private int dataSize = 0;
	
	public SheetContent(int length){
		
		dataSize = length;
		
	}

	/**
	 * @return the contents
	 */
	public List<String[]> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<String[]> contents) {
		this.contents = contents;
	}

	/**
	 * @return the dataSize
	 */
	public int getDataSize() {
		return dataSize;
	}
	
	
}
