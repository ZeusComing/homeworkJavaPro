import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Trains {

    @XmlElement (name = "train")
    private List<Train> trains = new ArrayList<>();

    public Trains() {
    }

    public void add(Train train) {
        this.trains.add(train);
    }

    public void remove(Train train) {
        this.trains.remove(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void show(LocalTime from, LocalTime to) {
        for (Train t: trains) {
            if (t.getDeparture().isAfter(from) && t.getDeparture().isBefore(to)) {
                System.out.println(t);
            }
        }
    }

    public void printInfo() {
        for (Train t: trains) {
            System.out.println(t);
        }
    }
}
