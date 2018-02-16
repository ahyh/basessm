package designPattern.test.state;

import java.io.Serializable;

/**
 * 处理结果
 */
public class Result implements Serializable {

    private int resultCode;

    private String resultMsg;

    private Object resultValue;

    public Result() {
    }

    public Result(int resultCode, String resultMsg, Object resultValue) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultValue = resultValue;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultValue() {
        return resultValue;
    }

    public void setResultValue(Object resultValue) {
        this.resultValue = resultValue;
    }

}
