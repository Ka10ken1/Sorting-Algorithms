import java.util.*;

public class MergeSort {

    public static List<List<Integer>> single(List<Integer> l){
        return l.stream().map(List::of).toList();
    }

    public static List<Integer> merge(List<Integer> l1,List<Integer> l2){
        if(l2.size() == 0){
            return l1;
        }
        if(l1.size() == 0){
            return l2;
        }

        List<Integer> lst = new ArrayList<>();

        if(l1.get(0)<l2.get(0)){
            lst.add(l1.get(0));
            lst.addAll(merge(l1.subList(1,l1.size()),l2));
        }
        else{
            lst.add(l2.get(0));
            lst.addAll(merge(l1,l2.subList(1,l2.size())));
        }
        return lst;
    }
    public static List<List<Integer>> mergeLists(List<List<Integer>> ll){
        if(ll.size() == 0){
            return new ArrayList<>();
        }
        if(ll.size() == 1){
            return ll;
        }
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(merge(ll.get(0),ll.get(1)));
        lst.addAll(mergeLists(ll.subList(2,ll.size())));

        return lst;
    }

    public static List<Integer> sort(List<Integer> lst){
        List<List<Integer>> ll = single(lst);
        return doit(ll);
    }

    public static List<Integer> doit(List<List<Integer>> ll){
        if(ll.size() == 0){
            return new ArrayList<>();
        }
        if(ll.size() ==1){
            return ll.get(0);
        }
        return new ArrayList<>(doit(mergeLists(ll)));
    }

}