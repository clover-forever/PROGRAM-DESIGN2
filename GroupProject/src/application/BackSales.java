package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class BackSales extends Application {
	@Override
	
	public void start(Stage primaryStage) throws Exception{
		init(primaryStage);
	}
	private void init(Stage primaryStage) {
		
			
		
			Scanner input=new Scanner(System.in);
			System.out.print("請輸入要以何種品項為基準看銷售數量比較 (ex:烤布蕾) :");
			
			String food=input.next();
			int cnta=0,cntb=0,cntc=0,cntd=0,cnte=0,cntf=0,cntg=0,cnth=0,cnti=0;
			float suma[]=new float[100];
			float sumb[]=new float[100];
			float sumc[]=new float[100];
			float sumd[]=new float[100];
			float sume[]=new float[100];
			float sumf[]=new float[100];
			float sumg[]=new float[100];
			float sumh[]=new float[100];
			float sumi[]=new float[100];
			String aword,awordb,aworddd;
			String awordd;
			String awordc;
			String awordcc;
			HBox root=new HBox();
			Scene scene=new Scene(root,520,430);
			CategoryAxis xAxis=new CategoryAxis();
			xAxis.setLabel("品項");
			NumberAxis yAxis=new NumberAxis();
			yAxis.setLabel("各品項銷售數量比較，以小數點方式呈現");
			LineChart<String,Number> lineChart=new LineChart<String,Number>(xAxis,yAxis);
			lineChart.setTitle("各品項的銷售數量比較，以 "+food+" 的銷售數量為基準");
			root.getChildren().add(lineChart);
			XYChart.Series<String, Number> data=new XYChart.Series<>();
			try {
				Scanner scanner=new Scanner(new FileInputStream("d:\\order.txt"));
				while(scanner.hasNextLine()){ 
					if(scanner.hasNext()==false) break;
					aword = scanner.next();
					awordb = scanner.next();
					//awordc = scanner.next();
					awordcc=scanner.next();
					if(aword.equals("蘋果派")) {
						suma[cnta]+=Float.parseFloat(awordb);
						cnta++;
					}
					if(aword.equals("檸檬塔")) {
						sumb[cntb]+=Float.parseFloat(awordb);
						cntb++;
					}
					if(aword.equals("國王派")) {
						sumc[cntc]+=Float.parseFloat(awordb);
						cntc++;
					}
					if(aword.equals("布朗尼")) {
						sumd[cntd]+=Float.parseFloat(awordb);
						cntd++;
					}
					if(aword.equals("千層蛋糕")) {
						sume[cnte]+=Float.parseFloat(awordb);
						cnte++;
					}
					if(aword.equals("瑪德蓮")) {
						sumf[cntf]+=Float.parseFloat(awordb);
						cntf++;
					}
					if(aword.equals("閃電泡芙")) {
						sumg[cntg]+=Float.parseFloat(awordb);
						cntg++;
					}
					if(aword.equals("舒芙蕾")) {
						sumh[cnth]+=Float.parseFloat(awordb);
						cnth++;
					}
					if(aword.equals("烤布蕾")) {
						sumi[cnti]+=Float.parseFloat(awordb);
						cnti++;
					}
						
				}
				if(food.equals("蘋果派")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cnta;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum1+" 個");
					if(sum1==0) {
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",0));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum1));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum1));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum1));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum1));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum1));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum1));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum1));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum1));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
				}
				else if(food.equals("檸檬塔")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cntb;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum2+" 個");
					if(sum2==0) {
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum2));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum2));
						
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum2));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum2));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum2));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum2));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum2));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum2));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum2));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("國王派")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cntc;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum3+" 個");
					if(sum3==0) {
						data.getData().add(new XYChart.Data<String,Number>("國王派",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else{
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum3));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum3));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum3));
						
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum3));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum3));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum3));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum3));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum3));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum3));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("布朗尼")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cntd;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum4+" 個");
					if(sum4==0) {
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum4));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum4));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum4));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum4));
						
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum4));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum4));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum4));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum4));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum4));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("千層蛋糕")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cnte;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum5+" 個");
					if(sum5==0) {
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum5));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum5));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum5));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum5));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum5));
						
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum5));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum5));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum5));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum5));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("瑪德蓮")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cntf;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum6+" 個");
					if(sum6==0) {
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum6));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum6));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum6));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum6));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum6));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum6));
						
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum6));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum6));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum6));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("閃電泡芙")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cntg;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum7+" 個");
					if(sum7==0) {
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum7));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum7));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum7));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum7));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum7));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum7));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum7));
						
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum7));
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum7));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("舒芙蕾")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cnth;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum8+" 個");
					if(sum8==0) {
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum8));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum8));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum8));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum8));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum8));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum8));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum8));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum8));
						
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum8));
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				else if(food.equals("烤布蕾")) {
					float sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0,sum8=0,sum9=0;
					for(int i=0;i<cnti;i++) {
						sum1+=suma[i];
						sum2+=sumb[i];
						sum3+=sumc[i];
						sum4+=sumd[i];
						sum5+=sume[i];
						sum6+=sumf[i];
						sum7+=sumg[i];
						sum8+=sumh[i];
						sum9+=sumi[i];
					}
					System.out.println(food+" 總共賣了 "+sum9+" 個");
					if(sum9==0) {
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",0));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8));
						
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					else {
						data.getData().add(new XYChart.Data<String,Number>("烤布蕾",sum9/sum9));
						data.getData().add(new XYChart.Data<String,Number>("蘋果派",sum1/sum9));
						data.getData().add(new XYChart.Data<String,Number>("檸檬塔",sum2/sum9));
						data.getData().add(new XYChart.Data<String,Number>("國王派",sum3/sum9));
						data.getData().add(new XYChart.Data<String,Number>("布朗尼",sum4/sum9));
						data.getData().add(new XYChart.Data<String,Number>("千層蛋糕",sum5/sum9));
						data.getData().add(new XYChart.Data<String,Number>("瑪德蓮",sum6/sum9));
						data.getData().add(new XYChart.Data<String,Number>("閃電泡芙",sum7/sum9));
						data.getData().add(new XYChart.Data<String,Number>("舒芙蕾",sum8/sum9));
						
						lineChart.getData().add(data);
						primaryStage.setScene(scene);
						primaryStage.setTitle("Bakery.com");
						primaryStage.show();
					}
					
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		launch(args);
	}
}
	

