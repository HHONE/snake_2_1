/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RankingList;

import java.io.*;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
/**
 *
 * @author 刘宇
 */
public class RankingList {
    private  int[] RankingList=new int[10];
    private  File file;
    public RankingList(){
	file=new File("List.xls");
        readExcel(file);
    }
    public  int[] getList(){
        return RankingList;
    }
    public void  setList(int[] a){
        RankingList=a;
    }
    public  void setRangingList(int[] b) throws FileNotFoundException, IOException{
        OutputStream are=new FileOutputStream(file.getAbsoluteFile());
        WritableWorkbook wwb=Workbook.createWorkbook(are);
                                    WritableSheet ws=wwb.createSheet("a", 1);
						for(int i=0;i<10;i++) {
							jxl.write.Number a=new jxl.write.Number(0,i,b[i]);
							try {
								ws.addCell(a);
							} catch (RowsExceededException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (WriteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                                                }
			wwb.write();
			try {
				wwb.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    public void readExcel(File file) {
		try {
			InputStream is=new FileInputStream(file.getAbsolutePath());
			Workbook wb=Workbook.getWorkbook(is);
				Sheet sheet=wb.getSheet(0);
				for(int j=0;j<10;j++){
                                            String data=sheet.getCell(0,j ).getContents();
                                             RankingList[j]= (int) Double.parseDouble(data);  
				}
			wb.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(BiffException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
