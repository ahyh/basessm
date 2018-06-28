package designPattern.test.facade;

import java.io.Serializable;

/**
 * 返回结果
 */
public class Result implements Serializable {

    //返回码
    private Integer resultCode;

    //返回结果
    private Object resultValue;

    //成功或失败信息
    private boolean successFlag;

    public Result() {
    }

    public Result(Integer resultCode, Object resultValue, boolean successFlag) {
        this.resultCode = resultCode;
        this.resultValue = resultValue;
        this.successFlag = successFlag;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Object getResultValue() {
        return resultValue;
    }

    public void setResultValue(Object resultValue) {
        this.resultValue = resultValue;
    }

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", resultValue=" + resultValue +
                ", successFlag=" + successFlag +
                '}';
    }
}
