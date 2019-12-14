/*
 * Author:		Hemansu Kapadia
 * Date:		December 14,2019
 * Filename:	GoogleSearch.java
 * Description:	Search keyword "ProQuest" on Google Search, Retrieve and Store all search result titles to a text file.
 */
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GoogleSearch {
	
	public static String outputFileLocation = System.getProperty("user.dir") + "\\test-results\\GoogleSearchResults.txt";
	public static String searchURL = "http://www.google.com/search?q=ProQuest";

	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect(searchURL).get();

		PrintWriter outputfile = new PrintWriter(outputFileLocation, "UTF-8");
		
		Elements webResults = doc.select("h3.LC20lb");		
		for (Element result : webResults) {
			outputfile.println("Titles: " + result.text());
		}

		Elements twitterResults = doc.select("div.zTpPx");
		for (Element result : twitterResults) {
			outputfile.println("Titles: " + result.text());
		}
	
		outputfile.close();
	}
}


