import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", 3);
        Cat cat2 = new Cat("Petr", 2);
        Serializer serializer = new Serializer("catfields.dat");
        serializer.serializeAnnotatedFields(cat1, cat2);
        ArrayDeque<Object> fields = serializer.deserialize(serializer.getSerializedCatFields());
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        cat3.setName((String) fields.pollFirst());
        cat4.setName((String) fields.pollFirst());
        System.out.println(cat3.getName());
        System.out.println(cat4.getName());
    }
}
