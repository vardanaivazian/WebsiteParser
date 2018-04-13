package am.tv.program;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 5:45 PM
 */
public class ProgramItem {

    private String name;
    private String link;
    private String img;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "ProgramItem{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", img='" + img + '\'' +
                ", date='" + date + '\'' +
                "}\n";
    }
}
