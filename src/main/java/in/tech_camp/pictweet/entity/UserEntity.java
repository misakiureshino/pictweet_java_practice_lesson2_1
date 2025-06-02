package in.tech_camp.pictweet.entity;

import lombok.Data;

@Data
public class UserEntity {
  private Integer id;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
}
