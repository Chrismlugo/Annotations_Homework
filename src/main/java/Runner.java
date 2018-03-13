import DB.DBHelper;
import models.File;
import models.Folder;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("important_stuff");
        DBHelper.save(folder1);


        File file1 = new File("CV", "txt", 125, folder1);
        DBHelper.save(file1);
    }
}
