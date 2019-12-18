package exporter;
import java.io.IOException;


public class TestHTMLCreator   {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		HTMLCreator html= new HTMLCreator();


		html.open("hello.html");
		html.startPage();
		html.writeHead("Hello HTML");
		html.startBody();
		html.writeHeading("Hello HTML");
		html.addParagraph("This is my first HTML file!");
		html.addLink("http://www.uni-stuttgart.de", "with a link in it.");
		html.startList();
		html.startListItem();
		html.addText("First list item");
		html.finishListItem();
		html.startListItem();
		html.addText("Second list item");
		html.finishListItem();
		html.startListItem();
		html.addText("Third list item");
		html.finishListItem();
		html.finishList();
		html.finishBody();
		html.finishPage();	

	}

}