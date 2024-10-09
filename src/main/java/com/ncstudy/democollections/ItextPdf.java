package com.ncstudy.democollections;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileOutputStream;


//https://mp.weixin.qq.com/s/FKGqjZaV66NJFHbXE5ROiA

//https://mp.weixin.qq.com/s/x9AriZPem6lQwuytNFNBBg 不好用
@RestController
@RequestMapping
public class ItextPdf {


    @GetMapping("/itextpdf")
    @ResponseBody
    public void test(){
        try {
            // 创建一个新的 PDF 文档
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("D:\\adjusted_table_position.pdf"));
            document.open();

            // 添加文本内容
            document.add(new Paragraph("Test PDF with Table"));

            // 创建表格
            PdfPTable table = new PdfPTable(2);
            table.addCell("Name");
            table.addCell("Age");
            table.addCell("Alice");
            table.addCell("25");
            table.addCell("Bob");
            table.addCell("30");

            // 设置表格之前的间距
            table.setSpacingBefore(20f);

            // 设置表格之后的间距
            table.setSpacingAfter(20f);

            // 设置表格的总宽度
            table.setTotalWidth(300f);

            // 将表格添加到 PDF
            document.add(table);

            document.close();

            System.out.println("PDF 文件生成成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
