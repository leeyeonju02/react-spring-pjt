package react.spring.react_spring_pjt.bbs.domain;

import java.util.List;
import lombok.Data;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;



@Data //Data 어노테이션은 세터, 게터, 투스트링 등을 다 포함하고 있는 어노테이션이다. 
public class BbsResponseDTO {
    private Integer id;
    private String title;
    private String content;

    private List<CommentResponseDTO> comments; 
}
