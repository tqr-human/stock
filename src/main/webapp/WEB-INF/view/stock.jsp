<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2018/5/14
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/global.jsp" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="stock">
    <meta name="author" content="TQR">
    <title>库存总览</title>
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
                <h1 class="page-header">库存总览</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="/stock/"><i class="fa fa-refresh fa-3x"></i></a>
                        <span class="text-center text-info">${msg}</span>
                    </div>

                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>物料名</th>
                                <th>库存数</th>
                                <th>最大库存数</th>
                                <th>单位</th>
                                <%--<th colspan="2">操作</th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="one" items="${stock}" varStatus="status">
                                <tr class="odd gradeX">
                                    <c:if test="${one.getInventory()!=0}">
                                        <td>${status.index+1}</td>
                                        <td>${one.getGoods().getName()}</td>
                                        <td>${one.getInventory()}</td>
                                        <td>${one.getMax_inventory()}</td>
                                        <td>${one.getUnit().getName()}</td>
                                        <%--<td><a href="/stock/update/${one.getId()}">更新</a></td>--%>
                                        <%--<td><a href="/stock/delete/${one.getId()}">删除</a></td>--%>
                                    </c:if>
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
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</div>
</body>
</html>
