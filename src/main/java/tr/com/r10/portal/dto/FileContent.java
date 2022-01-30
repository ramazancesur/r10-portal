package tr.com.r10.portal.dto;

import tr.com.r10.portal.enums.FileType;

public class FileContent extends BaseDTO {
    private Long fileID;
    private String contentURL;
    private FileType contentType;

    public Long getFileID() {
        return fileID;
    }

    public void setFileID(Long fileID) {
        this.fileID = fileID;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }

    public FileType getContentType() {
        return contentType;
    }

    public void setContentType(FileType contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileContent)) return false;

        FileContent that = (FileContent) o;

        return fileID != null ? fileID.equals(that.fileID) : that.fileID == null;
    }

    @Override
    public int hashCode() {
        return fileID != null ? fileID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FileContent{" +
                "fileID=" + fileID +
                ", contentURL='" + contentURL + '\'' +
                ", contentType=" + contentType +
                '}';
    }
}