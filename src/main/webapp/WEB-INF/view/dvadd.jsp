<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2018/5/11
  Time: 上午9:11
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
    <meta name="description" content="">
    <meta name="author" content="">

    <title>出库单新增</title>

    <!-- Bootstrap Core CSS -->
    <%@ include file="commons/admincss.jsp" %>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <link href="${staticPath }/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${staticPath }/static/vendor/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script src="${staticPath }/static/vendor/jquery/jquery.min.js"/>
    <script src="${staticPath }/static/vendor/bootstrap/js/bootstrap.min.js"/>
    <script src="${staticPath }/static/vendor/bootstrap/js/bootstrapValidator.min.js"/>
    <![endif]-->


</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <%@ include file="commons/adminmenu.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">出库单新增</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="info">${msg}</span>
                    </div>

                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form method="post" id="updateform" action="/dv/save" class="form-horizontal">
                            <div class="form-group">
                                <div class="col-lg-5">
                                    <select class="form-control" name="inventory_id">
                                        <option value="">-- Select an Inventory --</option>
                                        <c:forEach var="one" items="${stock}" varStatus="status">
                                            <c:if test="${one.getInventory()!=0}">
                                                <option value="${one.getId()}">${one.getGoods().getName()}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-5">
                                    <input class="form-control" id="amount" type="text" name="amount" placeholder="请输入库存数量" onkeyup="this.value=this.value.replace(/[^\d]/g,'')"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-5">
                                    <input class="form-control" id="remark" type="text" name="remark" placeholder="请输入备注"/>
                                </div>
                            </div>

                            <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
                                <P style="margin: 0px 35px 20px 45px;">
                                    <span class="info">${msg}</span>
                                    <span style="float: right;">
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" href="javascript:;" onclick="submitForm()">增加出库单</a>
                </span>
                            </div>
                        </form>
                        <!-- /.table-responsive -->

                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@ include file="commons/adminjs.jsp" %>

<script>
    function submitForm(){
        $('#updateform').submit();
    }
    function clearForm(){
        $('#updateform').form('clear');
    }
    //回车登录
    function commit(){
        if (event.keyCode == 13){
            event.returnValue=false;
            event.cancel = true;
            $('#updateform').submit();
        }
    }


</script>
</body>

</html>

