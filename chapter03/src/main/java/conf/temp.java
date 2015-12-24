package conf;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;

/**
 * Created by huaaijia on 2014/4/18.
 */
public class temp {

    public static void main (String[] args){
        String targetUrl = "http://api.v1.cn/v1Enhanced/interface";
        String result = "";
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(targetUrl);
        postMethod.setParameter("obj", "cms.getArticle");
        postMethod.setParameter("startTime", "2014-04-23 09:55:10");
        postMethod.setParameter("endTime", "2014-04-23 09:55:12");
        postMethod.setParameter("nums", "1");
        postMethod.setParameter("showType", "1000,1023");
        postMethod.setParameter("status","1,2");

        try{
            // 指定编码
            HttpClientParams params = client.getParams();
            params.setContentCharset("UTF-8");
            int statusCode = client.executeMethod(postMethod);

            if (statusCode == HttpStatus.SC_OK) {
                byte[] responseBody = postMethod.getResponseBody();
                result = new String(responseBody);
                System.out.println(result);
            }
        }catch(Exception e){

        }
    }
}
