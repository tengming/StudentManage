<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>个人管理</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css">
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //自适应屏幕宽度
            window.onresize = function () {
                location = location
            };

            var main_h = $(window).height();
            $('.hy_list').css('height', main_h - 45 + 'px');

            var search_w = $(window).width() - 40;
            $('.search').css('width', search_w + 'px');
            //$('.list_hy').css('width',search_w+'px');
        });
    </script>
    <!--框架高度设置-->
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">个人管理</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">

                <tr>

                    <th scope="col">姓名</th>
                    <th scope="col">学号</th>
                    <th scope="col">性别</th>
                    <th scope="col">出生日期</th>
                    <th scope="col">注册时间</th>
                    <th scope="col">班级</th>
                    <th scope="col">状态</th>
                    <th scope="col">操作</th>
                </tr>


                    <tr>
                        <td>${LISTONE.name}</td>
                        <td>${LISTONE.idNumber}</td>
                        <td>${LISTONE.sex}</td>
                        <td><fmt:formatDate value="${LISTONE.bornData}" pattern="yyyy-MM-dd"/> </td>
                        <td><fmt:formatDate value="${LISTONE.workTime}" pattern="yyyy-MM-dd"/> </td>
                        <td>${LISTONE.department.name}</td>
                        <td>${LISTONE.status}</td>

                        <td>
                            <a href="toEditone.do?id=${LISTONE.id}" class="btn">编辑</a>

                        </td>
                    </tr>
            </table>
            <!--列表-->
            <!--右边底部-->

            <!--右边底部-->
        </div>
        <!--会议列表-->
    </div>
</div>
</body>
</html>

