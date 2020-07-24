package turgun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

import javax.swing.*;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class MainClass extends Application {
	 
	 public static ArrayList<Iris> irisDataset = new ArrayList<>();
	 
	 static int numberClassA = 0;
	 static int numberClassB = 0;
	 static int numberClassC = 0;
	 static int numberVeriable = 0;
	 
	 static int numberX1 = 0;
	 static int numberY1 = 0;
	 static int numberX2 = 0;
	 static int numberY2 = 0;
	 static int totalClasses ;
	// static double ProbX1=0.0000;
	 static double totalX1 =0.0;
	 static double totalY1 =0.0;
	 static double totalX2 =0.0;
	 static double totalY2 =0.0;
	 
	 static double variancX1A = 0.0;
	 static double variancX1B = 0.0;
	 static double variancX1C = 0.0;
	 static double variancY1A =0.0;
	 
	 static double variancY1B =0.0;
	 static double variancY1C =0.0;
	 static double variancX2A =0.0;
	 static double variancX2B =0.0;
	 static double variancX2C =0.0;
	 static double variancY2A =0.0;
	 static double variancY2B =0.0;
	 static double variancY2C =0.0;
	 
	 
	 
	 static double totalX1B =0.0;
	 static double totalY1B =0.0;
	 static double totalX2B =0.0;
	 static double totalY2B =0.0;

	 static double totalX1C =0.0;
	 static double totalY1C =0.0;
	 static double totalX2C =0.0;
	 static double totalY2C =0.0;
	 
	 static double varX1 = 0.0;
	 static double varY1 = 0.0;
	 static double varX2 = 0.0;
	 static double varY2 = 0.0;
	 public static ArrayList<Iris> getIrisDataList(File file) {
       

        try {
            Scanner scan = new Scanner(file,StandardCharsets.UTF_8.name());
            String[] irisInfo;

            while (scan.hasNextLine()) {
                irisInfo = scan.nextLine().split(" ");
                //System.out.println(irisInfo[0]+" "+irisInfo[2]);
                IrisType irisType;
                numberVeriable++;
                totalClasses++;
                switch (irisInfo[4]) {
                    case "-1":
                        irisType = IrisType.Versicolor;
                        numberClassA++;
                        numberX1++;
                        numberY1++;
                        numberX2++;
                        numberY2++;
                        totalX1 = totalX1+Double.parseDouble(irisInfo[0]);
                        totalY1 = totalY1+Double.parseDouble(irisInfo[1]);
                        totalX2 = totalX2+Double.parseDouble(irisInfo[2]);
                        totalY2 = totalY2+Double.parseDouble(irisInfo[3]);
                        
                        // calculet variance 
                        variancX1A += Math.pow((Double.parseDouble(irisInfo[0])-(totalX1/numberClassA)),2);
                        variancY1A += Math.pow((Double.parseDouble(irisInfo[1])-(totalY1/numberClassA)),2);
                        variancX2A += Math.pow((Double.parseDouble(irisInfo[2])-(totalX2/numberClassA)),2);
                        variancY2A += Math.pow((Double.parseDouble(irisInfo[3])-(totalY2/numberClassA)),2);
                      //  variancX1A = Double.parseDouble(irisInfo[0])-totalX1/numberClassA
                        //System.out.println("Class A");
                        break;
                    case "0":
                        irisType = IrisType.Virginca;
                        numberClassB++;
                        totalX1B = totalX1B + Double.parseDouble(irisInfo[0]);
                        totalY1B = totalY1B + Double.parseDouble(irisInfo[1]);
                        totalX2B = totalX2B + Double.parseDouble(irisInfo[2]);
                        totalY2B = totalY2B + Double.parseDouble(irisInfo[1]);
                        //System.out.println("Class B");
                        // calculet variance 
                        variancX1B += Math.pow((Double.parseDouble(irisInfo[0])-(totalX1B/numberClassB)),2);
                        variancY1B += Math.pow((Double.parseDouble(irisInfo[1])-(totalY1B/numberClassB)),2);
                        variancX2B += Math.pow((Double.parseDouble(irisInfo[2])-(totalX2B/numberClassB)),2);
                        variancY2B += Math.pow((Double.parseDouble(irisInfo[3])-(totalY2B/numberClassB)),2);
                        break;
                    case "1":
                        default: irisType = IrisType.Setosa;
                        numberClassC++;
                        totalX1C = totalX1C + Double.parseDouble(irisInfo[0]);
                        totalY1C = totalY1C + Double.parseDouble(irisInfo[1]);
                        totalX2C = totalX2C + Double.parseDouble(irisInfo[2]);
                        totalY2C = totalY2C + Double.parseDouble(irisInfo[1]);

                        variancX1C += Math.pow((Double.parseDouble(irisInfo[0])-(totalX1C/numberClassC)),2);
                        variancY1C += Math.pow((Double.parseDouble(irisInfo[1])-(totalY1C/numberClassC)),2);
                        variancX2C += Math.pow((Double.parseDouble(irisInfo[2])-(totalX2C/numberClassC)),2);
                        variancY2C += Math.pow((Double.parseDouble(irisInfo[3])-(totalY2C/numberClassC)),2);
                        // System.out.println("Class C");
                        break;
                }

                irisDataset.add(new Iris(
                        Double.parseDouble(irisInfo[0]),
                        Double.parseDouble(irisInfo[1]),
                        Double.parseDouble(irisInfo[2]),
                        Double.parseDouble(irisInfo[3]),
                        irisType
                ));
            }
            scan.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        return irisDataset;
    }
	 @Override public void start(Stage stage) {
	        stage.setTitle("Soft Computing by TUERGAN");
	        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
	        final NumberAxis yAxis = new NumberAxis(0, 6, 1);        
	        final ScatterChart<Number,Number> sc = new
	            ScatterChart<Number,Number>(xAxis,yAxis);
	        xAxis.setLabel("Sepal Length");                
	        yAxis.setLabel("Sepal Width");
	        sc.setTitle("Iris Data");
	    	
	        XYChart.Series<Number,Number> series1 = new XYChart.Series<Number,Number>();
	        series1.setName("Versicolor");
	        XYChart.Series<Number,Number> series2 = new XYChart.Series<Number,Number>();
	        series2.setName("Virginca");
	        XYChart.Series<Number,Number> series3 = new XYChart.Series<Number,Number>();
	        series3.setName("Setosa");
	        
	        
	        File file = new File("iris.txt");
	        try {
	            Scanner scan = new Scanner(file);
	            String[] irisInfo;
	            while (scan.hasNextLine()) {
	                irisInfo = scan.nextLine().split(" ");
	                switch (irisInfo[4]) {
					case "-1":
		    	        series1.getData().add(new XYChart.Data<Number,Number>(Double.parseDouble(irisInfo[0]), Double.parseDouble(irisInfo[1])));
						break;
					case "0":
		    	        series2.getData().add(new XYChart.Data<Number,Number>(Double.parseDouble(irisInfo[0]), Double.parseDouble(irisInfo[1])));
						break;
					case "1":
		    	        series3.getData().add(new XYChart.Data<Number,Number>(Double.parseDouble(irisInfo[0]), Double.parseDouble(irisInfo[1])));
						break;
					}
	            }
	        } catch (Exception e) {
	            e.getStackTrace();
	        }
	        
	        
	        sc.getData().addAll(series1, series2,series3);
	        Scene scene  = new Scene(sc, 1000, 600);
	        stage.setScene(scene);
	        stage.show();
	 		}

	    public static void main(String[] args) {
	        launch(args);
	        
	    	File file = new File("iris.txt");
	        getIrisDataList(file);
	        
			  System.out.println("The Navie Bayes Classifier \n");
			  System.out.println("Attirbute	"+"Iris-setosa\t"+"Iris-versicolor\t"+"\tIris-verginica");
			  System.out.println("Probability\t"+(float)((float)numberClassA/(float)totalClasses)+"\t"+(float)((float)numberClassB/(float)totalClasses)+"\t"+(float)((float)numberClassC/(float)totalClasses)+"\t");
			  System.out.println("===============================================================================\n");
			  System.out.println("Sepal length");
			  System.out.println("mean\t"+totalX1/numberClassA+"\t"+totalX1/numberClassB+"\t"+totalX1/numberClassC);
			  System.out.println("variance\t"+variancX1A+"\t"+variancX1B+"\t"+variancX1C);
			  System.out.println("std.dev.\t"+variancX1A/(totalClasses-1)+"\t"+variancX1B/(totalClasses-1)+"\t"+variancX1C/(totalClasses-1));
			  System.out.println("weight sum\t"+numberClassA+"			\t"+numberClassB+"			\t"+numberClassC);
			
			  System.out.println("\nSepal width");
			  System.out.println("mean\t"+totalY1/numberClassA+"\t"+totalY1/numberClassB+"\t"+totalY1/numberClassC);
			  System.out.println("variance\t"+variancY1A+"\t"+variancY1B+"\t"+variancY1C);
			  System.out.println("std.dev.\t"+variancY1A/(totalClasses-1)+"\t"+variancY1B/(totalClasses-1)+"\t"+variancY1C/(totalClasses-1));
			  System.out.println("weight sum\t"+numberClassA+"			\t"+numberClassB+"			\t"+numberClassC);
			
			  System.out.println("\nPetal length");
			  System.out.println("mean\t"+totalX2/numberClassA+"\t"+totalX2/numberClassB+"\t"+totalX2/numberClassC);
			  System.out.println("variance\t"+variancX2A+"\t"+variancX2B+"\t"+variancX2C);
			  System.out.println("std.dev.\t"+variancX2A/(totalClasses-1)+"\t"+variancX2B/(totalClasses-1)+"\t"+variancX2C/(totalClasses-1));
			  System.out.println("weight sum\t"+numberClassA+"			\t"+numberClassB+"			\t"+numberClassC);
			  
			  System.out.println("\nPetal width");
			  System.out.println("mean\t"+totalY2/numberClassA+"\t"+totalY2/numberClassB+"\t"+totalY2/numberClassC);
			  System.out.println("variance\t"+variancY2A+"\t"+variancY2B+"\t"+variancY2C);
			  System.out.println("std.dev.\t"+variancY2A/(totalClasses-1)+"\t"+variancY2B/(totalClasses-1)+"\t"+variancY2C/(totalClasses-1));
			  System.out.println("weight sum\t"+numberClassA+"			\t"+numberClassB+"			\t"+numberClassC);
			  System.out.println("\n KNN Algorithm Application \n");
			  
	    	float sepal_Length,sepal_Width,petal_Length,petal_Width;
	    	
	    	Scanner sl = new Scanner(System.in);
	    	Scanner sw = new Scanner(System.in);
	    	Scanner pl = new Scanner(System.in);
	    	Scanner pw = new Scanner(System.in);
	    	Scanner kValue = new Scanner(System.in);
	    	int k = 3;
	        

		       // irisDataset 
	        KNN knn = new KNN();
	        // Take Kavalue and Iris data from keyboard
		
	        do {
	        	System.out.println("Enter a new Iris Data:\n");
		    	System.out.println("Enter K value :");
	        	 k = kValue.nextInt();
	        	 if(k == 0)
	        		 break;
		    	System.out.println("Enter Sepal Length : ");
		    	sepal_Length = sl.nextFloat();
		    	System.out.println("Enter Sepal Width :");
		    	sepal_Width = sw.nextFloat();
		    	System.out.println("Enter Petal Length :");
		    	petal_Length = pl.nextFloat();
		    	System.out.println("Enter Petal Width :");
		    	petal_Width = pl.nextFloat();

	        	 
	 	        Iris newIris = new Iris(sepal_Length,sepal_Width,petal_Length,petal_Width,null);
		        newIris.setIrisType(knn.getIrisType(k, irisDataset, newIris));
			       //System.out.println("K is : "+k);
			        System.out.println(newIris.toString()+"\n");
	        }while(k!= 0);
	        
	        System.out.println(" \nFor Test Data Sets \n ");
	        System.out.println("Enter K Value for Test Data Sets:");
	        File testFile = new File("test.txt");
	        k = kValue.nextInt();
	        getIrisDataList(testFile);
	        
	        // reading line until test file 
	        try {
	            Scanner scanNew = new Scanner(testFile);
	            String[] irisInfo;
	            while (scanNew.hasNextLine()) {
	                irisInfo = scanNew.nextLine().split(" ");
	                switch (irisInfo[4]) {
					case "null":
						double a,b,c,d;
						a = Double.parseDouble(irisInfo[0]);
						b = Double.parseDouble(irisInfo[1]);
						c = Double.parseDouble(irisInfo[2]);
						d = Double.parseDouble(irisInfo[3]);
						
						Iris newIrisTrain = new Iris(a,b,c,d,null);
						newIrisTrain.setIrisType(knn.getIrisType(k, irisDataset, newIrisTrain));
						// System.out.println("K value is : "+ktrainValue);
					   System.out.println(newIrisTrain.toString());
						//System.out.println(a+" "+b+" "+c+" "+d);
		    	       // series1.getData().add(new XYChart.Data<Number,Number>(Double.parseDouble(irisInfo[0]), Double.parseDouble(irisInfo[1])));
						break;
					case "0":
		    	       // series2.getData().add(new XYChart.Data<Number,Number>(Double.parseDouble(irisInfo[0]), Double.parseDouble(irisInfo[1])));
						break;
					case "1":
		    	        //series3.getData().add(new XYChart.Data<Number,Number>(Double.parseDouble(irisInfo[0]), Double.parseDouble(irisInfo[1])));
						break;
					}
	            }
	        } catch (Exception e) {
	            e.getStackTrace();
	        }
	    }
}
	    

