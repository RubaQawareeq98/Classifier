/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
//import static java.awt.Color;
import java.awt.event.*;

import static java.awt.Color.*;

/**
 *
 * @author hp
 */
public class mainFrame extends javax.swing.JFrame {
    private Perceptron squarePerceptron;
    private Perceptron trianglePerceptron;
    private Perceptron circlePerceptron;
    private  Perceptron rhombousPerceptron;
    private  Perceptron [] perceptron = new Perceptron[4];
    private int i=0;
    private ArrayList <shapePoint> points = new ArrayList<>();
    private Shape currentShape;
    public int iteration;
    public double learning;
    int[] classNum = new int[4]; // Creates an array of size 4

    private ArrayList <String> classes = new ArrayList<>();
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        canvas1.addMouseListener(new CanvasMouseListener());
        square.addActionListener(new ShapeButtonListener(Shape.SQUARE));
        triangle.addActionListener(new ShapeButtonListener(Shape.TRIANGLE));
        circle.addActionListener(new ShapeButtonListener(Shape.CIRCLE));
        rhombous.addActionListener(new ShapeButtonListener(Shape.RHOMBOUS));
        rhombous1.addActionListener(new ShapeButtonListener(Shape.TEST));
         for (int i = 0; i < classNum.length; i++) {
       classNum[i] = 0; // Sets each element to 0
    }
         classesList.setLayout(new BoxLayout(classesList, BoxLayout.Y_AXIS));
//        initComponents();
    }
    public enum Shape {SQUARE, TRIANGLE, CIRCLE, RHOMBOUS, TEST}
    ArrayList <Integer> cls = new ArrayList<>();
    private class CanvasMouseListener extends MouseAdapter {
        shapePoint point;
        @Override
        public void mousePressed(MouseEvent e) {
            if (currentShape != null) {
                Graphics g = canvas1.getGraphics();
                switch (currentShape) {
                    case SQUARE:
                        g.setColor(RED);
                        g.fillRect(e.getX(), e.getY(), 10, 10);
                        if(classNum[0]==0){
                        classes.add("SQUARE");
                        classNum[0]=1;
                            perceptron[i++] = squarePerceptron;
                        }
                        point=new shapePoint(e.getX(),e.getY(),Shape.SQUARE);
                        points.add(point);


                        break;
                    case TRIANGLE:
                        g.setColor(GREEN);
                        int[] xPoints = {e.getX(), e.getX() + 12, e.getX() + 6};
                        int[] yPoints = {e.getY() + 12, e.getY() + 12, e.getY()};
                        g.fillPolygon(xPoints, yPoints, 3);
                        if(classNum[1]==0){
                        classes.add("TRIANGLE");
                        classNum[1]=1;
                        perceptron[i++] = trianglePerceptron;
                        }
                        point=new shapePoint(e.getX(),e.getY(),Shape.TRIANGLE);
                        points.add(point);

                        break;
                    case CIRCLE:
                        g.setColor(YELLOW);
                        g.fillOval(e.getX(), e.getY(), 10, 10);
                        if(classNum[2]==0){
                        classes.add("CIRCLE");
                        classNum[2]=1;
                        perceptron[i++] = circlePerceptron;
                        }
                        point=new shapePoint(e.getX(),e.getY(),Shape.CIRCLE);
                        points.add(point);

                        break;
                    case RHOMBOUS:
                        g.setColor(blue);
                        int[] xPointsRhombus = {e.getX(), e.getX() + 6, e.getX(), e.getX() - 6};
                        int[] yPointsRhombus = {e.getY(), e.getY() + 6, e.getY() + 12, e.getY() + 6};
                        g.fillPolygon(xPointsRhombus, yPointsRhombus, 4);
                        if(classNum[3]==0){
                        classes.add("RHOMBOUS");
                        classNum[3]=1;
                            perceptron[i++] = rhombousPerceptron;

                        }
                        point=new shapePoint(e.getX(),e.getY(),Shape.RHOMBOUS);
                        points.add(point);
                        break;

                    case TEST:
                        System.out.println("Test");
                        g.setColor(BLACK);
                        g.fillOval(e.getX(), e.getY(), 15, 15);

                        shapePoint point=new shapePoint(e.getX(),e.getY(),Shape.TEST);


                        for(int j=0 ;j<i; j++){
                            perceptron[j].predict(point,g);
                            if(perceptron[j].testedValue == 1){
                                JOptionPane.showMessageDialog(null,"It Class "+j+" : "+ classes.get(j));
                                point.setType(Shape.valueOf(classes.get(j)));
                                cls.add(j);
                                break;
                            }
                        }
                        System.out.println("point "+point.getType());
                            if(String.valueOf(point.getType()).equals("TEST")) {
                                double max = perceptron[0].calculateBigX(point);
                                int ind = 0;
                                for (int j = 0; j < i; j++) {
                                    if (max < perceptron[j].calculateBigX(point)) {
                                        max = perceptron[j].calculateBigX(point);
                                        ind = j;
                                    }

                                }

                                JOptionPane.showMessageDialog(null, "It Class " + ind + " : " + classes.get(ind));

                            }
                        break;


                }
            }
        }
    }
    private class ShapeButtonListener implements ActionListener {
        private Shape shape;

        public ShapeButtonListener(Shape shape) {
            this.shape = shape;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            currentShape = shape;
        }
    }
    public static class shapePoint{
        private int x;
        private int y;
        private Shape type;

        public shapePoint(int x, int y, Shape type){
            this.x=x;
            this.y=y;
            this.type=type;
        }
         public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Shape getType() {
            return type;
        }

        public void setType(Shape shape) {
            this.type = shape;
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        square = new javax.swing.JButton();
        circle = new javax.swing.JButton();
        triangle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        performance = new javax.swing.JLabel();
        iterations = new javax.swing.JTextField();
        learningRate = new javax.swing.JTextField();
        SAVE = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        classesList = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        learn = new javax.swing.JButton();
        Train = new javax.swing.JButton();
        rhombous = new javax.swing.JButton();
        rhombous1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(216, 243, 220));

        canvas1.setBackground(new java.awt.Color(255, 255, 255));

        square.setBackground(new java.awt.Color(27, 67, 50));
        square.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        square.setForeground(new java.awt.Color(255, 255, 255));
        square.setText("SQUARE");
        square.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareActionPerformed(evt);
            }
        });

        circle.setBackground(new java.awt.Color(27, 67, 50));
        circle.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        circle.setForeground(new java.awt.Color(255, 255, 255));
        circle.setText("CIRCLE");
        circle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleActionPerformed(evt);
            }
        });

        triangle.setBackground(new java.awt.Color(27, 67, 50));
        triangle.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        triangle.setForeground(new java.awt.Color(255, 255, 255));
        triangle.setText("TRIANGLE");
        triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Learning rate:");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setText("Maximum iteration:");

        performance.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        performance.setText("Performance & Accuracy");

        iterations.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N

        learningRate.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N

        SAVE.setBackground(new java.awt.Color(27, 67, 50));
        SAVE.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        SAVE.setForeground(new java.awt.Color(255, 255, 255));
        SAVE.setText("SAVE");
        SAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SAVEMouseClicked(evt);
            }
        });
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });

        RESET.setBackground(new java.awt.Color(27, 67, 50));
        RESET.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        RESET.setForeground(new java.awt.Color(255, 255, 255));
        RESET.setText("RESET");
        RESET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RESETMouseClicked(evt);
            }
        });
        RESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESETActionPerformed(evt);
            }
        });

        classesList.setBackground(new java.awt.Color(216, 243, 220));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel3.setText(" CLASSES");

        javax.swing.GroupLayout classesListLayout = new javax.swing.GroupLayout(classesList);
        classesList.setLayout(classesListLayout);
        classesListLayout.setHorizontalGroup(
            classesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classesListLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        classesListLayout.setVerticalGroup(
            classesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classesListLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        learn.setBackground(new java.awt.Color(27, 67, 50));
        learn.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        learn.setForeground(new java.awt.Color(255, 255, 255));
        learn.setText("LEARN");
        learn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                learnMouseClicked(evt);
            }
        });
        learn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnActionPerformed(evt);
            }
        });

        Train.setBackground(new java.awt.Color(27, 67, 50));
        Train.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        Train.setForeground(new java.awt.Color(255, 255, 255));
        Train.setText("TRAINING");

        Train.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrainMouseClicked(evt);
            }

            private void TrainMouseClicked(MouseEvent evt) {
                Graphics g = canvas1.getGraphics();

                double performance = 0;
                for(int j=0 ;j<i; j++){
                    perceptron[j]=new Perceptron(2,learning);
                  performance =   perceptron[j].trainPerceptron(points,iteration, classes.get(j),g);

                }
                //
                // set performance value to label


                System.out.println("Start learning");

            }
        });
        Train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainActionPerformed(evt);
            }


            private void TrainActionPerformed(ActionEvent evt) {
            }
        });


        rhombous.setBackground(new java.awt.Color(27, 67, 50));
        rhombous.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        rhombous.setForeground(new java.awt.Color(255, 255, 255));
        rhombous.setText("RHOMBOUS");
        rhombous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rhombousActionPerformed(evt);
            }
        });

        rhombous1.setBackground(new java.awt.Color(27, 67, 50));
        rhombous1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        rhombous1.setForeground(new java.awt.Color(255, 255, 255));
        rhombous1.setText("TEST");
        rhombous1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rhombous1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(learningRate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RESET, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Train, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(152, 152, 152))
                    .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(classesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(learn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(square, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(triangle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(circle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rhombous, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rhombous1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(square, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(triangle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(circle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rhombous, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(rhombous1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(classesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(learn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(learningRate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(RESET, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Train, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void learnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_learnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_learnActionPerformed

    private void learnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_learnMouseClicked
        // TODO add your handling code here:
        for (int i = 0; i < classes.size(); i++) {

            JTextArea label = new JTextArea("CLASS" + i+ " is " + classes.get(i));
            label.setFont(new Font("Segoe Print", Font.PLAIN, 14));
            //label.setHorizontalAlignment(SwingConstants.CENTER);
            classesList.add(label);
        }
        classesList.revalidate();
        classesList.repaint();
    }//GEN-LAST:event_learnMouseClicked

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RESETActionPerformed

    private void RESETMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RESETMouseClicked
        // TODO add your handling code here:
        Graphics g = canvas1.getGraphics();
        g.setColor(canvas1.getBackground()); // Set the color to the background color of the canvas
        g.fillRect(0, 0, canvas1.getWidth(), canvas1.getHeight());
        points.clear();
        iterations.setText("");
        learningRate.setText("");
        classesList.removeAll();
        classesList.revalidate();
        classesList.repaint();
    }//GEN-LAST:event_RESETMouseClicked

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SAVEActionPerformed

    private void SAVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEMouseClicked
        // TODO add your handling code here:
        String iterationText = iterations.getText();
        String learningRateText = learningRate.getText();
        iteration=Integer.parseInt(iterationText);
        learning=Double.parseDouble(learningRateText);
        //jLabel3.setText("class1");
    }//GEN-LAST:event_SAVEMouseClicked

    private void rhombousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rhombousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rhombousActionPerformed

    private void triangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_triangleActionPerformed

    private void circleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_circleActionPerformed

    private void squareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_squareActionPerformed

    private void rhombous1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rhombous1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rhombous1ActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RESET;
    private javax.swing.JButton SAVE;
    private javax.swing.JButton Train;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton circle;
    private javax.swing.JPanel classesList;
    private javax.swing.JTextField iterations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel performance;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton learn;
    private javax.swing.JTextField learningRate;
    private javax.swing.JButton rhombous;
    private javax.swing.JButton rhombous1;
    private javax.swing.JButton square;
    private javax.swing.JButton triangle;
    // End of variables declaration//GEN-END:variables
}
