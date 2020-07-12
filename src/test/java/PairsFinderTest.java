import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class PairsFinderTest {

    @Test
    public void findPairsTestValidInput(){
        //given
        //pairs:5-8, 5-8, 6-7, 6-7,
        PairsFinder pairsFinder = new PairsFinder(13);
        int[] ints = {1,2,3,5,8,6,7,7,6,8,5,13,114,14};
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
    @Test
    public void findPairsTestEveryNumMatches(){
        //given
        PairsFinder pairsFinder = new PairsFinder(13);
        int[] ints = {1,2,3,12,11,10};
        //when
        pairsFinder.findPairs(ints);
        //then
        Assert.assertEquals(1, pairsFinder.getPairs().get(0).getSmallInt());
        Assert.assertEquals(12, pairsFinder.getPairs().get(0).getBigInt());

        Assert.assertEquals(2, pairsFinder.getPairs().get(1).getSmallInt());
        Assert.assertEquals(11, pairsFinder.getPairs().get(1).getBigInt());

        Assert.assertEquals(3, pairsFinder.getPairs().get(2).getSmallInt());
        Assert.assertEquals(10, pairsFinder.getPairs().get(2).getBigInt());
    }

    @Test
    public void findPairsTestNoMatch(){
        //given
        PairsFinder pairsFinder = new PairsFinder(13);
        int[] ints = {13, 1, 2, 3,9, 8 ,7};
        //when
        pairsFinder.findPairs(ints);
        //then
        Assert.assertEquals(0, pairsFinder.getPairs().size());
    }

    @Test
    public void findPairsTestMoreSmallNums(){
        //given
        //1 2 3 4 5 6 7 8 9 3 6 5 6 5 4 8 2 4 5 4 8 98 54 25 10 11 12 13 0
        PairsFinder pairsFinder = new PairsFinder(13);
        int[] ints= {1,2,3,4,5,6,7,8,9,10,11,12,1,1,2,3,4,5,5,4};
        //when
        pairsFinder.findPairs(ints);
        //then
        Assert.assertEquals(6, pairsFinder.getPairs().size());
    }

    @Test
    public void findPairsTestMoreBigNums(){
        //given
        PairsFinder pairsFinder = new PairsFinder(13);
        int[] ints = {1,2,3,4,5,6,12,11,10,9,8,7,10,11,13,9,111,111,111};
        //when
        pairsFinder.findPairs(ints);
        //then
        Assert.assertEquals(6, pairsFinder.getPairs().size());
    }
}
