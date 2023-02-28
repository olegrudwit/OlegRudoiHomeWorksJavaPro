package apps.hw7hashMap;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> navigator = new HashMap<>();

    public boolean add(String path, FileData file) {
        if (!path.equals(file.getPath())) {
            System.out.println("Values of key \"path\"=" + path + " and \"path\"="
                    + file.getPath() + " in fileData are not equal. Adding failed.");
            return false;
        }
        if (navigator.containsKey(path)) {
            addValueToKey(path, file);
        } else {
            addNewDataEntry(path, file);
        }
        return true;
    }

    public List<FileData> find(String path) {
        if (navigator.containsKey(path)) {
            return navigator.get(path);
        }
        return null;
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredValues = new ArrayList<>();
        for (var files : navigator.values()) {
            for (FileData file : files) {
                if (file.getSize() < maxSize) {
                    filteredValues.add(file);
                }
            }
        }
        return filteredValues.isEmpty() ? null : filteredValues;
    }

    public boolean remove(String path) {
        navigator.remove(path);
        return true;
    }

    public List<FileData> sortBySize() {
        List<FileData> filesAll = new ArrayList<>();
        for (List<FileData> files : navigator.values()) {
            filesAll.addAll(files);
        }

        List<FileData> filesSorted = bubbleSortByFileSize(filesAll.toArray(new FileData[0]));

        return filesSorted.isEmpty() ? null : filesSorted;
    }

    public List<FileData> bubbleSortByFileSize(FileData[] array) {
        if (array.length == 0) {
            return null;
        }

        boolean isSorted = false;
        FileData temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i].getSize() > array[i + 1].getSize()) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        return Arrays.asList(array);
    }

    private void addValueToKey(String path, FileData file) {
        List<FileData> fileData = navigator.get(path);
        fileData.add(file);

        navigator.replace(file.getPath(), fileData);
    }

    private void addNewDataEntry(String path, FileData file) {
        navigator.put(path, new ArrayList<>(List.of(file)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileNavigator that = (FileNavigator) o;

        return navigator.equals(that.navigator);
    }

    @Override
    public int hashCode() {
        return navigator.hashCode();
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "navigator=" + navigator +
                '}';
    }
}