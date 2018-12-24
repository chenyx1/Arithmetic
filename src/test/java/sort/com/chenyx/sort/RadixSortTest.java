package sort.com.chenyx.sort;

import com.chenyx.compare.IntegerCompare;
import com.chenyx.constant.SortType;
import com.chenyx.factory.SortFactory;
import com.chenyx.sort.Sort;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {

    @Test
    public void testSort() throws Exception {
        Integer[] arr = {124,121,554,43433,4,754,1,84,675,410};
        Sort<Integer> sort = SortFactory.createCompare(SortType.RADIX_SORT.getType(), IntegerCompare.class);
        Integer[] resultArr = sort.sort(arr);
        for (Integer integer : resultArr) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }

}