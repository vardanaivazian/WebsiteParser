package am.tv.program;

import electro.ElectricNetwork;

import java.io.IOException;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 2:11 PM
 */
public class Display {


    public static void main(String[] args) throws IOException {
        
        /*Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");

        System.out.println(doc.title());
        for (Element headline : newsHeadlines) {
            System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }*/
        
        Parser parser = new Parser();
        TVProgram h1TVProgram = parser.getH1TVProgram();

        System.out.println(h1TVProgram.toString());

        /*ElectricNetwork electricNetwork = new ElectricNetwork();
        ElectricNetwork.Graphic graphic = electricNetwork.getGraphic("Սայաթ-Նովա պող. 10, 12 շենքերը");

        System.out.println(graphic);*/
        


    }
}
