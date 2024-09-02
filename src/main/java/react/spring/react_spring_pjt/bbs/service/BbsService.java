package react.spring.react_spring_pjt.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.spring.react_spring_pjt.bbs.dao.BbsMapper;
import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;

import java.util.List;

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

    


}
