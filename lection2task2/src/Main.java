import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File json = new File("json.txt");
        Person person = JsonReader.getPerson(json);
        System.out.println(person);
    }
}
