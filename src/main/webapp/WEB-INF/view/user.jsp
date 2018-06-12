<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/4/23
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="commons/global.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="user">
    <meta name="author" content="TQR">

    <title>用户</title>

    <!-- Bootstrap Core CSS -->
    <%@ include file="commons/admincss.jsp" %>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <%@ include file="commons/adminmenu.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <c:choose>
                            <c:when test="${nowuser.getStatus()!=1}">
                                <a href="/user/"><i class="fa fa-refresh fa-3x"></i></a>
                            </c:when>
                            <c:when test="${nowuser.getStatus()==1}">
                                <a href="/user/add"><i class="fa fa-user-plus fa-3x"></i></a>
                            </c:when>
                        </c:choose>
                        <span class="text-center text-info">${msg}</span>
                    </div>

                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>用户名</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="one" items="${user}" varStatus="status">
                            <tr class="odd gradeX">
                                <c:choose>
                                    <c:when test="${nowuser.getStatus()!=1}">
                                        <c:if test="${one.getId()==nowuser.getId()}">
                                            <td>1</td>
                                            <td>${one.getUserName()}</td>
                                            <td><a href="/user/change/${one.getId()}">修改密码</a></td>
                                            <td><a href="/user/delete/${one.getId()}">删除</a></td>
                                        </c:if>
                                    </c:when>
                                    <c:when test="${nowuser.getStatus()==1}">
                                        <td>${status.index+1}</td>
                                        <td>${one.getUserName()}</td>
                                        <td><a href="/user/change/${one.getId()}">修改密码</a></td>
                                        <td><a href="/user/delete/${one.getId()}">删除</a></td>
                                    </c:when>
                                </c:choose>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!-- /.table-responsive -->

                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->

    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="commons/adminjs.jsp" %>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

</body>

</html>

