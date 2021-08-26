package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.FoldersRepo;
import org.perscholas.emailsystem.models.Folders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FoldersServices{

    private FoldersRepo foldersRepo;

    @Autowired
    public FoldersServices(FoldersRepo foldersRepo) { this.foldersRepo = foldersRepo; }

    public void addFolder(String name){
        Folders folder = new Folders();
        folder.setName(name);

        foldersRepo.save(folder);
    }

    public List<Folders> getAllFolders() { return foldersRepo.findAll(); }

    public List<Folders> getFolderByName(String name) { return foldersRepo.findFoldersByName(name); }

}
