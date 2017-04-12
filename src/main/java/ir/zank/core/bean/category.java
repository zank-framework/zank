/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.zank.core.bean;

/**
 *
 * @author mghasemy
 */
public class category {
    String name;
    String idcategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(String idcategory) {
        this.idcategory = idcategory;
    }

    public String getCategory_idcategory() {
        return category_idcategory;
    }

    public void setCategory_idcategory(String category_idcategory) {
        this.category_idcategory = category_idcategory;
    }
    String category_idcategory;
}
