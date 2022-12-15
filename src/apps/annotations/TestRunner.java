package apps.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 *  @author Oleg Rudoi
 *  @version 1.0 15 Dec 2022
 */
public class TestRunner {
    public static void start (Object object) {
        try {
            runBeforeSuite(object);
            runTests(object);
            runAfterSuite(object);
        } catch (AnnotationNotUniqueException e) {
            System.err.println(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runTests(Object object)
            throws InvocationTargetException, IllegalAccessException {
        List<Method> methods = new ArrayList<>();
        Class<?> className = object.getClass();
        for (Method method : className.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                methods.add(method);
            }
        }
        Map<Integer, Set<Method>> sortedMethods = sortByPriority(methods);
        List<Integer> priorityOrder = new ArrayList<>(sortedMethods.keySet());
        Collections.reverse(priorityOrder);

        for (Integer key : priorityOrder) {
            for (Method method : sortedMethods.get(key)) {
                method.invoke(object);
            }
        }
    }

    private static Map<Integer, Set<Method>> sortByPriority(List<Method> methods) {
        Map<Integer, Set<Method>> sortedMethods = new TreeMap<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                Set<Method> ms = new HashSet<>();
                if (sortedMethods.get(test.priority()) != null) {
                    ms = sortedMethods.get(test.priority());
                }
                ms.add(method);
                sortedMethods.put(test.priority(), ms);
            }
        }
        return sortedMethods;
    }

    private static void runBeforeSuite(Object object)
            throws InvocationTargetException, IllegalAccessException, AnnotationNotUniqueException {
        if (!checkIsAnnotationUnique(object, BeforeSuite.class)) {
            throw new AnnotationNotUniqueException("BeforeSuite annotation used not once");
        }

        Class<?> className = object.getClass();
        for (Method method : className.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(object);
            }
        }
    }

    private static void runAfterSuite(Object object)
            throws InvocationTargetException, IllegalAccessException, AnnotationNotUniqueException {
        if (!checkIsAnnotationUnique(object, AfterSuite.class)) {
            throw new AnnotationNotUniqueException("AfterSuite annotation used not once");
        }

        Class<?> className = object.getClass();
        for (Method method : className.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(object);
            }
        }
    }

    private static boolean checkIsAnnotationUnique(Object object, Class annotationClass) {
        Class<?> className = object.getClass();
        int counter = 0;
        for (Method method : className.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass)) {
                counter++;
            }
        }
        return counter == 1;
    }
}