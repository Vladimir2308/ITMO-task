package lecture7.Task3.Utils;


public class Task3Utils {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("qqwwe");
        list.add(134);
        Boolean thatTrue = new Boolean(true);
        list.add(thatTrue);
        list.add(new int[5]);
        list.add("33");

        ((LinkedList) list).print();

        Object temp = Utils.find(new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return obj.equals(true);
            }
        }, list);
        if (temp != null)
            System.out.println("Объект есть");
        else
            System.out.println("Объекта нет");


        List list1 = new LinkedList();
        list1.add("a");
        list1.add("aa");
        list1.add("c");
        list1.add("dfg");
        Utils.print(list1);
        List newList = Utils.filter(new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return obj.toString().length() == 1;
            }
        }, list1);
        Utils.print(newList);
        newList = Utils.transform(new Transformer() {
            @Override
            public String tramsform(Object o) {
                return (o.toString() + o.toString());
            }


        }, list1);
        Utils.print(newList);

    }
}
