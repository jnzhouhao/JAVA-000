package com.candy.geek.week02;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zh0809
 * @date 2020/10/29 16:20
 **/
public class HttpClient {

    private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    public static void main(String[] args) {
        String result = httpGet("http://localhost:8801/");
        System.out.println(result);
    }

    public static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60 * 1000).setConnectTimeout(60 * 1000).build();

    public static String httpGet(String url) {
        // 发送get请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpClient = HttpClients.createDefault();
            httpResponse = httpClient.execute(httpGet);
            // 请求发送成功，并得到响应
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = httpResponse.getEntity();
                return EntityUtils.toString(entity, "utf-8");
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        } finally {
            try {
                httpResponse.close();
                httpClient.close();
                httpGet.releaseConnection();
                logger.info("请求流关闭完成");
            } catch (IOException e) {
                logger.info("请求流关闭出错");
                e.printStackTrace();
            }
        }
        return null;
    }

}
