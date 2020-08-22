package cpt;


import java.io.File;


public class MyCustomFilter extends javax.swing.filechooser.FileFilter{

    @Override
    public boolean accept(File file) {
        // Limits it to only accepting csv files
         return file.isDirectory() || file.getAbsolutePath().endsWith(".csv");
    }

    @Override
    public String getDescription() {
        // Gives the description 
        return "CSV Files (*.csv)";
    }
    
}
