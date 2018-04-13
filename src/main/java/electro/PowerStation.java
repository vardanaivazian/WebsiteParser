package electro;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 7:01 PM
 */
public class PowerStation {

    public static void main(String[] args) throws IOException {

        ElectricalGridData electricalGridData = new ElectricalGridData();

        OfficeWorker vardan = new OfficeWorker("Vardan", "Aivazian", "vardan27a@gmail.com", "Լվովյան");
        
        OfficeWorker mher = new OfficeWorker("Mher", "Chobanyan", "mher.chobanyan@eyesoftinc.com", "Պարույր Սևակի");
        
        OfficeWorker edgar = new OfficeWorker("Edgar", "Yeganyan", "edgar.yeganyan@eyesoftinc.com", "Մոլդովական");
        
        electricalGridData.registerObserver(vardan);
        electricalGridData.registerObserver(mher);
        electricalGridData.registerObserver(edgar);



        Document doc = Jsoup.connect("http://www.ena.am/Info.aspx?id=5&lang=1").get();
        Elements pTags = doc.select("p");

        for (Element pTag : pTags) {
            String text = pTag.text();
//            String[] parsedStreets = text.split(",");

            String time = pTag.select("u").text();
//            for (String street : parsedStreets) {
                electricalGridData.setElGraphic(text, time);
//            }
        }
    }
    
}
