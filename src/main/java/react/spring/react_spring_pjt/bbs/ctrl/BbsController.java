package react.spring.react_spring_pjt.bbs.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;
import react.spring.react_spring_pjt.bbs.service.BbsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/bbs") //엔드포인트 지정 
public class BbsController {
    @Autowired
    private BbsService bbsService;

    //ResponseEntity : 비동기 통신을 위한 
    @GetMapping("/index") //user endpoint : http:// ip : port /bbs/index
    public ResponseEntity<Object> landing() {
        System.out.println("client endpoint : /bbs/index" + bbsService);
        List<BbsResponseDTO> list = bbsService.findAll();
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
        bbsService.create(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<BbsResponseDTO> view(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path /select");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id",id);
        BbsResponseDTO result = bbsService.find(map);


        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /*step 02
     * 1. 넘어온 데이터를 서비스( createComment() )로 전달하고 
     * 2. 서비스에서 매퍼의 도움으로 DB - Table 입력 
     * 3. ResponseEntity<Void> 타입으로 status NO_COntent 반환
     */

    @PostMapping("/comment/save")
    public ResponseEntity<Void> commentSave(@RequestBody CommentRequestDTO params) {
        System.out.println("debug >>> bbs controller client path / comment/post");
        System.out.println(" >>> request dto, " + params);
        bbsService.createComment(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/comment/getComment/{id}")
    public ResponseEntity<List<CommentResponseDTO>> Commentview(@PathVariable(name="id") Integer bbsid) {
        System.out.println("debug >>> bbs controller client path : /bbs/comment/getComment ");
        System.out.println("debug >>> bbsid param value " + bbsid);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", bbsid);
        List<CommentResponseDTO> list = bbsService.findComment(map);
        System.out.println("result size = " + list.size());

        return new ResponseEntity<List<CommentResponseDTO>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bbsid}")
    public ResponseEntity<Void> delete(@PathVariable(name="bbsid") Integer id) {
        System.out.println("debug >>> bbs controller client path : /bbs/delete ");
        System.out.println("debug >>> bbsid param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        bbsService.delete(map);
      
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody BbsRequestDTO params) {
        System.out.println("debug >>> bbs controller client path : /bbs/update ");
        System.out.println("debug >>> bbsid param value " + params);
        bbsService.update(params);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   

    
    

    
    

    
}
