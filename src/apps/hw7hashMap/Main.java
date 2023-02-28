package apps.hw7hashMap;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        System.out.println(navigator);
        System.out.println("\nnavigator.add:");

        navigator.add("path/to/file", new FileData("one", 5000, "path/to/file"));
        navigator.add("path/to/file", new FileData("two", 100, "path/to/file"));
        navigator.add("path/to/file2", new FileData("three", 1500, "path/to/file2"));
        navigator.add("path/to/file3", new FileData("four", 6, "path/to/file3"));
        navigator.add("path/to/file7", new FileData("seven", 6, "path/to/file7"));

        navigator.add("path/to/file300", new FileData("five", 1200, "path/to/file1"));
        navigator.add("path/to/file", new FileData("six", 1200, "path/to/file"));

        System.out.println("\n" + navigator);

        System.out.println("\nnavigator.find(\"path/to/file\"):");
        System.out.println(navigator.find("path/to/file"));

        System.out.println("\nnavigator.filterBySize(4000):");
        System.out.println(navigator.filterBySize(4000));

        System.out.println("\nnavigator.remove(\"path/to/file7\":)");
        System.out.println(navigator.remove("path/to/file7"));

        System.out.println("\nnavigator.sortBySize()");
        System.out.println(navigator.sortBySize());
    }
}
