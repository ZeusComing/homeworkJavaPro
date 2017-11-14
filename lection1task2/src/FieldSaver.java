import java.lang.reflect.Method;

public class FieldSaver {

    public static void run(TextContainer textContainer, Class annotationSaver) {
        try {
            if (getPath(textContainer) != null) {
                Method[] methods = textContainer.getClass().getDeclaredMethods();
                String path = getPath(textContainer);
                for (Method m : methods) {
                    if (m.isAnnotationPresent(annotationSaver)) {
                        m.invoke(textContainer, path);
                        System.out.println("\"" + textContainer.getText() + "\" saved to " + path);
                    }
                }
            } else {
                System.out.println("No path error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPath(TextContainer textContainer) {
        if (textContainer.getClass().isAnnotationPresent(SaveTo.class)) {
            SaveTo saveTo = textContainer.getClass().getAnnotation(SaveTo.class);
            return saveTo.path();
        } else {
            return null;
        }
    }
}
