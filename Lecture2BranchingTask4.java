public class Lecture2BranchingTask4 {
    public static void main(String[] args) {
        int a = (int) (Math.random() * 28800);
        if (a != 0) {
            System.out.println(a);
            System.out.println("До конца рабочего дня ");
            if (a/3600!=0)
            System.out.print(""+ a / 3600);

            switch (a / 3600) {
                case 0: {
                    System.out.print("осталось менее часа");
                    break;
                }
                case 1: {
                    System.out.print(" час остался");
                    break;
                }
                case 2: {
                }
                case 3: {
                }
                case 4: {
                    System.out.print(" часа осталось");
                    break;
                }
                default: {
                    System.out.print(" часов осталось");
                    break;
                }
            }
        } else System.out.print(" Рабочий день закончился ");
    }
}
