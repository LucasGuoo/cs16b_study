
import org.junit.Test;
import static org.junit.Assert.*;

public class IntListTest {
    @Test
    public void testList(){
        IntList A = IntList.list(1,3,6,10);
        IntList exp1 = IntList.list(1,3,6,10);
        assertEquals(exp1,A);
    }
    @Test
    public void testSkippify(){
        IntList A = IntList.list(1,2,3,4,5,6,7,8,9,10);
        A.skippify();
        IntList exp1 = IntList.list(1,3,6,10);
        assertEquals(exp1,A);

        IntList B = IntList.list(9,8,7,6,5,4,3,2,1);
        B.skippify();
        IntList exp2 = IntList.list(9,7,4);
        assertEquals(exp2,B);
    }

    @Test
    public void testRemoveDuplicates(){
        IntList A = IntList.list(1,2,2,2,3);
        IntList.removeDuplicates(A);
        IntList exp1 = IntList.list(1,2,3);
        assertEquals(exp1, A);
    }

}
