package com.tax.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.tax.model.BO.SheetContent;
/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class ExportToExcel {
	
	/**
	 * 单sheet下载
	 * @param response
	 * @param fileName
	 * @param sheetName
	 * @param header
	 * @param dataList
	 * @throws Exception
	 */
	public void export(HttpServletResponse response, String fileName,
			String sheetName, String[] header, List<String[]> dataList)
			throws Exception {

		//文件名中文化
		byte[] fileNameByte = fileName.getBytes("gb2312");
		String filename = new String(fileNameByte, "iso8859-1");

		// 数据整理
		byte[] bytes = this.formatData(dataList, sheetName, header);

		// 设置相关下载参数
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		response.setContentType("application/vnd.ms-excel");  
		response.setContentLength(bytes.length);
		response.getOutputStream().write(bytes);
	}
	
	/**
	 * 多sheet下载
	 * @param response
	 * @param fileName 文件名
	 * @param header 第一行
	 * @param sheetNames sheet名
	 * @param dataList 内容
	 */
	public void allExport(HttpServletResponse response, String fileName,String[] header, String[] sheetNames,List<SheetContent> dataList) throws Exception {
		
		//文件名中文化
		byte[] fileNameByte = fileName.getBytes("gb2312");
		String filename = new String(fileNameByte, "iso8859-1");
		
		// 数据整理
		byte[] bytes = this.formatDataAll(dataList, sheetNames, header);
		
		// 设置相关下载参数
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		response.setContentType("application/vnd.ms-excel");
		response.setContentLength(bytes.length);
		response.getOutputStream().write(bytes);
	}

	/**
	 * excel数据整理
	 * 
	 * @param dataList
	 * @param sheetName
	 * @param header
	 * @return
	 * @throws IOException
	 */
	private byte[] formatData(List<String[]> dataList, String sheetName,
			String[] header) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();

		// 在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		// 在sheet中添加表头第1行
		HSSFRow row = sheet.createRow(0);

		// 创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		List<String> excelHead = getExcelHead(header);

		HSSFCell cell = null;

		// excel头
		for (int i = 0; i < excelHead.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(excelHead.get(i));
			cell.setCellStyle(style);
			// 设置列宽
			sheet.setColumnWidth(i, excelHead.get(i).getBytes().length * 256);
		}

		// 写入数据
		for (int i = 0; i < dataList.size(); i++) {
			row = sheet.createRow(i + 1);
			String[] temp = dataList.get(i);

			// 创建单元格，并设置值
			int j = 0;

			for (int k = 0; k < temp.length; k++) {
				insertCell(row, j++, temp[k]);
			}
		}

		wb.write(out);

		return out.toByteArray();
	}
	
	/**
	 * excel数据整理all
	 * 
	 * @param dataList
	 * @param sheetName
	 * @param header
	 * @return
	 * @throws IOException
	 */
	private byte[] formatDataAll(List<SheetContent> dataAll, String[] sheetNames,
			String[] header) throws IOException {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		// 创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		
		for (int l = 0; l < sheetNames.length; l++) {
//		for (int l = 0; l < 1; l++) {
			
			// 在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet(sheetNames[l]);
			
			// 在sheet中添加表头第1行
			HSSFRow row = sheet.createRow(0);
			
			// 创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
			// 设置表头
			List<String> excelHead = getExcelHead(header);
			
			HSSFCell cell = null;
			
			// excel头
			for (int i = 0; i < excelHead.size(); i++) {
				cell = row.createCell(i);
				cell.setCellValue(excelHead.get(i));
				cell.setCellStyle(style);
				// 设置列宽
				sheet.setColumnWidth(i, excelHead.get(i).getBytes().length * 256);
			}
			
			// 写入数据
			List<String[]> dataList = dataAll.get(l).getContents();
			for (int i = 0; i < dataList.size(); i++) {
				row = sheet.createRow(i + 1);
				String[] temp = dataList.get(i);
				
				// 创建单元格，并设置值
				int j = 0;
				
				for (int k = 0; k < temp.length; k++) {
					insertCell(row, j++, temp[k]);
				}
			}
		}
		
		
		wb.write(out);
		
		return out.toByteArray();
	}
	
	

	/**
	 * 单元格内容设置
	 * 
	 * @param row
	 * @param i
	 * @param obj
	 */
	private void insertCell(HSSFRow row, int i, Object obj) {
		if (obj == null) {
			row.createCell(i).setCellValue("");
		} else {
			row.createCell(i).setCellValue(obj.toString());
		}

	}

	/**
	 * 头部标题信息设置
	 * 
	 * @return
	 */
	private List<String> getExcelHead(String[] header) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < header.length; i++) {
			result.add(header[i]);
		}

		return result;
	}

}
