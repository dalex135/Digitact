package Digitact.Backend.Model.User;

import Digitact.Backend.Model.Education;
import Digitact.Backend.Model.HrRating;
import Digitact.Backend.Model.Image.AppImage;
import Digitact.Backend.Model.Industries;
import Digitact.Backend.Model.KeyCompetence;
import Digitact.Backend.Model.Positions;
import Digitact.Backend.Model.WorkExperience;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "users")
public class Applicant extends User {
    private static final long serialVersionUID = -2343243243242432341L;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "linkedIn")
    private String linkedIn;

    @Column(name = "xing")
    private String xing;

    @Column(name = "title")
    private Title title;

    @Column(name = "additionalInfo")
    private String additionalInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<Education> educations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<WorkExperience> workExperiences;

    @ElementCollection(targetClass = Industries.class)
    @Column(name = "Industries")
    private Set<Industries> industries;

    @ElementCollection(targetClass = Positions.class)
    @Column(name = "Positions")
    private Set<Positions> positions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<KeyCompetence> keyCompetencies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<AppImage> images;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private HrRating hrRating;

    protected Applicant() {
        super();
    }

    /**
     * @param firstName
     * @param lastName
     */
    public Applicant(String firstName, String lastName) {
        super(firstName, lastName, UserRight.Applicant);
        educations = new HashSet<Education>();
        keyCompetencies = new HashSet<KeyCompetence>();
        images = new LinkedHashSet<AppImage>();
        industries = new HashSet<Industries>();
        positions = new HashSet<Positions>();
        workExperiences = new HashSet<WorkExperience>();
        hrRating = new HrRating();
    }

    public UserRight getUserRight() {
        return UserRight.Applicant;
    }

    public void setEducation(Education education) {
        educations.add(education);
    }

    public List<Education> getEducations() {
        return new ArrayList<Education>(educations);
    }

    public void setEducations(List<Education> education) {
        education.forEach(edd -> educations.add(edd));
    }

    public void setWorkExperience(WorkExperience workExperience) {
        workExperiences.add(workExperience);
    }

    public List<WorkExperience> getWorkExperiences() {
        return new ArrayList<WorkExperience>(workExperiences);
    }

    public void setWorkExperiences(List<WorkExperience> workExperience) {
        workExperience.forEach(wex -> workExperiences.add(wex));
    }

    public List<Positions> getPositions() {
        return new ArrayList<Positions>(positions);
    }

    public void setPositions(List<Positions> positions) {
        positions.forEach(x -> this.positions.add(x));
    }

    public void addPosition(Positions position) {
        this.positions.add(position);
    }

    public void addKeyCompetence(KeyCompetence keyCompetence) {
        keyCompetencies.add(keyCompetence);
    }

    public List<KeyCompetence> getKeyCompetencies() {
        return new ArrayList<KeyCompetence>(keyCompetencies);
    }

    public void setKeyCompetencies(List<KeyCompetence> keyCompetencies) {
        keyCompetencies.forEach(comp -> this.keyCompetencies.add(comp));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<AppImage> getImages() {
        return images;
    }

    public void setImages(Set<AppImage> images) {
        this.images = images;
    }

    public void addImage(AppImage image) {
        this.images.add(image);
    }

    public List<Industries> getIndustries() {
        return new ArrayList<Industries>(industries);
    }

    public void setIndustries(List<Industries> selectedIndustries) {
        selectedIndustries.forEach(x -> this.industries.add(x));
    }

    public void addIndustries(Industries industriesType) {
        this.industries.add(industriesType);
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setHrRating(HrRating hrRating) {
        this.hrRating = hrRating;
    }

    public HrRating getHrRating() {
        return hrRating;
    }
}
