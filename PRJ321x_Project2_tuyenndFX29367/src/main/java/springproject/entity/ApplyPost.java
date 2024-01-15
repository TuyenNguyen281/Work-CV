package springproject.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name ="apply_post")
public class ApplyPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name ="created")
    private String created;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="recruitment_id")
    private Recruitment recruitment;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name= "link_cv")
    private String linkCv;

    @Column(name="status")
    private int status;

    @Column(name="text")
    private String text;

    public ApplyPost() {
        this.created = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        this.status = 0;
    }

    public ApplyPost(int id, Recruitment recruitment, User user, String linkCv, String text) {
        this.id = id;
        this.created = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        this.recruitment = recruitment;
        this.user = user;
        this.linkCv = linkCv;
        this.status = 0;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLinkCv() {
        return linkCv;
    }

    public void setLinkCv(String linkCv) {
        this.linkCv = linkCv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
