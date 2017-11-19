import javax.xml.bind.JAXBException;
import java.io.File;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        File trainsXml = new File("Trains.xml");
        Trains trains = JAXB.deserialize(trainsXml);
        trains.printInfo();
        trains.show(LocalTime.of(15,00), LocalTime.of(19,00));


    }
}
