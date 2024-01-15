package springproject.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "recruitment")
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private String created;

    @Column(name = "experience")
    private String experience;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "salary")
    private String salary;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "view")
    private int view;

    @Column(name = "deadline")
    private String deadline;

    @OneToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;


    public Recruitment() {
        this.created = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    public Recruitment(int id, String address, String description,
                       String experience, String quantity,  String salary,
                       String title, String type, int view, String deadline,
                       Category category, Company company) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.created = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        this.experience = experience;
        this.quantity = quantity;
        this.salary = salary;
        this.title = title;
        this.type = type;
        this.view = view;
        this.deadline = deadline;
        this.category = category;
        this.company = company;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", experience='" + experience + '\'' +
                ", quantity='" + quantity + '\'' +
                ", salary='" + salary + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", view=" + view +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
