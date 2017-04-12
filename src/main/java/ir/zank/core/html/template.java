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
public class template {
    public String temp="<li class=\"active open hover\">" +
"                                <a href=\"${pageContext.request.contextPath}/cms/category.jsp?ccn=${name}&cci=${idcategory}\">" +
"                                    <i class=\"menu-icon fa fa-caret-left\"></i>" +
"                                   ${name}" +
"                                    <b class=\"arrow fa fa-angle-down\"></b>" +
"                                </a>" +
"                                <b class=\"arrow\"></b>"
            + "<ul class=\"submenu\">";
    public String temp_sec2="</ul> " +
"                                        </li>";
    public String temp2="<li class=\"active hover\">" +
"                                        <a href=\"${pageContext.request.contextPath}/cms/subcategory.jsp?cn=${name}&ci=${idcategory}&cci=${mainid}&ccn=${mainname}\">" +
"                                            <i class=\"menu-icon fa fa-caret-left\"></i>" +
"                                            ${name}" +
"                                        </a>" +
"" +
"                                        <b class=\"arrow\"></b>" +
"                                    </li>"  ;
}
