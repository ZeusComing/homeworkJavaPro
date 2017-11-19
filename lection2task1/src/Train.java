import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

@XmlRootElement
public class Train {

    private int id;
    private LocalDate date;
    private LocalTime departure;
    private String from;
    private String to;

    public Train(LocalDate date, LocalTime departure, String from, String to, int id) {
        this.date = date;
        this.departure = departure;
        this.from = from;
        this.to = to;
        this.id = id;
    }

    public Train() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    @XmlElement
    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", date=" + date +
                ", departure=" + departure +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
