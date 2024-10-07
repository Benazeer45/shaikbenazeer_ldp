package Java_Assignments.Assignment1;
import java.io.File;

public class FileSearcher {

    public void searchFiles(String directoryPath, String regex) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Error: The directory path does not exist. Please try again.");
            return;
        } else if (!directory.isDirectory()) {
            System.out.println("Error: The path is not a directory. Please provide a valid directory.");
            return;
        }

        RegexFileFilter fileFilter = new RegexFileFilter(regex);
        searchRecursive(directory, fileFilter);
    }

    private void searchRecursive(File file, RegexFileFilter fileFilter) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    searchRecursive(f, fileFilter);
                }
            }
        } else {
            if (fileFilter.accept(file)) {
                System.out.println("Match found: " + file.getAbsolutePath());
            }
        }
    }
}
