package Controller;

import Model.Car;
import Model.Sedan;
import Model.Suv;
import View.PdfSpecificationsView;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PdfSpecificationsController {
    private PdfSpecificationsView view;

    public PdfSpecificationsController(PdfSpecificationsView view) {
        this.view = view;

        this.view.addBtnExportActionListener(e->{

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
            String formattedDateTime = now.format(formatter);

            String filePath = "C:/Users/tunca/Desktop/pdfs/"+ formattedDateTime + ".pdf";
            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                document.open();

                PdfPTable table = new PdfPTable(6);

                PdfPCell header1 = new PdfPCell(new com.itextpdf.text.Phrase("Car Id"));
                header1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header1);

                PdfPCell header2 = new PdfPCell(new com.itextpdf.text.Phrase("Car Make"));
                header2.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header2);

                PdfPCell header3 = new PdfPCell(new com.itextpdf.text.Phrase("Car Model"));
                header3.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header3);

                PdfPCell header4 = new PdfPCell(new com.itextpdf.text.Phrase("Car Year"));
                header4.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header4);

                PdfPCell header5 = new PdfPCell(new com.itextpdf.text.Phrase("Daily Price"));
                header5.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header5);

                PdfPCell header6 = new PdfPCell(new com.itextpdf.text.Phrase("Car Type"));
                header6.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(header6);

                List<Car> printedCars = new ArrayList<>(Car.getCars());
                System.out.println(printedCars);

                // it was GOoOoOoOoD.
                if (this.view.getSedanCheckBox().isSelected() && this.view.getSuvCheckBox().isSelected()){
                    //do nothing
                } else if(this.view.getSedanCheckBox().isSelected()){
                    //remove suvs
                    printedCars.removeIf(car -> car instanceof Suv);
                } else if (this.view.getSuvCheckBox().isSelected()){
                    //remove sedans
                    printedCars.removeIf(car -> car instanceof Sedan);
                } else {
                    //do nothing
                }

                double minPrice;
                double maxPrice;

                if(!this.view.getMinPriceField().getText().isEmpty()) {
                    minPrice = Double.parseDouble(this.view.getMinPriceField().getText());
                    printedCars.removeIf(car -> car.getDailyPrice() < minPrice);
                } else
                    minPrice = 0;

                if(!this.view.getMaxPriceField().getText().isEmpty()) {
                    maxPrice = Double.parseDouble(this.view.getMaxPriceField().getText());
                    printedCars.removeIf(car -> car.getDailyPrice() > maxPrice);
                }else
                    maxPrice = 0;

                System.out.printf("minPrice: %.2f%nmaxPrice: %.2f%n",minPrice,maxPrice);


//                if (minPrice == 0 && maxPrice == 0){
//                    //do nothing
//                } else if (minPrice != 0) {
//                    double finalMinPrice = minPrice; // I don't why it is for, intellij suggested that way.
//                    printedCars.removeIf(car -> car.getDailyPrice() > finalMinPrice);
//                } else if (maxPrice != 0) {
//
//                }

                for (Car printCar: printedCars){

                    table.addCell(String.valueOf(printCar.getCarId()));
                    table.addCell(printCar.getMake());
                    table.addCell(printCar.getModel());
                    table.addCell(String.valueOf(printCar.getYear()));
                    table.addCell(String.valueOf(printCar.getDailyPrice()));

                    String carClass = "SUV";
                    if (printCar instanceof Sedan)
                        carClass = "Sedan";

                    table.addCell(String.valueOf(carClass));

                }

                document.add(table);
                JOptionPane.showMessageDialog(view,"PDF created -> " + filePath,
                        "Successfull",JOptionPane.INFORMATION_MESSAGE);
            } catch (DocumentException | IOException ex) {
                ex.printStackTrace();
            } finally {
                document.close();
            }
        });
    }
}
