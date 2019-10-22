<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>成员列表</title>
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
                <span class="name">成员列表</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <!--列表-->
            <table cellpadding="0" cellspacing="0" class="list_hy">

                <tr>
                    <th class="xz" scope="col">选择</th>
                    <th scope="col">
                        <div>XX<a href="" class="up">&nbsp;</a><a href="" class="down">&nbsp;</a></div>
                    </th>
                    <th class="zt" scope="col">
                        <div>XX<a href="" class="up">&nbsp;</a><a href="" class="down">&nbsp;</a></div>
                    </th>
                    <th scope="col">账户</th>
                    <th scope="col">密码</th>
                    <th scope="col">姓名</th>
                    <th scope="col">性别</th>
                </tr>


                    <tr>
                        <td class="xz"><input name="" type="checkbox" value=""></td>
                        <td></td>
                        <td class="zt"></td>
                        <td>${Chakan.account}</td>
                        <td>${Chakan.password}</td>
                        <td>${Chakan.status}</td>
                        <td></td>
                    </tr>
            </table>

        </div>

    </div>
</div>
</body>
</html>

