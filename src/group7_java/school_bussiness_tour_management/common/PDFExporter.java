package group7_java.school_bussiness_tour_management.common;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.PDPageTree;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDFExporter {

    public static void exportJTableToPDF(String title, String fileName, JTable table) {
        try (PDDocument document = new PDDocument()) {
            List<PDPage> pages = new ArrayList<>();
            PDRectangle mediaBox = PDRectangle.A4;

            PDPage page = new PDPage(mediaBox);
            document.addPage(page);
            pages.add(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true);

            float margin = 50;
            float yStart = mediaBox.getHeight() - margin;
            float tableWidth = mediaBox.getWidth() - 2 * margin;

            TableModel model = table.getModel();
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();
            float tableHeight = table.getRowHeight() * (rowCount + 1);

            float yPosition = yStart - 20;

            setFont(contentStream, null, document, 13);

            contentStream.beginText();
            PDFont titleFont = PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Medium.ttf"));
            float titleFontSize = 13;
            contentStream.setFont(titleFont, titleFontSize);

            float titleWidth = getStringWidth(title, titleFont, titleFontSize);
            float titleX = (mediaBox.getWidth() - titleWidth) / 2;
            contentStream.newLineAtOffset(titleX, yPosition);
            contentStream.showText(title);
            contentStream.endText();

            // Draw table header
            yPosition -= 40;
            float textx = margin + 2;
            setFont(contentStream, PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Medium.ttf")), document, 13);

            for (int j = 0; j < colCount; j++) {
                String text = model.getColumnName(j);
                contentStream.beginText();
                contentStream.newLineAtOffset(textx, yPosition);
                contentStream.showText(text);
                contentStream.endText();
                textx += (tableWidth / colCount);
            }

            // Draw table content
            yPosition -= 15;
            setFont(contentStream, PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Regular.ttf")), document, 13);

            float rowHeight = table.getRowHeight();
            for (int i = 0; i < rowCount; i++) {
                textx = margin + 2;
                yPosition -= rowHeight;
                for (int j = 0; j < colCount; j++) {
                    String text = model.getValueAt(i, j).toString();
                    contentStream.beginText();
                    contentStream.newLineAtOffset(textx, yPosition);
                    contentStream.showText(text);
                    contentStream.endText();
                    textx += (tableWidth / colCount);
                }
            }

            contentStream.close();

            // Save the PDF document
            document.save(new File(fileName));
            MessageDialog.showInfoDialog(table, "Xuất bản PDF thành công, vui lòng vào thư mục pdf có thư mục cha là resources để xem", "Thông báo");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setFont(PDPageContentStream contentStream, PDFont pdFont, PDDocument document, float fontSize) throws IOException {
        if (pdFont == null) {
            pdFont = PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Regular.ttf"));     }
        contentStream.setFont(pdFont, fontSize);
    }

    private static float getStringWidth(String text, PDFont font, float fontSize) throws IOException {
        return font.getStringWidth(text) * fontSize / 1000f;
    }
}
