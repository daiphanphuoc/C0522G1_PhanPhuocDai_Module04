package daiphan.exercise.dto;

import javax.validation.constraints.*;

public class UserDto {
    private int id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 45,min = 5)
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 45,min = 5)
    private String lastName;

    @NotBlank(message = "SĐT không được để trống.")
    @Pattern(regexp = "^0[0-9]{9}$", message = "SĐT phải có 10 số, và có định dạng 0xxxxxxxxx.")
    private String phoneNumber;

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$",
            message = "Email phải đúng định dạng.")
    private String email;

    @Min(18)
    @Max(80)
    private int age;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
