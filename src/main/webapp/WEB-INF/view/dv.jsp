<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2018/5/11
  Time: 上午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/global.jsp" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="dv">
    <meta name="author" content="TQR">

    <title>出库单</title>

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
                <h1 class="page-header">出库单</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="/dv/add"><i class="fa fa-plus fa-3x"></i></a>
                        <span class="text-center text-info">${msg}</span>
                    </div>

                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>库存编号</th>
                                <th>数量</th>
                                <th>单位</th>
                                <th>状态</th>
                                <th>备注</th>
                                <th>创建时间</th>
                                <th>审核人</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="one" items="${dv}" varStatus="status">
                                <tr class="odd gradeX">
                                    <td>${status.index+1}</td>
                                    <td>${one.getInventory_id()}</td>
                                    <td>${one.getAmount()}</td>
                                    <td>${one.getUnit().getName()}</td>
                                    <c:choose>
                                        <c:when test="${one.getStatus()==1}">
                                            <td>未审核</td>
                                        </c:when>
                                        <c:when test="${one.getStatus()==2}">
                                            <td>已审核</td>
                                        </c:when>
                                    </c:choose>
                                    <td>${one.getRemark()}</td>
                                    <td>${one.getCreated()}</td>
                                    <c:choose>
                                        <c:when test="${user.getId()==one.getCreater().getId()}">
                                            <c:if test="${one.getStatus()==1}">
                                                <td></td>
                                                <td><a href="/dv/change/${one.getId()}">更新</a></td>
                                                <td><a href="/dv/delete/${one.getId()}">删除</a></td>
                                            </c:if>
                                            <c:if test="${one.getStatus()==2}">
                                                <td>${one.getVerifier().getUserName()}</td>
                                                <td colspan="2"><a href="/stock/">查看</a> </td>
                                            </c:if>
                                        </c:when>
                                        <c:when test="${user.getId()!=one.getCreater().getId()}">
                                            <c:if test="${one.getStatus()==1}">
                                                <td></td>
                                                <td><a href="/dv/verify/${one.getId()}">审核</a></td>
                                                <td><a href="/dv/delete/${one.getId()}">删除</a></td>
                                            </c:if>
                                            <c:if test="${one.getStatus()==2}">
                                                <c:if test="${user.getId()==one.getVerifier().getId()}">
                                                    <td>-YOU-</td>
                                                    <td colspan="2"><a href="/dv/verifydeny/${one.getId()}">取消审核</a></td>
                                                </c:if>
                                                <c:if test="${user.getId()!=one.getVerifier().getId()}">
                                                    <td>${one.getVerifier().getUserName()}</td>
                                                    <td colspan="2"><a href="/stock/">查看</a></td>
                                                </c:if>
                                            </c:if>
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
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</div>
</body>
</html>
