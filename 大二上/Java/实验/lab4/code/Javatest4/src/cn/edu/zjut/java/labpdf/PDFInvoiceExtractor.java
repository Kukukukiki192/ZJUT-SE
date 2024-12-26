package cn.edu.zjut.java.labpdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFInvoiceExtractor {

    /**
     * @param path pdf�ļ���·��
     * @return  pdf�е��ı���Ϣ����������pdf�����ʽ�����⣬�����ı���˳����ܻ���ҡ�
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
        System.out.println(pie.parsePDF("031001800211-84462201 - ͼ��.pdf"));


        //TODO  ���￪ʼ���ǵı��ݣ�
        //ʹ��String�����������ı���Ϣ(������ı���s)��ֻ�����Ʊ���룬��Ʊ���룬��Ʊ���ڣ�YYYYMMDD��ʾ����У�������λ
        String s = pie.parsePDF("031001800211-84462201 - ͼ��.pdf");   

        String s1=s.substring(s.indexOf("��Ʊ����"),s.indexOf("��")); 
        s1=s1.replaceAll(" ","");
        
        String s2=s.substring(s.indexOf("��Ʊ����"),s.indexOf("��")); 
        
        String s3=s.substring(s.indexOf("��Ʊ����"),s.indexOf("��"));
        s3=s3.replaceAll(" ","");
        s3=s3.replaceAll("��","");
		s3=s3.replaceAll("��","");
		s3=s3.replaceAll("��","");
        
        String s4=s.substring(s.indexOf("У �� ��"),s.indexOf("��"));
        s4=s4.replaceAll(" ","");
        s4=s4.substring(s4.length()-8);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("У����:"+s4);
    }

}