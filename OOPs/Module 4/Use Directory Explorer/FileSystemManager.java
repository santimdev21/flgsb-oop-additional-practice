import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileSystemManager - A command-line file management system
 * 
 * This class provides a shell-like interface for managing files and directories
 */
class FileSystemManager {
    
    // The current working directory
    private File currentDirectory;
    
    // Scanner for user input
    private Scanner scanner;
    
    // Date formatter for file timestamps
    private SimpleDateFormat dateFormat;
    
    /**
     * Constructor to initialize the file system manager
     */
    public FileSystemManager() {
        // TODO: Initialize the current directory to the user's current directory
        // Hint: Use System.getProperty("user.dir") to get the current working directory
        this.currentDirectory = new File(System.getProperty("user.dir"));
        
        // TODO: Initialize the scanner for reading user input
        this.scanner = new Scanner(System.in);
        
        // TODO: Initialize the date formatter for displaying timestamps
        // Hint: Use "yyyy-MM-dd HH:mm:ss" as the date format pattern
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * Start the file system manager
     */
    public void start() {
        System.out.println("Welcome to the File System Manager!");
        System.out.println("Type 'help' to see available commands.");
        
        boolean running = true;
        while (running) {
            // TODO: Display the current directory path as a prompt
            System.out.println(this.currentDirectory);
            
            // TODO: Read user command
            String command = this.scanner.nextLine();
            
            // TODO: Process the command
            // If command is "exit", set running to false
            // Otherwise, call processCommand() method
            running = processCommand(command);
        }
        
        // TODO: Close the scanner before exiting
    }
    
    /**
     * Process a user command
     * 
     * @param command The command entered by the user
     * @return true to continue, false to exit
     */
    private boolean processCommand(String command) {
        // Split the command into parts (command name and arguments)
        String[] parts = command.trim().split("\\s+", 2);
        String commandName = parts[0].toLowerCase();
        String args = (parts.length > 1) ? parts[1] : "";
        
        switch (commandName) {
            case "help":
                displayHelp();
                break;
            case "ls":
                listFiles();
                // TODO: Implement listing files and directories
                break;
            case "cd":
                changeDirectory(parts[1]);
                // TODO: Implement changing directories
                // Hint: Handle "cd .." (parent directory) and "cd directoryName"
                break;
            case "pwd":
                displayFileInfo(parts[1]);
                // TODO: Implement displaying current directory path
                break;
            case "mkdir":
                createDirectory(parts[1]);
                // TODO: Implement creating a new directory
                break;
            case "touch":
                // TODO: Implement creating a new file
                createFile(parts[1]);
                break;
            case "rm":
                // TODO: Implement deleting a file or directory
                delete(parts[1]);
                break;
            case "rename":
                // TODO: Implement renaming a file or directory
                // Hint: The args will contain both old and new names
                String names[] = parts[1].split("//");
                if(names.length != 2)  {
                    System.out.println("Invalid arguments, enter two arguments");
                    break;
                }
                
                rename(names[0], names[1]);
                break;
            case "find":
                // TODO: Implement searching for files by name pattern
                findFiles(parts[1]);
                break;
            case "info":
                // TODO: Implement displaying file information
                displayFileInfo(parts[1]);
                break;
            case "exit":
                return false;
            default:
                System.out.println("Unknown command. Type 'help' for available commands.");
        }
        
        return true;
    }
    
    /**
     * Display help information
     */
    private void displayHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  help               - Display this help message");
        System.out.println("  ls                 - List files in current directory");
        System.out.println("  cd <directory>     - Change to specified directory (use .. for parent)");
        System.out.println("  pwd                - Print current directory path");
        System.out.println("  mkdir <name>       - Create a new directory");
        System.out.println("  touch <name>       - Create a new file");
        System.out.println("  rm <name>          - Delete a file or directory");
        System.out.println("  rename <old> <new> - Rename a file or directory (use a '//' to separate the names)");
        System.out.println("  find <pattern>     - Search for files matching pattern");
        System.out.println("  info <name>        - Display file information");
        System.out.println("  exit               - Exit the program");
    }
    
    /**
     * List files and directories in the current directory
     */
    private void listFiles() {
        // TODO: Get the list of files and directories in the current directory
        File[] files = this.currentDirectory.listFiles();
        
        if(files.length == 0) {
            System.out.println("The current directory is empty");
        } else {
            for(int i = 0; i < files.length; i++) {
                if(files[i].isFile()) {
                    System.out.println("- " + files[i].getName());
                } else {
                    System.out.println("d " + files[i].getName());
                }
            }
        }
        
        // TODO: Display the list of files and directories
        // For each file, show:
        // - 'd' if it's a directory or '-' if it's a file
        // - The file name
    }
    
    /**
     * Change to a different directory
     * 
     * @param dirName The name of the directory to change to
     */
    private void changeDirectory(String dirName) {
        // TODO: Implement changing to a directory
        // If dirName is "..", go to parent directory
        // Otherwise, change to the specified directory if it exists
        if(dirName.equals("..")) {
            this.currentDirectory = this.currentDirectory.getParentFile();
            return;
        }
        
        File newDir = new File(dirName);
                
        if(newDir.exists() && newDir.isAbsolute()) {
            if(newDir.isDirectory()) {
                this.currentDirectory = newDir;
            } else {
                System.out.println("Directory is a file.");
            }
        } else {
            System.out.println("Directory does not exist or is not a valid path.");
        }
    }
    
    /**
     * Create a new directory
     * 
     * @param dirName The name of the directory to create
     */
    private void createDirectory(String dirName) {
        // TODO: Implement creating a new directory
        // Create a new directory with the given name in the current directory
        File newDir = new File(dirName);
        
        if(!(newDir.exists()) && newDir.isAbsolute()) {
            if(newDir.mkdirs()) {
                System.out.println("Directory successfully created!");
            } else {
                System.out.println("The directory could not be created.");
            }
        } else {
            System.out.println("Directory already exists or is not a valid path.");
        }
    }
    
    /**
     * Create a new file
     * 
     * @param fileName The name of the file to create
     */
    private void createFile(String fileName) {
        // TODO: Implement creating a new file
        // Create a new empty file with the given name in the current directory
        String path = currentDirectory.getAbsolutePath().concat("\\").concat(fileName);
        File file = new File(path);
        
        if(file.exists()) {
            if(file.isFile()) {
                System.out.println("File already exists. Do you want to overwrite it?" + "\n1. Yes" + "\n2. Any other key to exit");

                String userOption = this.scanner.nextLine();

                if(userOption.equals("1")) {
                    try {
                        file.delete();
                        file.createNewFile();
                        System.out.println("File successfully overwritten!");
                    } catch (IOException ioe) {
                        System.out.println("Unable to overwrite file: " + ioe.getMessage());
                    }
                } else {
                    System.out.println("Directory not created");
                }
            }
        } else {
            try {
                file.createNewFile();
                System.out.println("File successfully created!");
            } catch (IOException ioe) {
                System.out.println("Unable to create file: " + ioe.getMessage());
            }
        }
    }
    
    /**
     * Delete a file or directory
     * 
     * @param name The name of the file or directory to delete
     */
    private void delete(String name) {
        // TODO: Implement deleting a file or directory
        // If it's a directory, provide a warning and confirm deletion
        File file = new File(name);
        
        if(file.exists()) {
            if(file.isFile()) {
                if(file.delete()) {
                    System.out.println("File successfully deleted!");
                } else {
                    System.out.println("Unable to delete file. ");
                }
            } else {
                System.out.println("Do you want to delete directory: " + "\n1. Yes" + "\n2. Any other key to exit");

                String userOption = scanner.nextLine();

                if(userOption.equalsIgnoreCase("1")) {
                    if(file.delete()) {
                        this.currentDirectory = this.currentDirectory.getParentFile();

                        System.out.println("Directory successfully deleted!");
                    } else {
                        System.out.println("Unable to delete directory.");
                    }
                } else {
                    System.out.println("Directory not deleted");
                }
            }
        } else {
            System.out.println("The file or directory does not exists");
        }
    }
    
    /**
     * Rename a file or directory
     * 
     * @param oldName The current name of the file or directory
     * @param newName The new name for the file or directory
     */
    private void rename(String oldName, String newName) {
        // TODO: Implement renaming a file or directory
        String oldPath = this.currentDirectory.getAbsolutePath().concat("\\").concat(oldName);
        String newPath = this.currentDirectory.getAbsolutePath().concat("\\").concat(newName);
        
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        if(oldFile.exists()) {
            if(oldFile.renameTo(newFile)) {
                System.out.println("File renamed to: " + newFile.getAbsolutePath());
            } else {
                System.out.println("Unable to rename file");
            }
        } else {
            System.out.println("The directory or file does not exist");
        }
    }
    
    /**
     * Search for files matching a pattern
     * 
     * @param pattern The pattern to search for
     */
    private void findFiles(String pattern) {
        // TODO: Implement searching for files by name pattern
        // Use recursive method to search through directories
        
        File files[] = this.currentDirectory.listFiles();
        
        for(int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            
            if(files[i].isFile() && fileName.equals(pattern)) {
                System.out.println("File found: " + files[i].getAbsolutePath());
            } else if(files[i].isDirectory() ) {
                this.currentDirectory = new File(files[i].getAbsolutePath());
                findFiles(pattern); 
            }
        }
        
        this.currentDirectory = new File(System.getProperty("user.dir"));

    }
    
    /**
     * Display detailed information about a file
     * 
     * @param fileName The name of the file to display information for
     */
    private void displayFileInfo(String fileName) {
        // TODO: Implement displaying file information
        // Show file size, last modified date, whether it's a directory, etc.
        File file = new File(fileName);
        
        if(file.isFile()) {
            System.out.println("File size: " + file.length() + "\nLast time modified: " + dateFormat.format(file.lastModified()));
        } else if(file.isDirectory()) {
            System.out.println("Directory size: " + file.length() + "\nLast time modified: " + dateFormat.format(file.lastModified()));
        } else {
            System.out.println("File or directory not found");
        }
    }
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        FileSystemManager manager = new FileSystemManager();
        manager.start();
    }
}
