import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PairsFinderTest {

    @Test
    public void findPairsTest(){
        PairsFinder pairsFinder = new PairsFinder(13);
        //given
        //pairs:5-8, 5-8, 6-7, 6-7,
        int[] ints = {1,2,3,5,8,6,7,7,6,8,5};
        //when
        pairsFinder.findPairs(ints);
        List<PairOfIntegers> pairs = pairsFinder.getPairs();
        //then
        Assert.assertEquals(5, pairs.get(0).getSmallInt());
        Assert.assertEquals(8, pairs.get(0).getBigInt());

        Assert.assertEquals(5, pairs.get(1).getSmallInt());
        Assert.assertEquals(8, pairs.get(1).getBigInt());

        Assert.assertEquals(6, pairs.get(2).getSmallInt());
        Assert.assertEquals(7, pairs.get(2).getBigInt());

        Assert.assertEquals(6, pairs.get(3).getSmallInt());
        Assert.assertEquals(7, pairs.get(3).getBigInt());
    }
}
