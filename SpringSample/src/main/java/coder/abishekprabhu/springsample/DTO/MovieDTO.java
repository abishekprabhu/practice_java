package coder.abishekprabhu.springsample.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String director;
    private int year;
    private String genre;
}
