package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private Long id;
    private String name;
    private Integer gender;
    private String address;
    private String school;
    private String contact;
}
