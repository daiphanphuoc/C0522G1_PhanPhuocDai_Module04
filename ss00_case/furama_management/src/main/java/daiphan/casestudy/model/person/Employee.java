package daiphan.casestudy.model.person;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "degree_id" , referencedColumnName = "id")
    private EducationDegree degree;

    @ManyToOne
    @JoinColumn(name = "position_id" , referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id" , referencedColumnName = "id")
    private Division division;
    private double salary;
    private String userName;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getInfo() {
        Date date = getBirthday();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString  = df.format(date);
        return String.format("%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s", getName(), getIdCitizen(),dateString,
                isSex(), getPhone(), getEmail(), getAddress(), id, degree.getName(),
                position.getName(),division.getName(), salary, userName);
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex,
                    String phone, String email, String address, int iDEmployee,
                    EducationDegree degree, Position position, Division division,
                    double salary, String userName) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.id = iDEmployee;
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.salary = salary;
        this.userName = userName;
    }

    public Employee(String name, String iDCitizen, Date birthday, boolean sex, String phone, String email, String address, EducationDegree degree, Position position, Division division, double salary, String userName) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.division = division;
        this.salary = salary;
        this.userName = userName;
    }

    public EducationDegree getDegree() {
        return degree;
    }

    public void setDegree(EducationDegree degree) {
        this.degree = degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getIDEmployee() {
        return id;
    }

    public void setIDEmployee(int iDEmployee) {
        this.id = iDEmployee;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
