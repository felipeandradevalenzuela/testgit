import java.io.File;
import java.util.Scanner;


public class App {
    static String absPath = "D:\\PROJECTS\\Java Class\\Princeton\\";

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] arr = new int[] {1,0,2,3,0,4,5,0};
        Solution.duplicateZeros(arr);
        System.out.println("Creador de carpetas y archivos.");
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique la ruta donde desea guardar los archivos: ");
        absPath = scanner.nextLine() + "\\";
        while (!exit) {
            exit = create(scanner);
       }
       scanner.close();
    }

    public static boolean create (Scanner scanner) {
        System.out.print("Nombre de la carpeta y archivos o 'salir' para finalizar: ");
        String inpuString = scanner.nextLine();
        if (inpuString.equalsIgnoreCase("salir")) {
            return true;
        }
        createFolder(inpuString);
        createFile(inpuString, scanner);
        return false;
    }

    public static void createFile (String fileName, Scanner scanner) {
        String path = absPath+fileName+"\\";
        System.out.println("Indique las extensiones que requiere separadas por un espacio: ");
        String extensions = scanner.nextLine();
        // String[] files = {"java", "html"};
        String[] files = extensions.split(" ");
        for (String ext : files) {
            File file = new File(path+fileName+"."+ext);
            process("File", file);
        }
    }

    public static void createFolder (String folderName) {
        String path = absPath+folderName;
        File file = new File(path);
        process("Folder", file);
    }

    public static void process (String kind, File file) {
        boolean result;
        try {
            if ("Folder".equals(kind)) {
                result = file.mkdir();
            } else {
                result = file.createNewFile();
            }
            if (result) {
                System.out.println(kind+" created " + file.getCanonicalPath());
            } else {
                System.out.println(kind+" already exist at location: " + file.getCanonicalPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
