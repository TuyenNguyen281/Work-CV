package springproject.model;

import org.springframework.web.multipart.MultipartFile;

public class ApplyJobModel {

    private int userId;
    private int recruitmentId;
    private String text;
    private MultipartFile file;

    public ApplyJobModel() {
    }

    public ApplyJobModel(int userId, int recruitmentId, String text) {
        this.userId = userId;
        this.recruitmentId = recruitmentId;
        this.text = text;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ApplyJobModel(int userId, int recruitmentId, String text, MultipartFile file) {
        this.userId = userId;
        this.recruitmentId = recruitmentId;
        this.text = text;
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
