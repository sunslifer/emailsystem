package org.perscholas.emailsystem.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.emailsystem.dao.AttachmentsRepo;
import org.perscholas.emailsystem.models.Attachments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AttachmentsServices {

    private AttachmentsRepo attachmentsRepo;

    @Autowired
    public AttachmentsServices(AttachmentsRepo attachmentsRepo){ this.attachmentsRepo = attachmentsRepo; }

    public void addAttachment(String file, String name) {
        Attachments attachments = new Attachments();
        attachments.setFile(file);
        attachments.setName(name);

        attachmentsRepo.save(attachments);
    }

    public List<Attachments> getAllAttachments(){ return attachmentsRepo.findAll(); }
}
