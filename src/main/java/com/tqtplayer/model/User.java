package com.tqtplayer.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Full Name Khong Duoc De Trong")
    @Size(min = 2, max = 45)
    private String fullName;

    @Email(message = "Email invalid")
    private String email;

    private String password;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(columnDefinition = "varchar(10) default 'user'")
    private String role;

    public User(Long id, String fullName, String email, boolean deleted, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.deleted = deleted;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", deleted=" + deleted +
                ", role='" + role + '\'' +
                '}';
    }


//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//        String fullName = user.getFullName();
//        String password = user.getPassword();
//        String email = user.getEmail();
//
//        if ((fullName == null) || fullName.equals("")){
//            errors.rejectValue("fullName", "error.fullName.blank");
//        }
//        if (fullName.length() < 5 || fullName.length() > 45){
//            errors.rejectValue("fullName", "error.fullName.oversize");
//        }
//        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")){
//            errors.rejectValue("password", "error.password.nomatch");
//        }
//        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
//            errors.rejectValue("email", "error.email.nomathregex");
//        }
//    }
}
