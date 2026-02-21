package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * The orchestrator class for the ETL (Extract, Transform, Load) process.
 * Reads data from a CSV, applies transformations via ProductTransformer, and writes to a new CSV.
 */
public class ETLPipeline {
    /**
     * The entry point of the application.
     * @param args Command line arguments (not used).
     */
    private int rowsRead = 0;
    private int rowsTransformed = 0;
    private int rowsSkipped = 0;

    public static void main(String[] args) {
        /**
         * Executes the full ETL pipeline from input file to output file.
         * @param inputPath Path to the source products.csv
         * @param outputPath Path where the transformed CSV will be saved
         */
        ETLPipeline pipeline = new ETLPipeline();
        pipeline.run("data/products.csv", "data/transformed_products.csv");
    }

    public void run(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        ProductTransformer transformer = new ProductTransformer();

        if (!inputFile.exists()) {
            System.out.println("File not found: " + inputPath);
            return;
        }

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new File(outputPath))) {

            if (!scanner.hasNextLine()) {
                System.out.println("The file is empty.");
                return;
            }

            // Write Header
            writer.println("ProductID,Name,Price,Category,PriceRange");
            scanner.nextLine(); // Skip original header

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                rowsRead++;
                
                try {
                    Product product = parseLine(line);
                    if (product != null) {
                        transformer.transform(product);
                        String range = transformer.getPriceRange(product.getPrice());
                        
                        writer.println(product.toString() + "," + range);
                        rowsTransformed++;
                    } else {
                        rowsSkipped++;
                    }
                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

            printSummary(outputPath);

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    private Product parseLine(String line) {
        String[] values = line.split(",");
        if (values.length != 4) return null;

        String id = values[0].trim();
        String name = values[1].trim();
        double price = Double.parseDouble(values[2].trim());
        String category = values[3].trim();

        return new Product(id, name, price, category);
    }

    private void printSummary(String outputPath) {
        System.out.println("Total rows read: " + rowsRead);
        System.out.println("Total rows transformed: " + rowsTransformed);
        System.out.println("Total rows skipped: " + rowsSkipped);
        System.out.println("Output file path: " + outputPath);
    }
}
