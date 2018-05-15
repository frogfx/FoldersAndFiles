import db.DBFolder;
import db.DBHelper;
import db.DBOwner;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("Bob", "808");
        DBHelper.save(owner1);

        Folder folder1 = new Folder("folder1", owner1);
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

        List<Folder> foldersFromOwner = DBOwner.getFoldersFromOwner(owner1);
    }
}
