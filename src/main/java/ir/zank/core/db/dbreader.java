/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.zank.core.db;

import ir.zank.core.bean.category;
import ir.zank.core.bean.city;
import ir.zank.core.util.C3P0Util;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


/**
 *
 * @author mghasemy
 */
public class dbreader {
    	private QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());

    public List<category> allcateg(String id) {
	
		try {
			List<category>  categs=qr.query("select * from category where category_idcategory=?",new BeanListHandler<category>(category.class),id);
			System.out.println(categs.size());
			return categs;
		} catch (Exception e) {
                    e.printStackTrace();
			throw new RuntimeException(e);
                        
		}
	}
    public List<city> allcity() {
	
		try {
			List<city>  citys=qr.query("select * from city ",new BeanListHandler<city>(city.class));
			System.out.println(citys.size());
			return citys;
		} catch (Exception e) {
                    e.printStackTrace();
			throw new RuntimeException(e);
                        
		}
	}
}
