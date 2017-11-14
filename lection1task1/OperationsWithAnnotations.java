import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OperationsWithAnnotations {

    public static void runMethods(Class aClass, Class annotation) {
        Method[] methods = aClass.getDeclaredMethods();
        for (int i = 0; i < methods.length ; i++) {
            if (methods[i].isAnnotationPresent(annotation)) {
                MyAnnotation myAnnotation = methods[i].getAnnotation(MyAnnotation.class);
                try {
                    int res = (int) methods[i].invoke(aClass, myAnnotation.a(), myAnnotation.b());
                    System.out.println("a = " + myAnnotation.a() + ". b = " + myAnnotation.b() +
                            ". Result of " + methods[i].getName() + " = " + res);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
