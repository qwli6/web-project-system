<%--
  Created by IntelliJ IDEA.
  User: liqiwen
  Date: 2017/12/4
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; UTF-8"
        pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<td colspan="6" align="center">
                        <span id="pageLink">
                            <div>
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">共</span>&nbsp;
                                [<span style="font-family: Georgia,serif; font-size: 16px;">${pageBean.totalCount}</span>]&nbsp;
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">条记录，</span>
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">共</span>
                                [<span style="font-family: Georgia,serif; font-size: 16px;">${pageBean.totalPage}</span>]
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">页， 每页显示</span>

                                <select name="pageSize">
                                    <option value="3" <c:if test="${pageBean.pageSize==3}">selected</c:if>>3</option>
                                    <option value="5" <c:if test="${pageBean.pageSize==5}">selected</c:if>>5</option>
                                </select>
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">条。</span>
                                &nbsp;&nbsp;
                                <!-- 当前页小于大于 1 才有上一页-->
                                <c:if test="${pageBean.pageCode > 1}">
                                    <span style="font-family: 'Songti TC',serif;font-size: 16px;">
                                        [<a href="javascript:to_page(${pageBean.pageCode} -1)">上一页</a>]
                                    </span>
                                </c:if>

                                &nbsp;&nbsp;
                                <strong><span style="font-family: 'Georgia',serif; font-size: 16px">${pageBean.pageCode}</span></strong>
                                &nbsp;&nbsp;
                                <c:if test="${pageBean.pageCode < pageBean.totalPage}">
                                    <span style="font-family: 'Songti TC',serif;font-size: 16px;">
                                        [<a href="javascript:to_page(${pageBean.pageCode}+1)">下一页</a>]
                                    </span>
                                </c:if>
                                &nbsp;&nbsp;
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">到</span>

                                     <input type="text" size="3" id="page" name="pageCode" />

                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">页</span>

                                <input type="button" value="Go" onclick="to_page()"/>
                            </div>
                        </span>
</td>