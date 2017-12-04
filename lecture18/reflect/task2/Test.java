package lecture18.reflect.task2;

import com.sun.istack.internal.Pool;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;


interface I {
    String getValue();
}

abstract class Imlp implements I {
    @Override
    public String getValue() {
        return String.valueOf(Math.random());
    }


}

class A {
    private String str;

    @Resource(Pool.Impl.class)
    private I i;


    public I getI() {
        return i;
    }
}

class B {
    private int val;

    @Resource
    private A aVal;

    public I getI() {
        return aVal.getI();

    }
}

class DIContext {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    private static final DIContext INSTANCE = new DIContext();

    public static DIContext instance() {
        return INSTANCE;
    }

    private DIContext() {
    }

    public <T> T create(Class<T> clazz) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        T obj = null;
        try {
            Constructor constr = clazz.getDeclaredConstructor();


            if (Modifier.isPrivate(constr.getModifiers())) {
                Method getInst = clazz.getDeclaredMethod("getInstance");


                if (getInst != null) {
                    getInst.setAccessible(true);
                    obj = (T) getInst.invoke(null, null);

                }
            } else {
                constr.setAccessible(true);
                obj = (T) constr.newInstance();
            }
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        inject(obj);
        return obj;
    }

    public void inject(Object obj) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getFields();
        for (Field f :
                fields
                ) {
            Resource a = f.getAnnotation(Resource.class);
            if (a != null) {
                if (!a.getClass().isPrimitive()) {
                    boolean singleton = a.singleton();
                    f.setAccessible(true);


                    if (a.value() != DefaultClass.class) {

                        inject(obj, singleton, a.value(), f);
//                    f.set(obj, getInstance(true, Class.forName(a.value().getName())));
                    } else {


//                    f.set(clazz.newInstance(), getInstance(true, clazz));
                        inject(obj, singleton, f.getType(), f);
                    }
                }
            } else {
                if (!a.getClass().isPrimitive()) {
                    inject(getInstance(true,f.getType()), true, f.getType(), f);
                }
            }
        }
    }

    private void inject(Object obj, boolean singleton, Class<?> type, Field fld) {
        try {
            fld.setAccessible(true);

            Object dependency = getInstance(singleton, type);

            fld.set(obj, dependency);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public Object get(String str) throws ClassNotFoundException {
        Class clazz = null;
        Object obj = null;
        try {
            clazz = Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            obj = getInstance(true, clazz);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;

    }


    private Object getInstance(boolean singleton, Class<?> type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object dependency = singleton && instances.containsKey(type)
                ? instances.get(type)
                : create(type);

        instances.putIfAbsent(type, dependency);

        return dependency;
    }
}

public class Test {
    public static void main(String[] args) {
        DIContext ctx = DIContext.instance();

        B b = null; // используйте generics, чтобы не делать cast
        try {
            b = (B) ctx.get("lecture18.reflect.task2.B");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String randomString = b.getI().getValue();
        System.out.println(randomString);
        I i = null;
        try {
            i = (I) ctx.get("lecture18.reflect.task2.Impl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        assert i == b.getI(); // singleton
    }
}

class DefaultClass implements I {

    @Override
    public String getValue() {
        return "qqq";
    }
}