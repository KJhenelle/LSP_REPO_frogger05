package org.howard.edu.lsp.assignment2;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ETLPipeline {
    public static void main(String[] args) {
        String filePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";
        File file = new File(filePath);
        Integer rowsRead = 0;
        Integer rowsTransformed = 0;
        Integer rowsSkipped = 0;
        String PriceRange="";

        if (file.exists()) {
            // System.out.println("File found: " + filePath);
            
            try (Scanner scanner = new Scanner(file); PrintWriter writer = new PrintWriter(new File(outputFilePath))) {
                writer.println("ProductID,Name,Price,Category,PriceRange");
                if (scanner.hasNextLine()){
                    String headerLine = scanner.nextLine();
                    // System.out.println("Header: " + headerLine);

                    

                    while (scanner.hasNextLine()) {

                        String line = scanner.nextLine();
                        String[] values = line.split(",");
                        if (values.length == 4) {
                            values[1] = values[1].toUpperCase();
                            values[1]= values[1].trim();
                            try {
                                rowsRead++;
                                int id = Integer.parseInt(values[0].trim());
                                float price = Float.parseFloat(values[2].trim());

                                // System.out.println("Valid Row - ID: " + id + " Price: " + price);

                                if (values[3].toUpperCase().trim().equals("ELECTRONICS") ){ {
                                    // System.out.println(values[3]+" is electronic");
                                    // System.out.println(values[2]);
                            
                                    
                                    price-=(price/10);

                                    if (price>500.00) {
                                        values[3]= "Premium Electronics";
                                    }
                                    // System.out.println(price);
                                    }
                                }
                                    String formattedPrice = String.format("%.2f", price);
                                    float roundedPrice = Float.parseFloat(formattedPrice);

                                    DecimalFormat df = new DecimalFormat("#.##");
                                    // System.out.println(df.format(price));
                                    values[2]=df.format(price);
                                    // System.out.println(values[2]);
                                    
                                
                                
                                String range;
                                    if (roundedPrice <= 10.00) range = "Low";
                                    else if (roundedPrice <= 100.00) range = "Medium";
                                    else if (roundedPrice <= 500.00) range = "High";
                                    else range = "Premium";
                                writer.println(values[0].trim()+","+values[1].trim()+","+formattedPrice.trim()+","+values[3].trim()+","+range.trim());
                                rowsTransformed++;
                            }
                            catch (NumberFormatException e){
                                // System.out.println("Skipping invalid row (Bad data): " + line);
                                rowsSkipped++;
                            }
                            // System.out.println(values[1]);
                            // System.out.println(values[3].toUpperCase().trim());

                            
                        
                        

                        
                        }
                        else {
                            // System.out.println("Skipping invalid row (Incorrect number of fields): " + line);
                            rowsSkipped++;
                            rowsRead++;
                        }
                    }

                }

                else{
                    System.out.println("The file is empty.");
                }
                System.out.println("Total rows read: " + rowsRead);
                System.out.println("Total rows transformed: " + rowsTransformed);
                System.out.println("Total rows skipped: " + rowsSkipped);
                System.out.println("Output file path: " + outputFilePath);
            }
            catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
             }
            
        }
         else {
            System.out.println("File not found: " + filePath);
        }

    } 
}    
    



