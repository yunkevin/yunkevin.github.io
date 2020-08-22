/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public class GenCsvFile {

    private String fileName;
    private FileWriter writer;
    private File csv;

    /*
     * Pre-condition: valid file path
     * Post-condition: creates/overrides a file with original file name +CONDENSED at the end
     * file will have first line declared
     */
    public GenCsvFile(String fileName) {
        this.fileName = fileName.replace(".csv", "CONDENSED.csv");

        csv = new File(this.fileName);

        try {
            writer = new FileWriter(this.fileName);

            writer.append("Bin");
            writer.append(',');
            writer.append("Data Points");
            writer.append(',');
            writer.append("Dry Bulb Average");
            writer.append(',');
            writer.append("Dew Point Average");

            writer.flush();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR_File_is_open_in_another_program");
            System.exit(0);
        }
    }

    /*
     * Pre-condition: None
     * Post-condition: New line with bins data was added to the csv file
     */
    public void addLine(Bin x) throws IOException {
        writer.append('\n');
        writer.append(x.getTempSize());
        writer.append(',');
        writer.append("" + x.getDataPoints());
        writer.append(',');
        writer.append("" + x.getDryAvg());
        writer.append(',');
        writer.append("" + x.getAvgDewPoint());

        writer.flush();

    }

    /*
     * Pre-condition: None 
     * Post-condition: File is closed, command prompt openned and had filename typed into it, waited 5 sec, command prompt closed 
     */
    public void closeWriter() throws IOException {
        writer.close();
        Runtime rt = Runtime.getRuntime();
        rt.exec("cmd.exe /c cd \\ & start cmd.exe /k \"\"" + fileName + "\"");
        try {
            Thread.sleep(5000);                 
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        rt.exec("taskkill /f /im cmd.exe");
    }
}
