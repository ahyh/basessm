package designPattern.test.visitor;

/**
 * 文件类
 */
public abstract class File {

    //文件路径
    private String path;

    //文件大小
    private Long size;

    public File(String path, Long size) {
        this.path = path;
        this.size = size;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "File{" +
                "path='" + path + '\'' +
                ", size=" + size +
                '}';
    }

    public abstract void accept(Visitor visitor);
}
