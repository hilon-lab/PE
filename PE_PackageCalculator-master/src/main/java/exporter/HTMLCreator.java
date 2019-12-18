package exporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLCreator {

	File file = new File("hello.html");

	/*
	 * This method creates the file with the name hello.html
	 * 
	 * 
	 * @throws IOException
	 */

	public void open(String fileName) throws IOException {


		if (file.createNewFile())
		{
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}

	}
	/*
	 * This method writes <html> into the file hello.html to open up the website
	 * 
	 * 
	 * @throws IOException
	 */
	public void startPage() throws IOException {
		FileWriter writer = new FileWriter(file,false);
		writer.write("<html>");
		writer.close();
	}
	/*
	 * This method writes </html> and closes the file hello.html 
	 * 
	 * 
	 * @throws IOException
	 */
	public void finishPage() throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("</html>");
		writer.close();
	}
	/*
	 * This method writes <head> and <title> and writes the Websitename and title of the website
	 * 
	 * 
	 * @throws IOException
	 */
	public void writeHead(String title) throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<head><title>"+title+"</title></head>");
		writer.close();
	}
	/*
	 * This method writes <body> and opens the main part of the html website
	 * 
	 * 
	 * @throws IOException
	 */
	public void startBody() throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<body>");
		writer.close();
	}
	/*
	 * This method writes </body> and does close the main part of the website
	 * 
	 * 
	 * @throws IOException
	 */
	public void finishBody() throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("</body>");
		writer.close();
	}
	/*
	 * This method writes <h1> and also closes </h1> it defines the headline and how big the letters will be
	 * 
	 * 
	 * @throws IOException
	 */
	public void writeHeading(String heading) throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<h1>"+heading+"</h1>");
		writer.close();	
	}
	/*
	 * This method writes <p> and also closes </p> it meant to write in to body simple lines of text
	 * 
	 * 
	 * @throws IOException
	 */
	public void addParagraph(String text) throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<p>"+text+"</p>");
		writer.close();
	}
	/*
	 * This method produces a hyperlink on the website 
	 * 
	 * 
	 * @throws IOException
	 */
	public void addLink(String targetUrl,String linkText) throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<a href=\""+targetUrl+"\">"+linkText+"</a>");
		writer.close();
	}
	/*
	 * This method writes <ul> and opens up a list on the website
	 * 
	 * 
	 * @throws IOException
	 */
	public void startList() throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<ul>");
		writer.close();
	}
	/*
	 * This method writes </ul> and closes the list
	 * 
	 * 
	 * @throws IOException
	 */
	public void finishList() throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("</ul>");
		writer.close();
	}
	/*
	 * This method writes <li> and adds subpoints to the list
	 * 
	 * 
	 * @throws IOException
	 */
	public void startListItem() throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write("<li>");
		writer.close();
	}
	/*
	 * This method writes </li> and ends the subpoints of the list
	 * 
	 * 
	 * @throws IOException
	 */
	public void finishListItem() throws IOException {

		FileWriter writer = new FileWriter(file,true);
		writer.write("</li>");
		writer.close();
	}
	/*
	 * This method uses the parameter text  which simple adds text to the website
	 * 
	 * @parameter text
	 * @throws IOException
	 */
	public void addText(String text) throws IOException {
		FileWriter writer = new FileWriter(file,true);
		writer.write(text);
		writer.close();

	}
}
