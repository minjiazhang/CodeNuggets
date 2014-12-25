import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        
        LinkedList<Interval> res = new LinkedList<Interval>();
        
        if (intervals == null) {
            return res;
        }
        
        Collections.sort(intervals, new IntervalComparable()); //(Is there a List sort? If no, should we convert it into an array first?)
        //sort() is a method in Collection.
   
        Interval last;
        for (Interval interval : intervals) {
            if (res.size() == 0){
                res.add(interval);
            } else {
                 last = res.getLast();
                 if (last.end >= interval.start) {
                     last.end = Math.max(interval.end, last.end);
                 } else {
                     res.add(interval);
                 }
            }
        }
        
        //How would you convert a stack to a list? 
        
        return res;
    }
//	public List<Interval> merge(List<Interval> intervals) {
//        LinkedList<Interval> interv = new LinkedList<Interval>();
//        interv.addAll(intervals);
//        LinkedList<Interval> res = new LinkedList<Interval>();
//        
//        while (!intervals.isEmpty()) {
//            Interval cur = interv.pollFirst(); //getFirst() is not the right choice here since it probably does not delete the node.
//            //Iterate the rest of the list and merge with greedy algorithm until no more intervals can be merged.
//            boolean hasMerge = false;
//            do { //scan the rest of list at least once. 
//                Iterator<Interval> listIter =interv.iterator();
//                while (listIter.hasNext()) {
//                    Interval temp = listIter.next(); //return the current node.
//                    if (temp.start <= cur.end || temp.end >= cur.start) { //can be merged.
//                        cur = new Interval(Math.max(temp.start, cur.start), Math.max(temp.end, cur.end));
//                        hasMerge = true;
//                    }
//                }
//            } while (hasMerge); //? stop only if no merge can be done.
//            
//            res.add(cur);
//        }
//        
//        return res;
//    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparable implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start < b.start ? -1 : (a.start == b.start ? 0 : 1);
    }
}
