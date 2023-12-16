package group7_java.school_bussiness_tour_management.common;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDFExporter {

    private static PDPage page;

    public static void exportJTableToPDF(String title, String fileName, JTable table) {
        try (PDDocument document = new PDDocument()) {
            PDRectangle mediaBox = PDRectangle.A4;
            page = new PDPage(mediaBox);
            document.addPage(page);

            float margin = 50;
            float yStart = mediaBox.getHeight() - margin;
            float tableWidth = mediaBox.getWidth() - 2 * margin;
            TableModel model = table.getModel();
            int rowCount = model.getRowCount();
            int colCount = model.getColumnCount();
            float tableHeight = table.getRowHeight() * (rowCount + 1);
            float yPosition = yStart - 20;

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true)) {
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
                setFont(contentStream, PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Medium.ttf")), document, 6);

                for (int j = 0; j < colCount; j++) {
                    String text = model.getColumnName(j);
                    contentStream.beginText();
                    contentStream.newLineAtOffset(textx, yPosition);
                    contentStream.showText(text);
                    contentStream.endText();
                    textx += (tableWidth / colCount);
                }

                // Draw table content
                float rowHeight = table.getRowHeight();
                float cellWidth = tableWidth / colCount;
                float currentY = yPosition;

                for (int i = 0; i < rowCount; i++) {
                    textx = margin + 2;

                    // Draw each line in the current cell
                    float textHeight = rowHeight;
                    float cellYPosition = currentY - textHeight;

                    for (int j = 0; j < colCount; j++) {
                        String text = model.getValueAt(i, j).toString();

                        float textWidth = getStringWidth(text, PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Regular.ttf")), 6);
                        float cellXPosition = textx;

                        // Set font before drawing text
                        setFont(contentStream, PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Medium.ttf")), document, 6);

                        contentStream.beginText();
                        contentStream.newLineAtOffset(cellXPosition, cellYPosition);
                        contentStream.showText(text);
                        contentStream.endText();

                        textx += cellWidth;
                    }

                    currentY -= rowHeight;

                    if (currentY < 0 && i < rowCount - 1) {
                        // Move to the next page if necessary
                        page = new PDPage(mediaBox);
                        document.addPage(page);
                        currentY = mediaBox.getHeight() - margin - rowHeight;
                    }
                }

            }

            // Save the PDF document
            document.save(new File(fileName));
            MessageDialog.showInfoDialog(table, "Xuất bản PDF thành công, vui lòng vào thư mục pdf có thư mục cha là resources để xem", "Thông báo");

        } catch (IOException e) {
            e.printStackTrace();  // Xử lý ngoại lệ
        }
    }

    private static float getStringWidth(String text, PDFont font, float fontSize) throws IOException {
        return font.getStringWidth(text) * fontSize / 1000f;
    }

    private static void setFont(PDPageContentStream contentStream, PDFont pdFont, PDDocument document, float fontSize) throws IOException {
        if (pdFont == null) {
            pdFont = PDType0Font.load(document, new File("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Regular.ttf"));
        }
        contentStream.setFont(pdFont, fontSize);
    }
}
