package task1;

/**
 * Leaf (Composite pattern): regular file with fixed size.
 */
public class FileItem implements FileSystemItem {
    private final String name;
    private final long size;

    /**
     * @param name file name
     * @param size file size in bytes
     */
    public FileItem(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        System.out.println("[TRACE] File '" + name + "' size = " + size + " B");
        return size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "- " + name + " (" + size + " B)");
    }
}