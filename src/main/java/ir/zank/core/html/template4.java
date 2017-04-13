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
public class template4 {
    public String temp="<li class=\"active open hover\">" +
"<a href=\"${pageContext.request.contextPath}/cms/category.jsp?ccn=${name}&cci=${idcategory}\">" +
"<i class=\"menu-icon fa fa-caret-left\"></i>" +
"${name}" +
"</a>" +
"</li>"
            ;
    
}
