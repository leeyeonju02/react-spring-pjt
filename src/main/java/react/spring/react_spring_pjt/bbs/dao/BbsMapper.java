package react.spring.react_spring_pjt.bbs.dao;

import org.apache.ibatis.annotations.Mapper;


import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

import java.util.List;
import java.util.Map;
@Mapper
public interface BbsMapper {
    public List<BbsResponseDTO> findAllRow();

    public void insertRow(BbsRequestDTO params);

    public BbsResponseDTO findRow(Map<String, Integer> id);

    public List<CommentResponseDTO> findByIdComment(Map<String, Integer> map);

    public void insertCommentRow(CommentRequestDTO params);
}
