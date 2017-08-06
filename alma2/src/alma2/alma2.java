package alma2;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

import java.io.IOException; 
import java.io.InputStream; 

import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException; 
import org.apache.poi.openxml4j.opc.OPCPackage; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.FormulaEvaluator; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.ss.usermodel.WorkbookFactory; 
import org.apache.poi.xssf.usermodel.XSSFCell; 
import org.apache.poi.xssf.usermodel.XSSFRow; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class alma2 {
   public static void main(String[] args)throws Exception {
	   
	  Scanner keyboard = new Scanner(System.in);
      
	  File file = new File("c:\\Users\\Nurlanuly Maksat\\Desktop\\alma\\result");//DLYA RABOTY S FAILOM RESULT
      
	  Scanner inputFile = new Scanner(file);//DLYA RABOTY S FAILOM RESULT

	  File file1 = new File("c:\\Users\\Nurlanuly Maksat\\Desktop\\alma\\result2");//DLYA RABOTY S FAILOM RESULT2
      
	  Scanner inputFile1 = new Scanner(file1);//DLYA RABOTY S FAILOM RESULT2
	  
      int counter = 0;// NOMER STROK V FILE RESULT
      
      int counter1 = 0;// NOMER STROK V FILE RESULT2
      
      int counter2 = 0;// IS_PROCESSED = TRUE
      
      int counter3 = 0;// IS_PROCESSED = FALSE
      
      int counter4 = 0;// IS_PROCESSED = TRUE, BUT FEDERAL NUMBER IS FALSE
      
      int counter5 = 0;// IS_PROCESSED = TRUE, BUT FEDERAL NUMBER IS TRUE
      
      int counter6 = 0;// IF THERE IS NO FEDERAL NUMBER
	  
      XWPFDocument document= new XWPFDocument(); 
      
      FileOutputStream out = new FileOutputStream(new File("Otchet.docx"));
        
      
      
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
  	/////////////////////////////////////////////////////////////////////////////////////
      
      
      while (inputFile1.hasNext())
      {
         
         String [] familyName1 = inputFile1.nextLine().split("\\|");
         
         if (familyName1.length > 1){
        	
        	 //3 IF IS_PROCESSED EQUALS TRUE
        	 if(familyName1[2].charAt(1) == 't'){
        		 counter2 += 1;
        	 }
        	//3
        	
        	 
        	 
        	 //4 IF IS_PROCESSED IS EQUALS FALSE
        	 if(familyName1[2].charAt(1) == 'f'){
        		 counter3 += 1;
        	 }
        	 //4
        	 
        	 
        	 
        	 //5IF FEDERAL NUMBERS ARE FALSE WE ADD HERE +1 TO COUNTER4
        	 if (familyName1[2].charAt(1) == 't' && familyName1[3].length() >= 1){//ZHONDEU KEREK NOMERDI 9-GA TEN BOLSA
        		 if(familyName1[2].charAt(1) == 't' && familyName1[3].length() == 8){//ZHONDEU KEREK, YAGNI 9-GA TEN BOLSA BIRAK DURYS BOLSANY ISTEU KEREK
            		 if(!('A' <= familyName1[3].charAt(1) && familyName1[3].charAt(1) <= 'Z') ||  !('0' <= familyName1[3].charAt(2) && familyName1[3].charAt(2) <= '9') || !('0' <= familyName1[3].charAt(3) && familyName1[3].charAt(3) <= '9') || !('0' <= familyName1[3].charAt(4) && familyName1[3].charAt(4) <= '9') || !('A' <= familyName1[3].charAt(5) && familyName1[3].charAt(5) <= 'Z') || !('A' <= familyName1[3].charAt(6) && familyName1[3].charAt(6) <= 'Z') || !('A' <= familyName1[3].charAt(7) && familyName1[3].charAt(7) <= 'Z')){
            			counter4 += 1;
            		 } 
            	 }
            	 if(familyName1[2].charAt(1) == 't' && familyName1[3].length() == 9){//ZHONDEU KEREK, YAGNI 9-GA TEN BOLSA BIRAK DURYS BOLSANY ISTEU KEREK
            		 if(!('0' <= familyName1[3].charAt(1) && familyName1[3].charAt(1) <= '9') || !('0' <= familyName1[3].charAt(2) && familyName1[3].charAt(2) <= '9') || !('0' <= familyName1[3].charAt(3) && familyName1[3].charAt(3) <= '9') || !('A' <= familyName1[3].charAt(4) && familyName1[3].charAt(4) <= 'Z') || !('A' <= familyName1[3].charAt(5) && familyName1[3].charAt(5) <= 'Z') || !('A' <= familyName1[3].charAt(6) && familyName1[3].charAt(6) <= 'Z') || !('0' <= familyName1[3].charAt(7) && familyName1[3].charAt(7) <= '9') || !('0' <= familyName1[3].charAt(8) && familyName1[3].charAt(8) <= '9')){
            			counter4 += 1;
            		 } 
            	 }
        		 else{
        			 counter4 += 1;
        		 }
        	 }
        	 //5
        	 
        	 
        	 
        	 //6// IF FEDERAL NUMBERS ARE TRUE WE ADD HERE +1 TO COUNTER5
        	 if(familyName1[2].charAt(1) == 't' && familyName1[3].length() == 8){//ZHONDEU KEREK, YAGNI 9-GA TEN BOLSA BIRAK DURYS BOLSANY ISTEU KEREK
        		 if(('A' <= familyName1[3].charAt(1) && familyName1[3].charAt(1) <= 'Z') &&  ('0' <= familyName1[3].charAt(2) && familyName1[3].charAt(2) <= '9') && ('0' <= familyName1[3].charAt(3) && familyName1[3].charAt(3) <= '9') && ('0' <= familyName1[3].charAt(4) && familyName1[3].charAt(4) <= '9') && ('A' <= familyName1[3].charAt(5) && familyName1[3].charAt(5) <= 'Z') && ('A' <= familyName1[3].charAt(6) && familyName1[3].charAt(6) <= 'Z') && ('A' <= familyName1[3].charAt(7) && familyName1[3].charAt(7) <= 'Z')){
        			counter5 += 1;
        		 } 
        	 }
        	 if(familyName1[2].charAt(1) == 't' && familyName1[3].length() == 9){//ZHONDEU KEREK, YAGNI 9-GA TEN BOLSA BIRAK DURYS BOLSANY ISTEU KEREK
        		 if(('0' <= familyName1[3].charAt(1) && familyName1[3].charAt(1) <= '9') && ('0' <= familyName1[3].charAt(2) && familyName1[3].charAt(2) <= '9') && ('0' <= familyName1[3].charAt(3) && familyName1[3].charAt(3) <= '9') && ('A' <= familyName1[3].charAt(4) && familyName1[3].charAt(4) <= 'Z') && ('A' <= familyName1[3].charAt(5) && familyName1[3].charAt(5) <= 'Z') && ('A' <= familyName1[3].charAt(6) && familyName1[3].charAt(6) <= 'Z') && ('0' <= familyName1[3].charAt(7) && familyName1[3].charAt(7) <= '9') && ('0' <= familyName1[3].charAt(8) && familyName1[3].charAt(8) <= '9')){
        			counter5 += 1;
        		 } 
        	 }
        	 //6
        	 
        	 
        	 
        	 //7 IF THERE IS NO FEDERAL NUMBER
        	 if(familyName1[3].length() == 1){
        		 counter6 += 1;
        	 }
        	 //7
        	 
         }
         //3
         
         
         
         //2
         counter1 += 1;//NUMBER OF ROWS IN RESULT2 FILE
         //2
         
         
         
       }
      
      while (inputFile.hasNext())
      {
         
         String [] familyName = inputFile.nextLine().split("\\|");
         
         //1
         counter += 1;//NUMBER OF ROWS IN RESULT FILE
         //1
         
       }
      
      
      
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////

      
      XWPFParagraph paragraph = document.createParagraph();
      XWPFRun run=paragraph.createRun();
      run.setText("Краткая форма ежемесячной отчетности ");
      run.addBreak();
      run.addBreak();
      //run.setText("			");
      //run.addTab();
      run.setText("Отчет сформирован за период времени: с 26.07.2017 10:00 по 27.07.2017 23:59 GTM+6");
      run.addBreak();
      run.setText("Отправленно массивов фотографий: " +  String.valueOf(counter1));
      run.addBreak();
      run.setText("Кол-во URL на фотографии в массивах: " +  String.valueOf(counter));
      run.addBreak();
      run.setText("Из них:");
      run.addBreak();
      run.addTab();
      run.setText("Успешно загружено\\обработано фотографий: " +  String.valueOf(counter2));
      run.addBreak();
      run.addTab();
      run.setText("Не было загружено\\обработано фотографий: " +  String.valueOf(counter3));
      run.addBreak();
      run.addTab();
      run.setText("Фото без госномера: " +  String.valueOf(counter4));
      run.addBreak();
      run.setText("Массивов с найденными гос.номерами: " +  String.valueOf(counter5));
      run.addBreak();
      run.setText("Массивов без найденных гос.номеров: " +  String.valueOf(counter6));
      run.addBreak();
      run.addBreak();
      run.setText("Итого к оплате: 23 тенге");
      run.addBreak();
      
      System.out.println("otchet.docx written successfully");
      
      
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
      
      document.write(out);
      
      out.close();

      inputFile1.close();
      
      inputFile.close();
      
      keyboard.close();
      
      
      
   }
}