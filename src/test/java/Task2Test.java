import org.junit.Assert;
import org.junit.Test;

public class Task2Test {


    @Test
    public void getArrayOfIntegersFromStringLineTest(){
        //given
        String line = "1 2 3 4 5 6 7 8 9 0";
        int[] expected = {1,2,3,4,5,6,7,8,9,0};
        //when
        int[] intsFromLine = Task2.getArrayOfIntegersFromStringLine(line);
        //then
        for (int i =0; i<=expected.length-1; i++){
            Assert.assertEquals(expected[i], intsFromLine[i]);
        }
    }
}
