/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.zank.core.start;

import ir.zank.core.bean.category;
import ir.zank.core.bean.city;
import ir.zank.core.db.dbreader;
import ir.zank.core.html.htmlwriter;
import ir.zank.core.html.template;
import ir.zank.core.html.template2;
import ir.zank.core.html.template3;
import ir.zank.core.html.template4;
import ir.zank.core.util.io;

/**
 *
 * @author mghasemy
 */
public class main {
    public String start(){
        dbreader dbr=new dbreader();
        htmlwriter hw=new htmlwriter();
        template t=new template();
        String finalstr="";
        for(category c:dbr.allcateg("0"))
        {
            String cat1=hw.write(t.temp, new String[]{"idcategory","name"}
                    , new String[]{c.getIdcategory(),c.getName()});
            String cat2="";
            for(category c2:dbr.allcateg(c.getIdcategory())){
                cat2+=hw.write(t.temp2, new String[]{"idcategory","name","mainid","mainname"},
                        new String[]{c2.getIdcategory(),c2.getName(),c.getIdcategory(),c.getName()});
            }
            String cat3=t.temp_sec2;
            finalstr+=(cat1+cat2+cat3);
        }
        io i=new io();
        i.savetocsv(finalstr, "/home/mghasemy/finalsrc.txt");
        return finalstr;
                    
    }
    public String start_sidebar(){
        dbreader dbr=new dbreader();
        htmlwriter hw=new htmlwriter();
        template2 t=new template2();
        String finalstr="";
        for(category c:dbr.allcateg("0"))
        {
            String cat1=hw.write(t.temp1, new String[]{"idcategory","name"}
                    , new String[]{c.getIdcategory(),c.getName()});
            String cat2="";
            for(category c2:dbr.allcateg(c.getIdcategory())){
                cat2+=hw.write(t.temp2, new String[]{"idcategory","name","mainid","mainname"},
                        new String[]{c2.getIdcategory(),c2.getName(),c.getIdcategory(),c.getName()});
            }
            String cat3=t.temp2_sec2;
            finalstr+=(cat1+cat2+cat3);
        }
        io i=new io();
        i.savetocsv(finalstr, "/home/mghasemy/finalsrc2.txt");
        return finalstr;
                    
    }
    public String start_city(){
        dbreader dbr=new dbreader();
        htmlwriter hw=new htmlwriter();
        template3 t=new template3();
        String finalstr="";
        for(city c:dbr.allcity())
        {
            finalstr+=hw.write(t.temp1, new String[]{"id","name"}
                    , new String[]{c.getId(),c.getName()});
        }
        io i=new io();
        i.savetocsv(finalstr, "/home/mghasemy/finalsrc3.txt");
        return finalstr;
                    
    }
    public String start_header_mini(){
        dbreader dbr=new dbreader();
        htmlwriter hw=new htmlwriter();
        template4 t=new template4();
        String finalstr="";
        for(category c:dbr.allcateg("0"))
        {
            finalstr+=hw.write(t.temp, new String[]{"idcategory","name"}
                    , new String[]{c.getIdcategory(),c.getName()});
        }
        io i=new io();
        i.savetocsv(finalstr, "/home/mghasemy/finalsrc4.txt");
        return finalstr;
                    
    }
    public static void main(String a[]){
        System.out.println("Starting.....\n\n\n");
        main m=new main();
//        m.start();
//        m.start_sidebar();
        m.start_header_mini();
        System.exit(0);
//        System.out.println(m.start());
    }
}
