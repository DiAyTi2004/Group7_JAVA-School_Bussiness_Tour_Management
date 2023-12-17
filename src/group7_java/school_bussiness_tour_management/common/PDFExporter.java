package group7_java.school_bussiness_tour_management.common;

import javax.swing.JTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import javax.swing.JFileChooser;

public class PDFExporter {

    public static void exportTableToPDF(JTable table, String title) {
        Document document = new Document(PageSize.A4.rotate());

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showDialog(null, "Chọn thư mục");
            if (result == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn thư mục đã chọn
                String selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();

                // Hỏi người dùng về việc đặt lại tên file
                String fileName = "outputPDF"; // Tên mặc định
                String userInput = javax.swing.JOptionPane.showInputDialog("Đặt tên cho tệp pdf của bạn hoặc bỏ trống và tệp sẽ được tạo với tên là outputPDF:");
                if (userInput != null && !userInput.trim().isEmpty()) {
                    fileName = userInput.trim();
                }

                // Đường dẫn đầy đủ cho file xuất
                String exportPath = selectedDirectory + "/" + fileName + ".pdf";

                PdfWriter.getInstance(document, new FileOutputStream(exportPath));
                document.open();

                // Chọn font Roboto
                BaseFont baseFont = BaseFont.createFont("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                com.itextpdf.text.Font roboto = FontFactory.getFont("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 13);

                BaseFont baseFontTitle = BaseFont.createFont("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Medium.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                com.itextpdf.text.Font robotoTitle = FontFactory.getFont("src/group7_java/school_bussiness_tour_management/resources/fonts/Roboto-Medium.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 16);

                // Tạo một bảng iText
                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                pdfTable.setWidthPercentage(100);

                // Tạo một ô đặc biệt chứa tiêu đề và đặt căn giữa
                PdfPCell titleCell = new PdfPCell(new Phrase(title, robotoTitle));
                titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                titleCell.setColspan(table.getColumnCount());
                titleCell.setPaddingTop(12);
                titleCell.setPaddingBottom(12);
                titleCell.setPaddingLeft(8);
                titleCell.setPaddingRight(8);
                titleCell.setBorder(Rectangle.NO_BORDER);
                pdfTable.addCell(titleCell);

                // Thêm tiêu đề từ tên cột của bảng Swing
                TableColumnModel columnModel = table.getColumnModel();
                for (int column = 0; column < columnModel.getColumnCount(); column++) {
                    TableColumn tableColumn = columnModel.getColumn(column);
                    PdfPCell cell = new PdfPCell(new Phrase(tableColumn.getHeaderValue().toString(), roboto));
                    titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.YELLOW);
                    cell.setPaddingTop(4);
                    cell.setPaddingBottom(4);
                    cell.setPaddingLeft(8);
                    cell.setPaddingRight(8);
                    cell.setFixedHeight(26);
                    pdfTable.addCell(cell);
                }

                // Thêm dữ liệu từ bảng Swing
                for (int row = 0; row < table.getRowCount(); row++) {
                    for (int column = 0; column < table.getColumnCount(); column++) {
                        PdfPCell cellContent = new PdfPCell(new Phrase(table.getValueAt(row, column).toString(), roboto));
                        cellContent.setPaddingTop(4);
                        cellContent.setPaddingBottom(4);
                        cellContent.setPaddingLeft(8);
                        cellContent.setPaddingRight(8);
                        cellContent.setFixedHeight(26);
                        pdfTable.addCell(cellContent);
                    }
                }

                document.add(pdfTable);
                MessageDialog.showInfoDialog(table, "Đã xuất PDF thành công", "Thông báo");
            }
        } catch (Exception ex) {
             MessageDialog.showErrorDialog(table, "Có lỗi khi xuất PDF, chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        } finally {
            document.close();
        }
    }

}
