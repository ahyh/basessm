package yanhuan.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void testJson(){
        SplitDto splitDto = new SplitDto();
        splitDto.setOrgNo("6");
        splitDto.setDistributeNo("6");
        splitDto.setWarehouseNo("80");
        splitDto.setCodeList(Lists.newArrayList("582161225111161","582161225111162","582161225111163"));
        System.out.println(JSON.toJSONString(splitDto));
    }


}

class SplitDto{

    private String orgNo;

    private String distributeNo;

    private String warehouseNo;

    private List<String> codeList;

    private String desNo;

    private String containerNo;

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getDistributeNo() {
        return distributeNo;
    }

    public void setDistributeNo(String distributeNo) {
        this.distributeNo = distributeNo;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getDesNo() {
        return desNo;
    }

    public void setDesNo(String desNo) {
        this.desNo = desNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }
}
