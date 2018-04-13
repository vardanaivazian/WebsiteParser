package electro;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 6:51 PM
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
