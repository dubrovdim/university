package task1;

/**
 * Component (Composite pattern).
 * Represents a common interface for file system items (files and folders).
 */
public interface FileSystemItem {
    /** @return item's name */
    String getName();

    /**
     * Business method stub: supposed to return item size in bytes.
     * For this practical work we implement logic and also print trace messages.
     * @return total size of this item (for files — own size, for folders — sum of children)
     */
    long getSize();

    /**
     * Utility demo method: pretty-print the structure.
     * @param indent visual indentation
     */
    void print(String indent);
}