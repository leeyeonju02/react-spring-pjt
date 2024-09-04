package react.spring.react_spring_pjt.openapi.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import react.spring.react_spring_pjt.openapi.domain.ForecastItemDTO;
import react.spring.react_spring_pjt.openapi.domain.ForecastItems;
import java.util.List;

@Service
public class ForecastService {

    /*
     * ObjectMapper 객체를 이용해서 json 문자열을 java 객체로 변경( 역직렬화 json -> java)
     * 직렬화 (java -> json ) 
     */
    public void parsingJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ForecastItems items = mapper.readValue(str, ForecastItems.class);
            List<ForecastItemDTO> list = items.getItems();
            System.out.println("service prsing json size = "+ list.size());
            for (ForecastItemDTO item : list) {
                System.out.println(item);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
       
    }
}
