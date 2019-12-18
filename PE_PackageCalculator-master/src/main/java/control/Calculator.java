package control;

import java.io.IOException;

import data.Packet;
import exporter.HTMLCreator;
import gui.CalculatorArea;

public class Calculator {

	public double calcShippingCosts(Packet pack) {
		double shippingCosts;
		if ((pack.length <= 300) && (pack.width <= 300) && (pack.height <= 150) && (pack.weight <= 1000)) {
			shippingCosts = 3.89;
		}
		else if ((pack.length <= 600) && (pack.width <= 300) && (pack.height <= 150) && (pack.weight <=2000)) {
			shippingCosts = 4.39;
		}
		else if ((pack.length <= 1200) && (pack.width <= 600) && (pack.height <= 600)&& (pack.length +2*pack.width +2*pack.height)<=3000 && (pack.weight <= 5000)) {
			shippingCosts = 5.99;
		}  
		else if ((pack.length <= 1200) && (pack.width <=600) && (pack.height <= 600)&& (pack.length +2*pack.width +2*pack.height)<=3000 && (pack.weight <= 10000)) {
			shippingCosts = 7.99;
		} 
		else if ((pack.length <= 1200) && (pack.width <=600) && (pack.height <= 600) && (pack.weight <= 31500)) {
			shippingCosts = 12.99;
		}
		else {
			shippingCosts = -1;
		}
		HTMLCreator html= new HTMLCreator();

		try {
			html.open("lastPackage.html");
			html.startPage();
			html.startBody();
			html.addParagraph("length:"+pack.length+"cm");
			html.addParagraph("width:"+pack.width+"cm");
			html.addParagraph("height:"+pack.height+"cm");
			html.addParagraph("weight:"+pack.weight+"g");
			html.addParagraph("shipping costs:"+shippingCosts+"Euro");
			html.finishBody();
			html.finishPage();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		}
		return shippingCosts;

	}
}
	