package electricity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan Aivazian
 * Date: 4/12/2018
 * Time: 6:52 PM
 */
public class ElectricalGridData implements Subject {
    
    private String street;
    private String time;
    
    private List<Observer> observers;

    public ElectricalGridData() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        if ("".equals(this.street)) {
            return;
        }
        for (Observer observer : this.observers) {
            for (String s : observer.getStreets()) {
                if (this.street.contains(s) /*|| s.contains(this.street)*/) {
                    observer.update(s, time);
                }
            }
        }
    }
    
    public void elGraphicChanged() {
        notifyObservers();
    }
    
    public void setElGraphic(String street, String time) {
        this.street = street;
        this.time = time;
        
        elGraphicChanged();
    }
}
