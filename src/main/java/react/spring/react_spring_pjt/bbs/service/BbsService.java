package react.spring.react_spring_pjt.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.spring.react_spring_pjt.bbs.dao.BbsMapper;
import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

import java.util.List;

import java.util.Map;

@Service
public class BbsService {
    @Autowired
    private BbsMapper bbsMapper; //의존관계 주입
    public List<BbsResponseDTO> findAll() {
        System.out.println("debug >>> service findAll" + bbsMapper);
        return bbsMapper.findAllRow();
    }

    public void create(BbsRequestDTO params) {
        System.out.println("debug >>> service create " + bbsMapper);
        bbsMapper.insertRow(params);
    }

    public BbsResponseDTO find(Map<String, Integer> map) {
        System.out.println("debug >>> service find " + bbsMapper);
        BbsResponseDTO result = bbsMapper.findRow(map);
        List<CommentResponseDTO> list = bbsMapper.findByIdComment(map);
        result.setComments(list);
        return result;
    }

    public void createComment(CommentRequestDTO params) {
        System.out.println("debug >>> comment service create " + bbsMapper);
        bbsMapper.insertCommentRow(params);
    }
    


}
