package lecture18.reflect.strings;

import lecture18.Exclude;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class Utils {
    public static String toString(Object o) throws IllegalAccessException {
        Class<?> clazz = o.getClass();

        StringBuilder sb = new StringBuilder();

        toString(clazz, sb, o);

        return sb.toString();
    }



    private static void toString(Class<?> clazz, StringBuilder sb, Object o) throws IllegalAccessException {
        sb.append(clazz.getSimpleName()).append("{ ");

        for (Field field : clazz.getDeclaredFields()) {
           Annotation a = field.getAnnotation(Exclude.class);
            if (a == null) {
                sb.append(field.getName()).append("= ");

                field.setAccessible(true);

                if (!field.getType().isPrimitive()) {
                    if(field.getType().isArray()){
                        sb.append(field.getType().getComponentType()).append("[]{");
                       int len= java.lang.reflect.Array.getLength(field.get(o));
                        for (int i = 0; i < len; i++) {
                            sb.append( java.lang.reflect.Array.get(field.get(o),i));
                            if (i!=len-1){
                                sb.append(", ");
                            }


                        }
                        sb.append("}");
                    }
                    else{
                        Object objFld = field.get(o);

                    if (objFld == null)
                        sb.append("null");
                    else
                        sb.append(toString(objFld));
                }} else {


                    sb.append(field.get(o));
                }
                sb.append("; ");


            }
        }
        sb.append("}");
    }

    private static void toString(Class<?> clazz, StringBuilder sb) {
        LinkedHashMap<Class<?>, Field> map = new LinkedHashMap<>();

        while (clazz != null) {
            sb.append(clazz.getName());
            sb.append("{");
            Field[] arr = clazz.getDeclaredFields();
            Field f;
            boolean isClass = false;

            int i = 0;
            while (i < arr.length) {
                f = arr[i++];
                f.setAccessible(true);
                sb.append(" =");
                if (f.getType().isPrimitive()) {

                    sb.append(f);
                    sb.append(";");

                } else {
                    map.put(clazz, f);
                    clazz = f.getType();
                    isClass = true;
                    break;
                }
            }
            if (!isClass) {
                if (map.size() > 0) {
                    Class<?> last = null;
                    for (Map.Entry<Class<?>, Field> entry : map.entrySet()) {
                        last = entry.getKey();

                    }
                    f = map.remove(last);
                    arr = last.getDeclaredFields();
                    int j = contain(arr, f);
                    if (j >= 0) {
                        j += 1;
                        while (j < arr.length) {
                            f = arr[j++];
                            f.setAccessible(true);
                            if (f.getType().isPrimitive()) {
                                sb.append(" =");
                                sb.append(f);
                                sb.append(";");

                            } else {
                                map.put(clazz, f);
                                clazz = f.getType();
                                isClass = true;
                                break;
                            }
                        }
                        if (!isClass) {
                            sb.append(" }");
                            clazz = null;
                        }
                    }

                } else {
                    clazz = null;
                    sb.append(" }");
                }
            }

        }
    }
    public static int contain(Field[] arr, Field f1) {
        int i = -1;
        int j = -1;

        for (Field f :
                arr) {
            ++i;
            if (f.equals(f1)) {
                j = i;
            }

        }
        return j;
    }
}