package yanhuan.test;

import org.junit.Test;

/**
 * Created by yanhuan1 on 2018/3/25.
 */
public class FriendTest {

    @Test
    public void test() {
        int[][] friends = new int[6][6];
        friends[0][1] = 1;
        friends[0][5] = 1;
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = 0; j < friends[i].length - 1; j++) {
                System.out.print(friends[i][j]);
            }
        }
    }


}
