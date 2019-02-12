package example;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OneTest {

//  private String name ="11";

    @Before
    public void beforeFoo() {
        File file = new File("out.txt");
        if (file.exists()) {
            boolean a = file.delete();
            if(a){
                System.out.println("aaa");
            }
        }
    }

    private List<String> readOutFile() {
        File file = new File("out.txt");
        FileInputStream is;
        List<String> list = new ArrayList<String>();
        try {
            if (file.length() != 0) {
                is = new FileInputStream(file);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                reader.close();
                is.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Test
    public void testFoo() {
        One one = new One();
        one.foo();
        List<String> list = readOutFile();
        assertEquals("freets", list.get(2));

        int count = 3;
        sortByThread(list, count);

//    boolean isSuccese = writeToOutFile("output.txt", list);

    }

    private void sortByThread(List<String> list, int threadNum) {
        if (null == list) {
            return;
        }


        if (list.size() <= threadNum) {
            sortList(list);
        }

        sortList(list);

        //分配每个线程处理的队列长度
//        int length = list.size() / threadNum;
//        boolean zhenchu = true;
//        if (list.size() % threadNum != 0) {
//            length += 1;
//            zhenchu = false;
//        }


        int times = 0;
        for (int num = 0; num < threadNum; num++) {
            times = list.size()/threadNum;
        }

        if ( times == 0){
            System.out.println("2345");
        }
        sortList(list);

    }

    private void sortList(List<String> list) {

        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

}