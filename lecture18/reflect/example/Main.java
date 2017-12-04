package lecture18.reflect.example;

import lecture18.reflect.injector.Injector;
import lecture18.reflect.strings.Utils;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Injector injector = Injector.instance();

        TargetObject to1 = injector.getObject(TargetObject.class, false);
        TargetObject to2 = injector.getObject(TargetObject.class, false);

        System.out.println("Before injection: " + to1);
        System.out.println("Before injection: " + to2);

        injector.inject(to1);
        injector.inject(to2);

        System.out.println("After injection: " + to1);
        System.out.println("After injection: " + to2);

        System.out.println("Singleton: " + (to1.getSingleton() == to2.getSingleton())); // true
        System.out.println("NonSingleton: " + (to1.getNonSingleton() == to2.getNonSingleton())); // false

        String s = Utils.toString(to1);

        System.out.println(s);
    }
}
