import java.io.*;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class Pudding {

    public static void readDocFile(String fileName) {

        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            HWPFDocument doc = new HWPFDocument(fis);

            WordExtractor we = new WordExtractor(doc);

            String[] paragraphs = we.getParagraphText();

            System.out.println("Total no of paragraph "+paragraphs.length);
            for (String para : paragraphs) {
                System.out.println(para.toString());
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        readDocFile("paper.doc");

    }
}