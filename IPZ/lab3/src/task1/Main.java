package task1;

/**
 * Demo for Variant 3 (FileSystemItem):
 * Examples covered:
 *  - single file size;
 *  - folder with files;
 *  - nested folders; total size recalculation.
 */
public class Main {
    public static void main(String[] args) {
        FileItem readme = new FileItem("README.md", 1024);
        System.out.println("Example 1: single file size");
        readme.print("");
        System.out.println("Total size = " + readme.getSize() + " B\n");

        Folder src = new Folder("src");
        src.add(new FileItem("Main.java", 2300));
        src.add(new FileItem("Utils.java", 1800));
        System.out.println("Example 2: folder with files");
        src.print("");
        System.out.println("Total size = " + src.getSize() + " B\n");

        Folder images = new Folder("images");
        images.add(new FileItem("logo.png", 12_345));
        images.add(new FileItem("banner.jpg", 98_765));

        Folder project = new Folder("project");
        project.add(src);
        project.add(images);
        project.add(new FileItem("pom.xml", 750));

        System.out.println("Example 3: nested folders");
        project.print("");
        System.out.println("Total size = " + project.getSize() + " B");
    }
}