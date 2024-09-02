package react.spring.react_spring_pjt.bbs.dao;

import org.apache.ibatis.annotations.Mapper;


import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;

import java.util.List;

@Mapper
public interface BbsMapper {
    public List<BbsResponseDTO> findAllRow();

    public void insertRow(BbsRequestDTO params);
}
