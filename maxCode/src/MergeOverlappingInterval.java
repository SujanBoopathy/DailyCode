import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingInterval {
    public static void main(String args[]){
        Interval[] arr = new Interval[5];
        arr[0] = new Interval(12,13);
        arr[1] = new Interval(1,5);
        arr[2] = new Interval(4,6);
        arr[3] = new Interval(8,9);
        arr[4] = new Interval(2,3);
        List<Interval> merged=mergeInterval(arr);
        for(Interval i : merged){
            System.out.println(i.start +":"+ i.end);
        }
    }

    public static List<Interval> mergeInterval(Interval[] arr){
        List<Interval> result = new ArrayList<>();
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int start = arr[0].start;
        int end = arr[0].end;
        for(Interval interval : arr){
            if(interval.start > end){
                result.add(interval);
                start = interval.start;
                end = interval.end;
            }
            else{
                end = Math.max(end,interval.end);
            }
        }
        return result;
    }
}

class Interval{
    int start , end;
    Interval(int start , int end){
        this.start = start;
        this.end = end;
    }
}
