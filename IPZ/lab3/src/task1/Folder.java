package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Composite (Composite pattern): folder that can contain other items.
 */
public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a child item to this folder.
     * Business logic is simplified to tracing output as per the task requirements.
     */
    public void add(FileSystemItem item) {
        System.out.println("[TRACE] Add '" + item.getName() + "' to folder '" + name + "'");
        children.add(item);
    }

    /** Removes a child by reference (if present). */
    public void remove(FileSystemItem item) {
        System.out.println("[TRACE] Remove '" + item.getName() + "' from folder '" + name + "'");
        children.remove(item);
    }

    /** Returns an unmodifiable snapshot of children (for tests/demos). */
    public List<FileSystemItem> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public long getSize() {
        System.out.println("[TRACE] Calc size of folder '" + name + "'...");
        long total = 0L;
        for (FileSystemItem child : children) {
            total += child.getSize();
        }
        System.out.println("[TRACE] Folder '" + name + "' total = " + total + " B");
        return total;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "+ [" + name + "]");
        String childIndent = indent + "  ";
        for (FileSystemItem child : children) {
            child.print(childIndent);
        }
    }
}