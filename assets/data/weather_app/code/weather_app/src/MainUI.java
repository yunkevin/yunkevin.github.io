package cpt;


import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainUI extends javax.swing.JFrame {
    
    //Variables from User (TBD)
    private static Time time = new Time();
    String fileLocation;
    boolean celsius;
    double interval;
   
    public MainUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        selectFileButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();

        buttonGroup2.add(jRadioButton1);
        buttonGroup2.add(jRadioButton2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Weather Application");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Temperature Unit: Celsius / Farenheit:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Bin Size:");

        jRadioButton1.setText("Celsius ");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Farenheit");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField1.setText("Enter the Size of Bin");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Choose File to be Analyzed:");

        selectFileButton.setText("Select File ");
        selectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Analyze");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Select Hour & Day: ");

        jTextField2.setText("1-24");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Eg. 1-5, 6, 8, 10-12");

        jTextField3.setText("1-24");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jTextField4.setText("1-24");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });

        jTextField5.setText("1-24");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });

        jTextField6.setText("1-24");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        jTextField7.setText("1-24");
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });

        jTextField8.setText("1-24");
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });

        jRadioButton3.setText("Monday");
        jRadioButton3.setSelected(true);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Tuesday");
        jRadioButton4.setSelected(true);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("Wednesday");
        jRadioButton5.setSelected(true);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("Thursday");
        jRadioButton6.setSelected(true);
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jRadioButton7.setText("Friday");
        jRadioButton7.setSelected(true);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jRadioButton8.setText("Saturday");
        jRadioButton8.setSelected(true);
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jRadioButton9.setText("Sunday");
        jRadioButton9.setSelected(true);
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jLabel7.setText("*Note: File should be in csv format, from Enviroment Canada's website");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jRadioButton9)
                                        .addGap(168, 168, 168))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton8)
                                    .addComponent(jRadioButton7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton9))
                        .addGap(56, 56, 56)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    
    private void selectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileButtonActionPerformed
        JFileChooser fileInput = new JFileChooser();
        fileInput.setFileFilter(new MyCustomFilter());
        

        if (fileInput.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fileLocation = fileInput.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "File Selection was Succesful");
        } else {
            JOptionPane.showMessageDialog(this, "File Selection was Cancelled");
        }
    }//GEN-LAST:event_selectFileButtonActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        String temperatureUnit;
        if (jRadioButton1.isSelected() == true) {
            celsius = true;
        }
        jTextField1.setText("3");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        String temperatureUnit;
        if (jRadioButton2.isSelected() == true) {
            celsius = false;
            
        }
        jTextField1.setText("5");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        jTextField4.setText("");
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        jTextField5.setText("");
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        jTextField6.setText("");
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        jTextField7.setText("");
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        jTextField8.setText("");
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        interval = Integer.parseInt(jTextField1.getText());
        
        String mondayHour = jTextField2.getText();
        String tuesdayHour = jTextField3.getText();
        String wednesdayHour = jTextField4.getText();
        String thursdayHour = jTextField5.getText();
        String fridayHour = jTextField6.getText();
        String saturdayHour = jTextField7.getText();
        String sundayHour = jTextField8.getText();

        condenseString(mondayHour);
        condenseString(tuesdayHour);
        condenseString(wednesdayHour);
        condenseString(thursdayHour);
        condenseString(fridayHour);
        condenseString(saturdayHour);
        condenseString(sundayHour);

        setHoursToList(mondayHour, "Monday");
        setHoursToList(tuesdayHour, "Tuesday");
        setHoursToList(wednesdayHour, "Wednesday");
        setHoursToList(thursdayHour, "Thursday");
        setHoursToList(fridayHour, "Friday");
        setHoursToList(saturdayHour, "Saturday");
        setHoursToList(sundayHour, "Sunday");
        
         //ArrayList to be added to later
        ArrayList<Datapoint> Data = new ArrayList<>();
        ArrayList<Bin> Bins = new ArrayList<>();
        
        //List of Stings on file
        ArrayList<String> stringList = new ArrayList<>();
        
        //Name of the file
        String fileName = fileLocation;
        

        //Reads CSV File and converts it to an ArrayList of Strings
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
        
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                stringList.add(Arrays.toString(nextLine));
            }
        }
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
        
        // Removes all spaces from the given string in the arraylist stringList
        int count = 0;
        for (String x : stringList) {
            stringList.set(count, x.replaceAll(" ", ""));
            count++;
        }

        //read all strings starting from the 17th line of the Arraylist (Line 17 of the csv)
        for (int i = 17; i < stringList.size(); i++) {
            //Checks if Line Holds Data, then creates datapoint to fit line
            if (getRelHum(stringList.get(i)) != -1) {
                try {
                    Data.add(new Datapoint(getDate(stringList.get(i)), getHour(stringList.get(i)), getDryBulb(stringList.get(i)), getDewPoint(stringList.get(i))));
                } catch (ParseException ex) {
                    
                }
            }
        }

       
        
        //Makes sure interval is above or equal to zero
        if (interval < 0){
            interval = 0-interval;
        }

        //Adds all datapoints to bins
        if (celsius) {
            createAddCelsius(Bins, Data, interval);
        } else {
            createAddFahrenheit(Bins, Data, interval);
        }

        //What do you think it does?
        removeEmpties(Bins);

        
        //Creates a new csv file 
        GenCsvFile Csv = new GenCsvFile(fileName);
        
        //Reads all bins starting from the last one and working backwards
        for (int i = Bins.size() - 1; i >= 0; i--) {
            try {
                //Adds line to csv
                Csv.addLine(Bins.get(i));
            } catch (IOException ex) {
                
            }
        }
        try {
            //Finishes writting to the file and opens the new csv
            Csv.closeWriter();
        } catch (IOException ex) {
            
        }
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        String mondayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Monday");
        } else {
            time.setDayInactive("Monday");
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        String tuesdayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Tuesday");
        } else {
            time.setDayInactive("Tuesday");
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        String wednesdayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Wednsday");
        } else {
            time.setDayInactive("Wednsday");
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        String thursdayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Thursday");
        } else {
            time.setDayInactive("Thursday");
        }
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        String fridayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Friday");
        } else {
            time.setDayInactive("Friday");
        }
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        String saturdayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Saturday");
        } else {
            time.setDayInactive("Saturday");
        }
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        String sundayState;
        if (jRadioButton3.isSelected() == true) {
            time.setDayActive("Sunday");
        } else {
            time.setDayInactive("Sunday");
        }
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    public static void condenseString(String day) {
        day.replaceAll(" ", "");
    }

    public static void setHoursToList(String hours, String day) {
        ArrayList<String> hourList = new ArrayList<>();
        int firstIndex = 0;

        if (hours.indexOf(",") == -1) {
            hourList.add(hours);
        } else {
            for (int i = 0; i < hours.length(); i++) {
                if (hours.charAt(i) == ',') {
                    if (firstIndex == 0) {
                        hourList.add(hours.substring(0, i));
                        firstIndex = i;
                    } else {
                        hourList.add(hours.substring(firstIndex, i));
                        firstIndex = i;
                    }
                }
            }
        }
        setHour(hourList, day);

    }

    public static void setHour(ArrayList<String> hourList, String day) {

        for (String x : hourList) {
            if (x.contains("-")) {
                int max = Integer.parseInt(x.substring(x.indexOf("-") + 1));
                int min = Integer.parseInt(x.substring(0, x.indexOf("-")));

                for (int i = min; i <= max; i++) {
                    time.setDayHourActive(day, i-1);
                }
            } else {
                time.setDayHourActive(day, Integer.parseInt(x)-1);
            }
        }
    }
    
    /*
     * Pre-condition: Double interval is possitive
     * Post-condition: All Datapoint in the array of Datapoint have been added to a Bin on the arraylist Bins, or have created new Bin to fit them
     */
    public static void createAddCelsius(ArrayList<Bin> Bins, ArrayList<Datapoint> Data, double interval) {
        Bin baseCase = new Bin(0, interval);
        Bins.add(baseCase);
        for (Datapoint test : Data) {
            //checks if the date and hour are specified as useable
            if (time.checkActive(test.getDayOfWeek(), test.getHour())) {
                //If the selected Datapoint can fit into a bin, it is added
                if (CanAdd(Bins, test)) {
                    for (Bin x : Bins) {
                        if (x.canAdd(test)) {
                            x.addDataPoint(test);
                            break;
                        }
                    }

                    //Since the datapoint cannot be added to an existing bin, we must create new bins
                    //If the temp of the datapoint is above 0, bins are added upward until the datapoint fits the last bin
                } else if (test.getDryBulb() >= 0) {
                    int count = -(Bins.indexOf(baseCase) - (Bins.size()));//Length of possitive Data
                    while (true) {
                        Bins.add(new Bin(interval * count, interval * (count + 1)));
                        if (Bins.get((Bins.indexOf(baseCase) + count)).canAdd(test)) {
                            Bins.get((Bins.indexOf(baseCase) + count)).addDataPoint(test);
                            break;
                        } else {
                            count++;
                        }
                    }
                    // if the temperature is below zero, adds bins to the begining, decreasing temperature until the selected datapoint fits    
                } else {
                    int count = Bins.indexOf(baseCase);//length of negative data
                    while (true) {
                        Bins.add(0, new Bin(-interval * (count + 1), -interval * count));
                        if (Bins.get(0).canAdd(test)) {
                            Bins.get(0).addDataPoint(test);
                            break;
                        } else {
                            count++;
                        }
                    }
                }
            }
        }
    }

    /*
     * Pre-condition: Double interval is possitive
     * Post-condition: All Datapoint in the array of Datapoint have been converted to fahrenheit and added to a Bin on the arraylist Bins, or have created new Bin to fit them
     */
    public static void createAddFahrenheit(ArrayList<Bin> Bins, ArrayList<Datapoint> Data, double interval) {
        Bin baseCase = new Bin(0, interval);
        Bins.add(baseCase);
        for (Datapoint test : Data) {
            //converts temperature to fahrenheit
            test.setToFahrenheit();
            //if the time of day is availabe, then is will add it to abin
            if (time.checkActive(test.getDayOfWeek(), test.getHour())) {
                //adds datapoint to an available bin
                if (CanAdd(Bins, test)) {
                    for (Bin x : Bins) {
                        if (x.canAdd(test)) {
                            x.addDataPoint(test);
                            break;
                        }
                    }

                    //Since the datapoint cannot be added to an existing bin, we must create new bins
                    //If the temp of the datapoint is above 0, bins are added upward until the datapoint fits the last bin
                } else if (test.getDryBulb() >= 0) {
                    int count = -(Bins.indexOf(baseCase) - (Bins.size()));//Length of possitive Data
                    while (true) {
                        Bins.add(new Bin(interval * count, interval * (count + 1)));
                        if (Bins.get((Bins.indexOf(baseCase) + count)).canAdd(test)) {
                            Bins.get((Bins.indexOf(baseCase) + count)).addDataPoint(test);
                            break;
                        } else {
                            count++;
                        }
                    }
                    // if the temperature is below zero, adds bins to the begining, decreasing temperature until the selected datapoint fits    
                } else {
                    int count = Bins.indexOf(baseCase);//length of negative data
                    while (true) {
                        Bins.add(0, new Bin(-interval * (count + 1), -interval * count));
                        if (Bins.get(0).canAdd(test)) {
                            Bins.get(0).addDataPoint(test);
                            break;
                        } else {
                            count++;
                        }
                    }
                }
            }
        }
    }

    /*
     * Pre-condition: None
     * Post-condition: Boolean relating to whether or not Datapoint can be added to a Bin on ArrayList x
     */
    public static boolean CanAdd(ArrayList<Bin> x, Datapoint z) {
        return x.stream().anyMatch((y) -> (y.canAdd(z)));
    }

    /*
     * Pre-condition: String contains at least 11 commas
     * Post-condition: returns a double parsed from substring between the tenth comma and eleventh comma, otherwise returns -1
     */
    public static double getRelHum(String x) {
        int commaCounter = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ',') {
                commaCounter++;
            }
            if (commaCounter == 10) {
                firstIndex = i + 1;
                commaCounter++;
            }
            if (commaCounter == 12) {
                secondIndex = i;
                break;
            }
        }
        if (firstIndex == 0) {
            return -1;
        }
        return Double.parseDouble(x.substring(firstIndex, secondIndex));
    }

    /*
     * Pre-condition: String contains at least 10 charicters
     * Post-condition: returns a substring between 2nd and 11th charicter
     */
    public static String getDate(String full) {
        return full.substring(1, 11);
    }

    /*
     * Pre-condition: String must have at least 12 charicters
     * Post-condition: returns an intiger parsed from substring between the 11th charicter and 13th charicter
     */
    public static int getHour(String x) {
        return Integer.parseInt(x.substring(11, 13));
    }

    /*
     * Pre-condition: String contains at least 9 commas
     * Post-condition: returns a double parsed from substring between the eighth comma and nineth comma
     */
    public static double getDewPoint(String x) {
        int commaCounter = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ',') {
                commaCounter++;
            }
            if (commaCounter == 8) {
                firstIndex = i + 1;
                commaCounter++;
            }
            if (commaCounter == 10) {
                secondIndex = i;
                break;
            }
        }

        return Double.parseDouble(x.substring(firstIndex, secondIndex));

    }

    /*
     * Pre-condition: String contains at least 7 commas
     * Post-condition: returns a double parsed from substring between the sixth comma and seventh comma
     */
    public static double getDryBulb(String x) {
        int commaCounter = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ',') {
                commaCounter++;
            }
            if (commaCounter == 6) {
                firstIndex = i + 1;
                commaCounter++;
            }
            if (commaCounter == 8) {
                secondIndex = i;
                break;
            }
        }
        return Double.parseDouble(x.substring(firstIndex, secondIndex));
    }

    /*
     * Pre-condition: ArrayList of Bin must exist, and may have one or more empty Bin
     * Post-condition: ArrayList will no longer contain any Bin with no Datapoint
     */
    public static void removeEmpties(ArrayList<Bin> Bins) {
        ArrayList<Bin> toBeRemoved = new ArrayList<>();
        for (Bin x : Bins) {
            if (x.getDataPoints() == 0) {
                toBeRemoved.add(x);
            }
        }
        for (Bin x : toBeRemoved) {
            Bins.remove(x);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JButton selectFileButton;
    // End of variables declaration//GEN-END:variables
}
