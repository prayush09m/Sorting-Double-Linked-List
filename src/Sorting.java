
public class Sorting {
     Link list;


    public void SortOut(String names, Link list) {

        Link tail = list.findTail();

        if (check(names, tail) && tail.prev != null) {
            tail = list.findTail();
            while (check(names, tail) && tail.prev != null) {
                tail = tail.prev;
            }
            list.insertAfter(tail, names);
        }
//        } else if(check(names,tail) && tail.prev == null){
//            System.out.print("I am here");
//            tail = list.findTail();
//
//            list.addAtFirst(tail,names);
//        }
        else {

            list.addAtTail(names);

        }
    }

    public boolean check(String names,Link tail) {
        if (names.compareTo(tail.data) < 0) {
            return true;
        } else if (names.compareTo(tail.data) > 0) {
            return false;
        } else {
            return true;
        }
    }





}
