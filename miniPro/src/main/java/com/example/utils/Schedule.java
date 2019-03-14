package com.example.utils;

import com.example.domain.Person;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Decription TODO
 * @Author wxm
 * @Date 2019/3/6 16:07
 **/

@Component
public class Schedule {

    public static void main(String[] args) {



        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar aa = Calendar.getInstance();
        Calendar bb = Calendar.getInstance();
        Calendar cc = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(today.getTime()));

        Person a=new Person();
        a.setName("王晓梅");
        a.setRelative("自己");
        aa.set(2017,3,8);
        a.setBirth(aa);

        Person b=new Person();
        b.setName("都泓憬");
        b.setRelative("儿子");
        bb.set(2017,3,7);
        b.setBirth(bb);

        Person c=new Person();
        c.setName("都德");
        c.setRelative("老公");
        cc.set(2017,4,9);
        c.setBirth(cc);





        List<Person> list=new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        Date now=new Date();

    //    a.getBirth().set(Calendar.YEAR,today.get(Calendar.YEAR));
        System.out.println("c的生日"+c.getBirth().get(Calendar.DAY_OF_YEAR));
        System.out.println("a日期："+a.getBirth().get(Calendar.DAY_OF_YEAR));

        System.out.println("b的生日"+b.getBirth().get(Calendar.DAY_OF_YEAR));
        System.out.println("现在的日期："+today.get(Calendar.DAY_OF_YEAR));
        int days;
        if (a.getBirth().get(Calendar.DAY_OF_YEAR) < b.getBirth().get(Calendar.DAY_OF_YEAR)) {
            // 生日已经过了，要算明年的了
            days = today.getActualMaximum(Calendar.DAY_OF_YEAR) - b.getBirth().get(Calendar.DAY_OF_YEAR);
            days += a.getBirth().get(Calendar.DAY_OF_YEAR);
        } else {
            // 生日还没过
            days = a.getBirth().get(Calendar.DAY_OF_YEAR) - b.getBirth().get(Calendar.DAY_OF_YEAR);
        }
        if (days == 0) {
            System.out.println("今天生日");
        } else {
            System.out.println("距离生日还有：" + days + "天");
        }



      //  System.out.println((now.getTime()-c.getBirth().getTime())/(60*60*24));
    }


    //秒（0-59），分（0-59），时（0-23），日期天/日（1-31），月份）（1-12），星期（1-7,1表示星晴天，7表示星期六）
   @Scheduled(cron="0 0/2 * * * * ")//代表每二分钟执行一次
    public  void start() {


            /* Person a=new Person();
        a.setName("王晓梅");
        a.setRelative("自己");
        a.setBirth(new Date("2018-03-08"));

        Person b=new Person();
        b.setName("都泓憬");
        b.setRelative("儿子");
        b.setBirth(new Date("2018-03-09"));

        Person c=new Person();
        c.setName("都德");
        c.setRelative("老公");
        c.setBirth(new Date("2018-04-08"));*/

            List<Person> list = new ArrayList<>();
      /*  list.add(a);
        list.add(b);
        list.add(c);*/

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String aa = "2018-03-09";
            String bb = "2018-03-01";
            String today = "2018-03-07";


             System.out.println(aa);
        }

}
