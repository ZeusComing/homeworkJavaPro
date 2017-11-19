import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class JsonReader {

    public static String read(File json) {
        byte[] buffer;
        try (RandomAccessFile raf = new RandomAccessFile(json, "r")) {
            buffer = new byte[(int) raf.length()];
            raf.read(buffer);
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Person getPerson(File json) {
        String personString = read(json);
        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(personString, Person.class);
        return person;
    }
}
