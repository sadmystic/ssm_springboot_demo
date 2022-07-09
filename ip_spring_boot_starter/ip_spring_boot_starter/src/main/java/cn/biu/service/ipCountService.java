package cn.biu.service;

import cn.biu.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ipCountService {

    private Map<String,Integer> ipContMap=new HashMap<String, Integer>();

    @Autowired
    //当前request对象的注入工作由当前starter的工程提供
    private HttpServletRequest httpServletRequest;

    public void count(){
        //每次调用当前操作，就记录当前访问的IP，然后累加次数
        //1.获取当前操作ip地址
        String ip=httpServletRequest.getRemoteAddr();

        //2.根据ip地址从Map取值，并递增
        Integer count =ipContMap.get(ip);
        if(count == null) {
            ipContMap.put(ip,1);
        }
        else {
            ipContMap.put(ip, ipContMap.get(ip) + 1);
        }
    }

    @Autowired
    private IpProperties ipProperties;

    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){


        if (ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())){
            System.out.println("          IP访问监控");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipContMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |",key,value));
            }
            System.out.println("+--------------------+-------+");
        }else if (ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())){
            System.out.println("          IP访问监控");
            System.out.println("+-----ip-address-----+");
            for (String key : ipContMap.keySet()) {
                System.out.println(String.format("|%18s  |",key));
            }
            System.out.println("+--------------------+");
        }

        if(ipProperties.getCycleReset()){
            ipContMap.clear();
        }
    }

    public static void main(String[] args) {
        new ipCountService().print();
    }
}
