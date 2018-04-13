package am.tv.program;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 2:11 PM
 */
public class Parser {
    
    public TVProgram getH1TVProgram() throws IOException {

        List<Map> programs = new ArrayList<Map>();
        Map<String, String> program = new HashMap<String, String>();
        
        
        
//        http://www.1tv.am/hy/schedule/2018/04/10/metric
//        http://www.1tv.am/hy/schedule/2018/04/11/metric
//        http://www.1tv.am/hy/schedule/2018/04/12/metric
//        http://www.1tv.am/hy/schedule/2018/04/13/metric
        Document doc = Jsoup.connect("http://www.1tv.am/hy/schedule/2018/04/13/metric").get();
        Elements liveListElements = doc.select(".live-wrapper .center .live-list-elem");

        TVProgram tvProgram = new TVProgram();
        tvProgram.setName(doc.title());
        for (Element liveListElement : liveListElements) {
            ProgramItem programItem = new ProgramItem();
            programItem.setName(liveListElement.select("a.db .live-list-info-box .table .table-cell").text());
            programItem.setLink(liveListElement.select("a.db").attr("href"));
            programItem.setImg(liveListElement.select("a.db .live-list-img-box img").attr("src"));
            programItem.setDate(liveListElement.select(".live-list-time-box .live-list-time").text());
            tvProgram.addProgramItem(programItem);
        }
        
        return tvProgram;
    }
    
}
