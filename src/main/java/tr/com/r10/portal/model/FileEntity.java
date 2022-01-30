package tr.com.r10.portal.model;

import tr.com.r10.portal.enums.FileType;

import javax.persistence.*;

@Entity
@Table(name = "FILE")
public class FileEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String fileURL;
    @Enumerated(EnumType.STRING)
    @Column
    private FileType fileType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEntity that = (FileEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (fileURL != null ? !fileURL.equals(that.fileURL) : that.fileURL != null) return false;
        return fileType == that.fileType;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (fileURL != null ? fileURL.hashCode() : 0);
        result = 31 * result + (fileType != null ? fileType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "name='" + name + '\'' +
                ", fileURL='" + fileURL + '\'' +
                ", fileType=" + fileType +
                '}';
    }
}