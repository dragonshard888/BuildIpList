package ru.ListIPAddress;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Family on 24.12.2016.
 */
public class SolutionTest {
    @Test
    public void testCompareIpStructure() throws Exception {
        Solution solution = new Solution();
        int[] ip1 = {1,1,1,1};
        int[] ip2 = {1,1,1,5};
        int[] ip3 = {1,1,1,5};
        Assert.assertEquals(false,solution.compareIpStructure(ip1,ip2));
        Assert.assertEquals(true,solution.compareIpStructure(ip2,ip3));

    }

}