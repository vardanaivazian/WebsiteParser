package electro;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 6:10 PM
 */
public class ElectricNetwork {
    
    public class Graphic {
        Date date; 
        String street;
        String time;

        public Graphic() {
            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 1);
            this.date = c.getTime();
        }

        @Override
        public String toString() {
            return "Graphic{" +
                    "date=" + date +
                    ", street='" + street + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }
    
    public Graphic getGraphic(String street) throws IOException {
        
        Document doc = Jsoup.connect("http://www.ena.am/Info.aspx?id=5&lang=1").get();
        Elements pTags = doc.select("p");

        for (Element element : pTags) {
            if (element.text().contains(street)) {
                Graphic graphic = new Graphic();
                graphic.street = street; 
                graphic.time = element.select("u").text();
                return graphic;
            }
        }
        return null;
    }
    
}
