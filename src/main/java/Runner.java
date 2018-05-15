import db.DBFolder;
import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {



        Folder folder1 = new Folder("folder1");
        DBHelper.save(folder1);
        File file1 = new File("file1", ".txt", 20.00, folder1);
        DBHelper.save(file1);
        File file2 = new File("file2", ".txt", 10.00, folder1);
        DBHelper.save(file2);
        DBHelper.delete(file1);

        file2.setName("filee2");
        DBHelper.save(file2);

        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(Folder.class);

        Folder foundfolder = DBHelper.find(Folder.class, folder1.getId());

        List<File> filesFromFolder = DBFolder.getFiles(folder1);
    }
}
