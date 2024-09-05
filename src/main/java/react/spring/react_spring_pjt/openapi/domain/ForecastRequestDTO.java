package react.spring.react_spring_pjt.openapi.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForecastRequestDTO {
    //Vaildation annotation(들어오는 데이터 형식을 규정) : Notnull , NotEmpty, NotBlanck, Past, PastOrPresent, Email, Regualr Expression etc....

    @NotBlank(message = "시간을 입력하세요") //null, blank 빈값 허용 안함 -> 유효성 체크해서 빈값일 경우 메세지 반환
    private String base_time; 
    @NotBlank(message = "날짜를 입력하세요")
    private String base_date;
    @NotBlank(message = "검색어를 입력하세요")
    private String beach_num;
}
