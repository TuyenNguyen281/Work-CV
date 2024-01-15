package springproject.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="address")
    private String address;

    @Column(name="description")
    private String description;

    @Column(name="email")
    private String email;

    @Column(name="logo")
    private String logo;

    @Column(name="name_company")
    private String nameCompany;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="status")
    private String status;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Recruitment> recruitmentList;

    @Transient
    private MultipartFile multipartFile; // @Transient giúp ko tạo cột của trường này trong database


    public Company() {
        this.status = "NONACTIVE";
    }

    public Company(int id, String address, String description, String email, String logo, String nameCompany, String phoneNumber, User user) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.email = email;
        this.logo = logo;
        this.nameCompany = nameCompany;
        this.phoneNumber = phoneNumber;
        this.status = "NONACTIVE";
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public List<Recruitment> getRecruitmentList() {
//        return recruitmentList;
//    }
//
//    public void setRecruitmentList(List<Recruitment> recruitmentList) {
//        this.recruitmentList = recruitmentList;
//    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", logo='" + logo + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
