import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path="test.txt")
public class TextContainer {
    private String text = "Test text";

    public TextContainer() {
    }

    public String getText() {
        return text;
    }

    @Saver
    public void save(String path) {
        try(PrintWriter pw = new PrintWriter(
                new FileWriter(path))) {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            pw.print(this.text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
