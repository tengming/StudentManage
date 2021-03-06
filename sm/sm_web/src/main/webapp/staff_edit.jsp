<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>添加成员</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/thems.css"/>
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //自适应屏幕宽度
            window.onresize = function () {
                location = location
            };

            var main_h = $(window).height();
            $('.hy_list').css('height', main_h - 45 + 'px');

            var main_w = $(window).width();
            $('.xjhy').css('width', main_w - 40 + 'px');

        });
    </script>
</head>

<body onLoad="Resize();">
<div id="right_ctn">
    <div class="right_m">
        <div class="hy_list">
            <div class="box_t">
                <span class="name">添加成员</span>
            </div>
            <div class="space_hx">&nbsp;</div>
            <form action="edit.do" method="post" name="addForm">
                <input type="hidden" name="id" value="${SOBJ.id}">
                <div class="xjhy">
                    <!--高级配置-->
                    <ul class="hypz gjpz clearfix">


                        <%--<th scope="col">姓名</th>--%>
                        <%--<th scope="col">性别</th>--%>
                        <%--<th scope="col">出生日期</th>--%>
                        <%--<th scope="col">入职时间</th>--%>
                        <%--<th scope="col">所属部门</th>--%>
                        <%--<th scope="col">状态</th>--%>
                        <%--<th scope="col">操作</th>--%>

                        <li class="clearfix">
                            <span class="title">姓名：</span>
                            <div class="li_r">
                                <input class="chang" name="name" type="text" value="${SOBJ.name}">
                                <i>*</i>
                            </div>
                        </li>
                        <li class="clearfix">
                            <span class="title">性别：</span>
                            <div class="li_r">
                                <span class="radio">
                                <input class="chang" name="sex" type="radio" value="男" checked="checked">
                                    <em>男</em>
                                  </span>
                                <span class="radio">
                                <c:if test="${SOBJ.sex=='女'}">
                                    <input class="chang" name="sex" type="radio" value="女" checked="checked">
                                    <em>女</em>
                                </c:if>
                                </span>
                                <span class="radio">
                                <c:if test="${SOBJ.sex!='女'}">
                                    <input class="chang" name="sex" type="radio" value="女">
                                    <em>女</em>
                                </c:if>
                                </span>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">部门：</span>
                            <div class="li_r">
                                <select name="did">

                                    <c:forEach items="${DEDIT}" var="dep">
                                        <c:if test="${SOBJ.did==dep.id}">
                                            <option value="${dep.id}" selected="selected">${dep.name}</option>
                                        </c:if>
                                        <c:if test="${SOBJ.did!=dep.id}">
                                            <option value="${dep.id}">${dep.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>

                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">个人编码：</span>
                            <div class="li_r">
                                <input class="chang" name="idNumber" type="text" value="${SOBJ.idNumber}">
                                <i>*</i>
                            </div>
                        </li>

                        <li class="clearfix">
                            <span class="title">出生日期：</span>
                            <div class="li_r">
                                <input class="chang" name="bornData" type="text" value="<fmt:formatDate
                                                        value="${SOBJ.bornData}" pattern="yyyy-MM-dd"/>">
                                <i>*</i>
                            </div>
                        </li>


                        <li class="tj_btn">
                            <a href="javascript:history.go(-1);" class="back">返回</a>
                            <a href="javascript:addForm.submit();">保存</a>
                        </li>
                    </ul>
                    <!--高级配置-->
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>