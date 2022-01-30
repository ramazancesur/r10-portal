package tr.com.r10.portal.converter;

import org.springframework.stereotype.Component;
import tr.com.r10.portal.dto.FileContent;
import tr.com.r10.portal.model.FileEntity;

import java.util.Objects;

@Component
public class FileContentConverter implements Converter<FileEntity, FileContent> {
    @Override
    public FileEntity convertToEntity(FileContent fileContent) {
        if (Objects.isNull(fileContent)) {
            return null;
        }
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileType(fileContent.getContentType());
        fileEntity.setFileURL(fileContent.getContentURL());
        fileEntity.setCreatedDate(fileContent.getCreatedDate());
        fileEntity.setUpdatedDate(fileContent.getUpdatedDate());
        fileEntity.setFileURL(fileContent.getContentURL());
        return fileEntity;
    }

    @Override
    public FileContent convertToDTO(FileEntity fileEntity) {
        if (Objects.isNull(fileEntity)) {
            return null;
        }
        FileContent fileContent = new FileContent();
        fileContent.setContentType(fileEntity.getFileType());
        fileContent.setContentURL(fileEntity.getFileURL());
        fileContent.setCreatedDate(fileEntity.getCreatedDate());
        fileContent.setUpdatedDate(fileEntity.getUpdatedDate());
        fileContent.setContentURL(fileEntity.getFileURL());
        return fileContent;
    }
}