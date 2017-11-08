package lecture11;

import lecture11.inner.MessageGenerator;
import lecture11.inner.Message;
import lecture11.inner.MessagePriority;


import java.util.*;

/**
 * Created by xmitya on 17.10.16.
 */
public class Tasks1 {

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(100);

        countEachPriority(messages);
        countCountEachCode(messages);
        countUniqueMessages(messages);

        System.out.println("Genuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages));

        removeEach(generator.generate(100), MessagePriority.LOW);
        removeOther(generator.generate(100), MessagePriority.URGENT);
    }

    private static void countEachPriority(List<Message> messages) {
        int[] count = new int[MessagePriority.values().length];
        for (Message mes :
                messages) {
            count[MessagePriority.ordinal(mes.getPriority())]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(MessagePriority.fromOrdinal(i) + ": " + count[i]);
        }
    }

    private static void countCountEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.
        HashMap<Integer, Integer> map = new HashMap<>();
        ;
        for (Message mes :
                messages) {

            int i;
            if (map.containsKey(mes.getCode()))
                i = map.get(mes.getCode()) + 1;
            else i = 1;
            map.put(mes.getCode(), i);
        }
        for (Map.Entry<Integer, Integer> i : map.entrySet()
                ) {
            System.out.println("\"" + i.getKey() + "\": " + i.getValue());

        }
    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.

        HashSet<Message> set = new HashSet<>();
        for (Message mes :
                messages) {
            set.add(mes);
        }
        System.out.println("Уникальных сообщений: " + set.size());

    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.

        LinkedHashSet<Message> set = new LinkedHashSet<>();

        for (Message mes :
                messages) {
            set.add(mes);
            System.out.print(mes + " ");
        }
        System.out.println();
        messages.clear();
        messages.addAll(set);
        return messages;
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сообщение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);
        Object[] arr = messages.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (((Message) arr[i]).getPriority().equals(priority)) {
                messages.remove(arr[i]);

            }

        }
        System.out.printf("After remove each: %s, %s\n", priority, messages);

    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);

        Object[] arr = messages.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (!((Message) arr[i]).getPriority().equals(priority)) {
                messages.remove(arr[i]);
            }
        }

        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}
