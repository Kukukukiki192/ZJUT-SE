package cn.edu.zjut.java.labpdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFInvoiceExtractor {

    /**
     * @param path pdf文件的路径
     * @return  pdf中的文本信息，但是由于pdf本身格式的问题，导致文本的顺序可能会错乱。
     */
    public  String parsePDF(String path){
        String result = "";
        try{
            PDDocument document = PDDocument.load(new File(path));
            PDFTextStripper stripper = new PDFTextStripper();

            stripper.setSortByPosition(true);

            for (int p = 1; p <= document.getNumberOfPages(); ++p)
            {
                // Set the page interval to extract. If you don't, then all pages would be extracted.
                stripper.setStartPage(p);
                stripper.setEndPage(p);

                // let the magic happen
                String text = stripper.getText(document);
                result += text;

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }



    public static void main(String[] args) {

        PDFInvoiceExtractor pie = new PDFInvoiceExtractor();
        System.out.println(pie.parsePDF("031001800211-84462201 - 图书.pdf"));


        //TODO  这里开始你们的表演：
        //使用String解析上述的文本信息(即下面的变量s)，只输出发票代码，发票号码，开票日期（YYYYMMDD公示），校验码后六位
        String s = pie.parsePDF("031001800211-84462201 - 图书.pdf");   

        String s1=s.substring(s.indexOf("发票代码"),s.indexOf("上")); 
        s1=s1.replaceAll(" ","");
        
        String s2=s.substring(s.indexOf("发票号码"),s.indexOf("国")); 
        
        String s3=s.substring(s.indexOf("开票日期"),s.indexOf("机"));
        s3=s3.replaceAll(" ","");
        s3=s3.replaceAll("年","");
		s3=s3.replaceAll("月","");
		s3=s3.replaceAll("日","");
        
        String s4=s.substring(s.indexOf("校 验 码"),s.indexOf("名"));
        s4=s4.replaceAll(" ","");
        s4=s4.substring(s4.length()-8);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("校验码:"+s4);
    }

}