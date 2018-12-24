package sort.com.chenyx.sort;

import com.chenyx.compare.IntegerCompare;
import com.chenyx.compare.StringCompare;
import com.chenyx.constant.SortType;
import com.chenyx.factory.SortFactory;
import com.chenyx.sort.Sort;
import org.junit.Test;

public class InsertSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] arr = {4,1,5,3,4,7,1,8,5,10};
        Sort<Integer> sort = SortFactory.createCompare(SortType.INSERT_SORT.getType(), IntegerCompare.class);
        Integer[] resultArr = sort.sort(arr);
        for (Integer integer : resultArr) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }
    @Test
    public void testStrSort() throws Exception {
        String[] arr = {"12","3","7","3","1","2"};
        Sort<String> sort = SortFactory.createCompare(SortType.INSERT_SORT.getType(), StringCompare.class);
        String[] resultArr = sort.sort(arr);
        for (String integer : resultArr) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }

}