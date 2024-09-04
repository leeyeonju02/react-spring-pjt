package react.spring.react_spring_pjt.openapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;


@Data
@AllArgsConstructor
public class ForecastItems {
    /* 객체가 컬렉션에 들어가게끔 하는 것 
    ForcastItems는 Dto를 List형식으로 가지고 있어야 한다. 
    최상위 객체에서 노드워킹으로 item을 찾아서 Array로 반환

    */
    @JsonProperty("item")
    private List<ForecastItemDTO> items;

    @JsonCreator
    public ForecastItems(@JsonProperty("response") JsonNode node) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode itemNode = node.findValue("item"); //response라는 것을 최상위노드로 매칭후 노드 워킬을 통해 findValue로 값을 찾는다
            this.items = Arrays.stream(mapper.treeToValue(itemNode, ForecastItemDTO[].class)).toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
