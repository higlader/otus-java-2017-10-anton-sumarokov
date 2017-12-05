package myframework;

import myframework.annotations.After;
import myframework.annotations.Before;
import myframework.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class RunTest {

    private RunTest() {

    }

    public static void findClass(String className) {
        try {
            Class klass = Class.forName(className);
            runTest(klass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void runTest(Class<?> classes) {

            System.out.println("run: " + classes.getName());

            List<Method> before = ReflectionHelper.getMethodsByAnnotation(classes, Before.class);
            List<Method> test = ReflectionHelper.getMethodsByAnnotation(classes, Test.class);
            List<Method> after = ReflectionHelper.getMethodsByAnnotation(classes, After.class);

            if (test.size() == 0) {
                System.out.println(" test not found ");
            }

            System.out.println(" before: " + before.size());
            System.out.println(" test: " + test.size());
            System.out.println(" after: " + after.size());

            for (Method testsMethod : test) {

                Object instance = ReflectionHelper.instantiate(classes);

                // before
                for (Method beforeMethod : before) {
                    ReflectionHelper.callMethod(instance, beforeMethod.getName());
                }

                // test
                ReflectionHelper.callMethod(instance, testsMethod.getName());

                // after
                for (Method afterMethod : after) {
                    ReflectionHelper.callMethod(instance, afterMethod.getName());
                }
            }
        }

    public static void findPackage(String packageName) {
        try {
            com.google.common.reflect.ClassPath.from(RunTest.class.getClassLoader()).getTopLevelClasses(packageName).stream()
                    .map(com.google.common.reflect.ClassPath.ClassInfo::getName)
                    .forEach(RunTest::findClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


