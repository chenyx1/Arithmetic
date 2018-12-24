package sort.com.chenyx.sort;

import com.chenyx.compare.IntegerCompare;
import com.chenyx.compare.StringCompare;
import com.chenyx.constant.SortType;
import com.chenyx.factory.SortFactory;
import com.chenyx.sort.Sort;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShellSortTest {
    @Test
    public void testSort() throws Exception {
        Integer[] arr = {4,1,5,3,4,7,1,8,5,10};
        Sort<Integer> sort = SortFactory.createCompare(SortType.SHELL_SORT.getType(), IntegerCompare.class);
        Integer[] resultArr = sort.sort(arr);
        for (Integer integer : resultArr) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }
    @Test
    public void testStrSort() throws Exception {
        String[] arr = {"12","3","7","3","1","2"};
        Sort<String> sort = SortFactory.createCompare(SortType.SHELL_SORT.getType(), StringCompare.class);
        String[] resultArr = sort.sort(arr);
        for (String integer : resultArr) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }

    @Test
    public void test() throws Exception {
        System.out.println("Math.ceil(0.00):" + Math.ceil(0.00));
        System.out.println("Math.ceil(-0.00):" + Math.ceil(-0.00));

        System.out.println( "Math.ceil(0):" +  Math.ceil(0));
        System.out.println("Math.ceil(-0):" + Math.ceil(-0));

        System.out.println("Math.round(0.00):"  + Math.round(0.00));
        System.out.println( "Math.round(- 0.00):"  + Math.round(- 0.00));

        System.out.println("Math.round(0):"  + Math.round(0));
        System.out.println("Math.round(- 0):"  +  Math.round(- 0));

        System.out.println("Math.floor(0.00):"  + Math.floor(0.00));
        System.out.println("Math.floor(-0.00):"  + Math.floor(-0.00));

        System.out.println("Math.floor(0):"  + Math.floor(0));
        System.out.println("Math.floor(-0):"  + Math.floor(-0));
    }

}