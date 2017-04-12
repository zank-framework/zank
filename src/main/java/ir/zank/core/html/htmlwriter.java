/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.zank.core.html;

/**
 *
 * @author mghasemy
 */
public class htmlwriter {
    public String write(String template,String input[],String output[]){
        int c=0;
        if(input.length!=output.length)return null;
        for(String i:input){
            try{
            template=template.replace("${"+i+"}", output[c]);
            }catch(Exception a){return null;}
            c++;
        }
        return template;
    }
}
