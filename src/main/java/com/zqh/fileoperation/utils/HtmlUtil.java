package com.zqh.fileoperation.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author zhangqh
 * @date 2021/9/7 0007 10:40
 */
public class HtmlUtil {

    public String getHtml(String url){
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet(url);
        String html = null;
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                html = EntityUtils.toString(httpEntity, "utf-8");
                //System.out.println(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return html;
    }

    //解析页面元素  参考
    public String parse(String html) {
        Document doc = Jsoup.parse(html);
        //System.out.println(doc);

        Element e1 =  doc.select("div.dzksfd1_lz").get(1);
        Elements e11 = e1.select("div.dzksfd1_lz2");
        System.out.println(e11.html());
        //mj
        Elements e2 = doc.select("div.dzksfd1_m2");
        Elements e21 = e2.select("div.dzksfd1_lz2");
        System.out.println(e21.html());
        //
        Element select = doc.select("div.zjmjdivmrm a").get(0);
        System.out.println(select.html());
        //MphSystemId
        Elements e3 = doc.select("span.div2");
        System.out.println(doc.select("span[id=duty_div2]").text());
        //doc.select("span[id=duty_div2]").text();
        //System.out.println("==========================");
        return null;
    }

}
