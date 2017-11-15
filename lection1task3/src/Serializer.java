import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayDeque;

public class Serializer implements Serializable{
    private ArrayDeque<Object> catAnnotatedFields;
    private File serializedCatFields;

    public Serializer(String path) {
        this.catAnnotatedFields = new ArrayDeque<>();
        this.serializedCatFields = new File(path);
        try {
            this.serializedCatFields.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getSerializedCatFields() {
        return serializedCatFields;
    }

    public void setSerializedCatFields(File serializedCats) {
        this.serializedCatFields = serializedCats;
    }

    public void serialize(Object fieldValue) {
        this.catAnnotatedFields.addLast(fieldValue);
        try (ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream(this.serializedCatFields))) {
            os.writeObject(this.catAnnotatedFields);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayDeque<Object> deserialize(File file) {
        try (ObjectInputStream os = new ObjectInputStream(
                new FileInputStream(file))) {
            ArrayDeque<Object> res = (ArrayDeque<Object>) os.readObject();
            return res;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void serializeAnnotatedFields(Cat... cats) {
        for (Cat cat: cats) {
            Field[] fields = cat.getClass().getDeclaredFields();
            try {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Save.class)) {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            field.setAccessible(true);
                        }
                        String fieldValue = (String) field.get(cat);
                        serialize(fieldValue);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
