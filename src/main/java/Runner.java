import DB.DBHelper;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner = new Owner("Denny Dillon", "D3ND1LL");
        DBHelper.save(owner);

        Folder folder1 = new Folder("important_stuff", owner);
        DBHelper.save(folder1);

        Folder folder2 = new Folder("Java", owner);
        DBHelper.save(folder2);


        File file1 = new File("CV", "txt", 125, folder1);
        DBHelper.save(file1);

        File file2 = new File("bank_statement","txt", 80, folder1);
        DBHelper.save(file2);

        File file3 = new File("project_1", "Ruby", 800, folder1 );
        DBHelper.save(file3);

        List<File> files = DBHelper.getAll(File.class);

        List<File> folderFiles = DBHelper.getFilesFromFolder(folder1);

        List<Folder> foundFolders = DBHelper.getFoldersFromOwner(owner);


    }
}
