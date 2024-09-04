package react.spring.react_spring_pjt.openapi.ctrl;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import react.spring.react_spring_pjt.openapi.service.ForecastService;

@RestController
@RequestMapping("/api")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Value("${openApi.callBackUrl}")
    private String callBackUrl;

    @Value("${openApi.dataType}")
    private String dataType;

    @GetMapping("/forecast")
    public String callForecastApi(
                @RequestParam(value = "base_time") String baseTime,
                @RequestParam(value = "base_date") String baseDate,
                @RequestParam(value = "beach_num") String beachNum) {
        

        System.out.println("client end point : /api/forecast");
        System.out.println("servicekey = " + serviceKey);
        System.out.println("callBackUrl = " + callBackUrl);
        System.out.println("dataType = " + dataType);
        System.out.println("params = " + baseTime + "\t" + baseDate + "\t" + beachNum);

        // step 01) 스프링에서 제공되는 콜백URL에게 요청 파라미터를 보내는 것
        // step 02) 
        String requestURL = callBackUrl + 
                            "?serviceKey=" + serviceKey + 
                            "&dataType=" + dataType +
                            "&base_date=" + baseDate +
                            "&base_time=" + baseTime +
                            "&beach_num=" + beachNum ;

        System.out.println("url check = " + requestURL);

        HttpURLConnection http = null ;
        InputStream stream = null ;
        String result = null ;

        try {
            URL url = new URL(requestURL);
            http = (HttpURLConnection)url.openConnection();
            System.out.println("http connection = " + http);
            int code = http.getResponseCode();
            System.out.println("http response code = " + code);
            if (code == 200){
                stream = http.getInputStream();
                result = readString(stream);
                System.out.println("result = " + result);

                forecastService.parsingJson(result);
            } else {
                
            }
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {

        }

        return null;
    }


    public String readString(InputStream stream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
        String input = null ;
        StringBuilder result = new StringBuilder();
        while((input = br.readLine()) != null) {
            result.append(input + "\n\r");
        }
        br.close();
        return result.toString();
    }
}
