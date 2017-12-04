package lecture17;

import lecture18.Exclude;

import java.util.ArrayList;
import java.util.List;

public class Senser {
    private int temp = 0;
    List<Alarm> alarms = new ArrayList<>();
    int [] d={1,2,4};
    @Exclude
    int s;

    public void addListener(Alarm a) {
        alarms.add(a);
    }

    public void delListener(Alarm a) {
        alarms.remove(a);
    }

    public void notifyListeners() {
        for (Alarm a :
                alarms) {
            a.invoke(temp);
        }
    }

    public static void main(String[] args) {
        Senser senser = new Senser();
        senser.addListener(new Alarm() {
            boolean worked = false;

            @Override
            public void invoke(int temp) {

                if (temp >= 100) {
                    if (!worked) {
                        System.out.println("Green Attention temperature more 100C");
                        worked = true;
                    }
                }else worked = false;
            }
        });
        senser.addListener(new Alarm() {
            boolean worked = false;

            @Override
            public void invoke(int temp) {

                if (temp >= 300) {
                    if (!worked) {
                        System.out.println("Yellow Attention temperature more 300C");
                        worked = true;
                    }
                }else worked = false;
            }
        });
        senser.addListener(new Alarm() {
            boolean worked = false;

            @Override
            public void invoke(int temp) {

                if (temp >= 600) {
                    if (!worked) {
                        System.out.println("Red Attention temperature more 600C !!!");
                        worked = true;
                    }
                }else worked = false;
            }
        });
        int step = 20;
        while (true) {
            senser.temp += step;
            if ((senser.temp >= 1000) || (senser.temp <= 0)) {
                step = -step;
            }

            senser.notifyListeners();
            System.out.println("temp:"+ senser.temp);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
