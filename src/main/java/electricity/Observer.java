package electricity;

import java.util.List;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 6:51 PM
 */
public interface Observer {
    List<String> getStreets();
    void update(String street, String time);
}
