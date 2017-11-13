package lecture11;

import lecture11.inner.Message;
import lecture11.inner.User;

import java.util.*;

import static lecture11.inner.UserGenerator.generate;

/**
 * Created by xmitya on 20.10.16.
 */
public class Tasks2 {
    public static void main(String[] args) {
        List list = generate(10);
        System.out.println(list);
        NavigableSet<User> set= sortedByCompanyAndName(list);
        System.out.println(set);
        set= sortedBySalaryAndName(list);
        System.out.println(set);
    }

    private static void sortByPriority(List<Message> messages) {
        boolean order = true;
        Collections.sort(messages, new Comparator<Message>() {
            public int compare(Message m1,
                               Message m2) {
                if (order) {
                    return m1.getPriority().compareTo(m2.getPriority());
                } else {
                    return m2.getPriority().compareTo(m1.getPriority());

                }
            }
        });
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {

        TreeSet<User> set = new TreeSet<>( new Comparator<User>() {
            public int compare(User m1,
                               User m2) {

                    if (m1.getCompany().equals(m2.getCompany())) {
                        return m1.getName().compareTo(m2.getName());
                    } else
                        return m1.getCompany().compareTo(m2.getCompany());

            }
        });
        set.addAll(users);
        return set;
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {
        TreeSet<User> set = new TreeSet<User>( new Comparator<User>() {
            public int compare(User m1,
                               User m2) {

                if (m1.getSalary()==m2.getSalary()) {
                    return m1.getSalary()-m2.getSalary();
                } else
                    return m1.getName().compareTo(m2.getName());

            }
        });
        set.addAll(users);
        return set;
    }

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {

        return Collections.emptyNavigableSet();
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {

        return null;
    }


}
