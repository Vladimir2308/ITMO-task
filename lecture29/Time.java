package lecture29;

import java.time.LocalDate;

public class Time {
    public static void main(String[] args) {
        LocalDate begin= LocalDate.of(1,1,1);
        LocalDate end= LocalDate.of(2017,12,31);
        LocalDate temp=begin;
        int i=0;
       while (!temp.equals(end)) {
            temp=temp.plusDays(1);
            if ((temp.getDayOfWeek().toString().equals("FRIDAY"))&(temp.getDayOfMonth()==13)){
                System.out.println(temp.getDayOfYear()+ " day  "+ temp.getDayOfMonth()+
                        "  " +temp.getMonth().toString()+" "+ temp.getDayOfWeek().toString()+ " "+ temp.getYear());
                i++;
            }
        }

        System.out.println(" всего пятниц "+ i);



    }
}
