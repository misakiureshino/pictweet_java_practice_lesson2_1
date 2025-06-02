package in.tech_camp.pictweet.form;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;

import in.tech_camp.pictweet.validation.ValidationPriority1;
import in.tech_camp.pictweet.validation.ValidationPriority2;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserForm {

  @NotBlank(message = "First name can't be blank", groups=ValidationPriority1.class)
  @Length(max=6, message="FirstName is too long (maximum is 6 characters)", groups=ValidationPriority2.class)
  private String firstName;

  @NotBlank(message = "Last name can't be blank")
  @Length(max = 6, message="lastname is too long (maximum is 6 characters", groups=ValidationPriority2.class)
  private String lastName;

  @NotBlank(message = "Email can't be blank")
  @Email(message = "Email should be valid")
  private String email;

  @NotBlank(message="Password can't be blank")
  @Length(min = 6, max = 128, message = "Password should be between 6 and 128 characters")
  private String password;

  private String passwordConfirmation;

  public void validatePasswordConfirmation(BindingResult result) {
      if (!password.equals(passwordConfirmation)) {
          result.rejectValue("passwordConfirmation", null, "Password confirmation doesn't match Password");
      }
  }
}
