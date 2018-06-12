<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>入库单新增</title>

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
                <h1 class="page-header">入库单新增</h1>
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


                        <form method="post" id="updateform" class="form-horizontal" name="theForm">
                            <div class="form-group">
                                <div class="col-lg-5">
                                    <select class="form-control" name="unitId" id="unitSelector" onclick="process('inner')">
                                        <option value="1">-- Select a unit --</option>
                                        <c:forEach var="one" items="${unit}" varStatus="status">
                                            <option value="${one.getId()}">${one.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-5">
                                    <select class="form-control" name="goodsId" id="pNameSelector" >
                                        <option value="">-- Select a Product_Name --</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-5">
                                    <input class="form-control" id="amount" type="text" name="amount" placeholder="请输入库存数量" readonly="true"/>
                                </div>
                            </div>

                            <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
                                <P style="margin: 0px 35px 20px 45px;">
                                    <span class="info">${msg}</span>
                                    <span style="float: right;">
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" href="javascript:;" onclick="process('outter')">增加入库单</a>
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
    function process(v) {
        document.theForm.action="/wv/select";
        document.theForm.submit();
    }
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
    function change() {
        $('#unitSelector').change(function () {
            var unit = document.getElementById("unitSelector");
            var unitName = unit.options[unit.selectedIndex].value;
            var val =  $('#unitSelector option:selected').val();
            if (val==1){
                $('#pNameSelector').empty();
                $("#pNameSelector").append(
                    "<option value='#'>-- Select a Product_name --</option>");
            }else {
                $.ajax({
                    url:'selector',
                    type:'post',
                    data:{
                        unit:unitName
                    },
                    dataType:"json",
                    success:function (data) {
                        if (data.length!=0) {
                            for (var i = 0;i<data.length;i++) {
                                $("#pNameSelector").append("<option value="+data[i].id+">"+data[i].name+"</option>");
                            }
                        }else{
                            document.getElementById("pNameSelector").innerHTML
                                = "<option value='#'>-- Select a Product_name --</option>" ;
                            $.messager.alert('入库单增加', '该单位没有绑定的物料','info');
                            return;
                        }
                    }
                });
            }
        });
        // var unit = document.getElementById("unitSelector");
        // var unitName = unit.options[unit.selectedIndex].value;
        // var product_name = document.getElementById("pNameSelector");
        // var oOp = product_name.children; //获取select列表的所有子元素。
        // var val =  $('#unitSelector option:selected').val();
        // if (val==1){
        //     $('#pNameSelector').empty();
        //     document.getElementById("pNameSelector").innerHTML
        //         = "<option value='#'>-- Select a Product_name --</option>" ;
        // }else {
        //     $.ajax({
        //         url:"select?method=getUnit",
        //         type:"post",
        //         // data:"&unit="+unitName,
        //         data:{
        //             unit:unitName
        //         },
        //         dataType:"json",
        //         success:function (data) {
        //             if (data.length!=0) {
        //                 for (var i = 0;i<data.length;i++) {
        //                     $("#pNameSelector").append("<option value="+data[i].id+">"+data[i].name+"</option>");
        //                 }
        //             }else{
        //                 document.getElementById("pNameSelector").innerHTML
        //                     = "<option value='#'>-- Select a Product_name --</option>" ;
        //                 $.messager.alert('入库单增加', '该单位没有绑定的物料','info');
        //                 return;
        //             }
        //         }
        //     });
        // }
        // $('#unitSelector').change(function () {
        //
        // });
    }



</script>
</body>

</html>

