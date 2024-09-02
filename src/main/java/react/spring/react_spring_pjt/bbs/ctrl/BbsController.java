package react.spring.react_spring_pjt.bbs.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.service.BbsService;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/bbs") //엔드포인트 지정 
public class BbsController {
    @Autowired
    private BbsService BbsService;

    //ResponseEntity : 비동기 통신을 위한 
    @GetMapping("/index") //user endpoint : http:// ip : port /bbs/index
    public ResponseEntity<Object> landing() {
        System.out.println("client endpoint : /bbs/index" + BbsService);
        List<BbsResponseDTO> list = BbsService.findAll();
        System.out.println("result size = " + list.size());
        if( list.size() == 0) {
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장된 데이터가 존재하지 않습니다. ");
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }   
    
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody BbsRequestDTO params) {
        System.out.println("client endpoint : /bbs/save");
        System.out.println("params : " + params);
        BbsService.create(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/bbs-view/{id}")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    
}
