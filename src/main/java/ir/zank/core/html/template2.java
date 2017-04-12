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
public class template2 {
    public String temp1="<div class=\"panel panel-default\">" +
"                                        <div class=\"panel-heading\">" +
"                                            <h4 class=\"panel-title\">" +
"                                                <a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#id${idcategory}\">" +
"                                                    <span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>" +
"" +
"                                                </a>" +
"                                                <a href=\"${pageContext.request.contextPath}/cms/category.jsp?ccn=${name}&cci=${idcategory}\">${name}</a>" +
"                                            </h4>" +
"                                        </div>" +
"                                        <div id=\"id${idcategory}\" class=\"panel-collapse collapse\">" +
"                                            <div class=\"panel-body\"><ul>";
    public String temp2_sec2="</ul>" +
"                                            </div>" +
"                                        </div>" +
"                                    </div>";
    public String temp2=" <li><a href=\"${pageContext.request.contextPath}/cms/subcategory.jsp?cn=${name}&ci=${idcategory}&cci=${mainid}&ccn=${mainname}\">${name}</a></li>" +
"                                                       ";
}
