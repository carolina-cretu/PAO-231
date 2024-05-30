package multithreading.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carolina Cretu
 */
public class SynchronizedBlock {

    String name = "";
    public int count = 0;

    public void changeName(String name, List<String> list) {
        // Un singur thread are permisiune
        synchronized (this) {
            this.name = name;
            count++;  // cate threaduri au schimbat numele
        }

        // Toate celelalte threaduri au permisiunea sa adauge in lista
        list.add(name);
    }
}

class MainSyncBlock {
    public static void main(String[] args) {
        SynchronizedBlock sb = new SynchronizedBlock();
        List<String> list = new ArrayList<String>();
        sb.changeName("name", list);
        System.out.println(sb.name);

    }
}
