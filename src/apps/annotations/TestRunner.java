package apps.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
    public static void start (Object object) {
        Tester tester = new Tester();

        runBeforeSuite(object);
    }

    private static void runBeforeSuite(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> className = object.getClass();
        for (Method method : className.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(object);
            }
        }
        if (className.isAnnotationPresent(BeforeSuite.class)) {

        }
    }

    private static Object checkIsAnnotationUnique(Class<BeforeSuite> beforeSuiteClass) {
        return null;
    }
}

class Tester {

}
