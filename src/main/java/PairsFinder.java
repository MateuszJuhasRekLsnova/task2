import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PairsFinder {
    private final int SUM_VALUE;
    private List<PairOfIntegers> pairs;

    public PairsFinder() {
        this.SUM_VALUE = 13;
        pairs = new LinkedList<>();
    }

    public PairsFinder(int SUM_VALUE) {
        this.SUM_VALUE = SUM_VALUE;
        pairs = new LinkedList<>();
    }

    public List<PairOfIntegers> getPairs() {
        return pairs;
    }

    public void findPairs(int[] arrayOfInts) {
        TwoArraysOfInts twoArraysOfInts = divideArrayForSmallAndBigInts(arrayOfInts);
        assignPairsFromTwoArrays(twoArraysOfInts);
    }

    private void assignPairsFromTwoArrays(TwoArraysOfInts twoArraysOfInts) {
        Iterator<Integer> smallIntsIterator = twoArraysOfInts.smallInts.iterator();
        while (smallIntsIterator.hasNext()){
            Integer smallInt = smallIntsIterator.next();
            Iterator<Integer> bigIntsIterator = twoArraysOfInts.bigInts.iterator();
            while (bigIntsIterator.hasNext()){
                Integer bigInt = bigIntsIterator.next();
                int requiredValue = SUM_VALUE- smallInt;
                if(bigInt == requiredValue){
                    pairs.add(new PairOfIntegers(smallInt, bigInt));
                    smallIntsIterator.remove();
                    bigIntsIterator.remove();
                    break;
                }else if (bigInt<requiredValue){
                    break;
                }
            }
        }
    }

    private TwoArraysOfInts divideArrayForSmallAndBigInts(int[] arrayOfInts) {
        TwoArraysOfInts twoArraysOfInts = new TwoArraysOfInts();
        for (int integerToAssign : arrayOfInts) {
            if (integerToAssign > SUM_VALUE / 2) {
                twoArraysOfInts.bigInts.add(integerToAssign);
            } else {
                twoArraysOfInts.smallInts.add(integerToAssign);
            }
        }
        twoArraysOfInts.smallInts.sort(Integer::compareTo);
        twoArraysOfInts.bigInts.sort(new IntegerDescendingComparator());
        return twoArraysOfInts;
    }


    private class TwoArraysOfInts {
        List<Integer> smallInts;
        List<Integer> bigInts;

        private TwoArraysOfInts() {
            smallInts = new LinkedList<>();
            bigInts = new LinkedList<>();
        }
    }

    private class IntegerDescendingComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    }
}
