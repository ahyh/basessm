package algorithm.sort;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * 比较对象
 */
public class AnyType implements Comparable<AnyType> {

    private Integer qty;

    private String name;

    public AnyType() {
    }

    public AnyType(Integer qty, String name) {
        this.qty = qty;
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnyType{" +
                "qty=" + qty +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(AnyType o) {
        Preconditions.checkArgument(o != null, "o cannot null!");
        if (o instanceof AnyType) {
            AnyType anyType = (AnyType) o;
            if (anyType.getQty() != null) {
                return this.getQty().compareTo(anyType.getQty());
            }
            if (StringUtils.isNoneEmpty(this.getName())) {
                return this.getName().compareTo(anyType.getName());
            }
            return 0;
        }
        throw new RuntimeException("Cannot support Comparable!");
    }
}
