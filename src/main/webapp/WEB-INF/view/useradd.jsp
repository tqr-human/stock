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
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户新增</title>

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
                <h1 class="page-header">用户新增</h1>
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
                        <form method="post" id="updateform" action="/user/save" class="form-horizontal">
                            <div class="form-group">
                            <%--<P style="position: relative;">--%>
                                <%--<span class="p_logo"></span>--%>
                                <label class="col-lg-3 control-label">Username</label>
                                <div class="col-lg-5">
                                <input class="form-control" id="userName" type="text" name="userName" placeholder="请输入用户名"/>
                                </div>
                            <%--</P>--%>
                            </div>
                            <div class="form-group">
                            <%--<P style="position: relative;">--%>
                                <%--<span class="p_logo"></span>--%>
                                <label class="col-lg-3 control-label">Password</label>
                                <div class="col-lg-5">
                                <input class="form-control" id="password" type="password" name="password" placeholder="请输入密码"/>
                                </div>
                            <%--</P>--%>
                            </div>
                            <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
                                <P style="margin: 0px 35px 20px 45px;">
                                    <span class="info">${msg}</span>
                                    <span style="float: right;">
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" href="javascript:;" onclick="submitForm()">新增用户</a>
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
    <script type="text/javascript">
        $(document).ready(function() {
            $('#updateform').bootstrapValidator({
                message:'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields:{
                    userName:{
                        message: 'The username is not valid',
                        validators:{
                            notEmpty:{
                                message:'用户名不能为空'
                            },
                            stringLength:{
                                min:6,
                                max:18,
                                message:'用户名长度必须在6-18之间'
                            },
                            regexp:{
                                regexp:/^[a-zA-Z0-9_\.]+$/,
                                message:'用户名只能包含大小写字母、数字和下划线'
                            }
                        }
                    },
                    password:{
                        validators:{
                            notEmpty:{
                                message:'密码不能为空'
                            }
                        }
                    }
                }
            });
        });
    </script>

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

