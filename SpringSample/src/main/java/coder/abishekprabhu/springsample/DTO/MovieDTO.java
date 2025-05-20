package coder.abishekprabhu.springsample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String title;
    private String director;
    private int year;
    private String genre;

}
