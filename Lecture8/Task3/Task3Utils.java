package Lecture8.Task3;


import java.io.File;

import static java.io.File.separatorChar;

public class Task3Utils {
    public static void main(String[] args) {
        File dir1 = new File("d:/dir1");
        File dir2 = new File("d:/dir2");


        List files1 = Utils.toList(dir1.listFiles());
        List files2 = Utils.toList(dir2.listFiles());
        Utils.print("files1", files1);
        Utils.print("files2", files2);
        List duplicated = Utils.intersect(files1, files2, new Predicate2() {
            @Override
            public boolean apply(Object obj1, Object obj2) {
                File file1 = (File) obj1;
                File file2 = (File) obj2;
                if (file1.getName().equals(file2.getName())) return true;
                if (obj1 == null || obj2 == null) return false;
                if (obj1.toString().equals(obj2.toString())) return true;
                return false;

            }
        });

        Utils.print("List intersect", duplicated);
        List more1Mb = Utils.filter(files1, new Predicate() {
            @Override
            public boolean apply(Object obj) {
                File file = (File) obj;
                long size;
                if (file.isDirectory())
                    size = 0L;
                else
                    size = file.length();
                if (size >= 1024 * 1024) return true;
                return false;

            }
        });
        Utils.print("List More1Mb", more1Mb);
        List filesJava = Utils.filter(files1, new Predicate() {
            @Override
            public boolean apply(Object obj) {
                File file = (File) obj;
                int index = file.getName().lastIndexOf('.');
                if (index>0)
                    if (file.getName().substring(index+1).equals("java"))return true;
                return false;
            }
        });
        Utils.print("List filesJava", filesJava);
    }
}
