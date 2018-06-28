package algorithm.bag;

/**
 * 处理的类
 */
public class Detail {

    private Long id;
    private String name;
    private Integer qty;

    public Detail() {
    }

    public Detail(Long id, String name, Integer qty) {
        this.id = id;
        this.name = name;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
