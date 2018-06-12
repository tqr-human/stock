<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2018/4/23
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css" href="${staticPath }/static/style/css/login.css?v=20180423" />
    <script src="${staticPath }/static/vendor/bootstrap/js/bootstrapValidator.min.js"/>
    <link href="${staticPath }/static/vendor/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet">
    <link href="${staticPath }/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        $(function () {
            $('#updateform').bootstrapValidator({
                message:'This value is not valid',
                feedbackIcon:{
                    valid:'glyphicon glyphicon-ok',
                    invalid:'glyphicon glyphicon-remove',
                    validating:'glyphicon glyphicon-refresh'
                },
                fields:{
                    userName:{
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
                                regexp:/^[a-zA-Z0-9_]+$/,
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
                    },
                    passwordConfirm:{
                        validators:{
                            notEmpty:{
                                message:'密码不能为空'
                            }
                        }
                    }
                }
            })
        });
    </script>
</head>
<body onkeydown="enterlogin();">
<div class="top_div"></div>
<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231);border-image:none;width:400px;text-align: center;">

    <form method="post" id="signinform" action="/login/signin">
        <div style="width: 165px; height: 96px; position: absolute;">
            <div class="tou"></div>
            <div class="initial_left_hand" id="left_hand"></div>
            <div class="initial_right_hand" id="right_hand"></div>
        </div>
        <P style="padding: 30px 0px 10px; position: relative;">
            <span class="u_logo"></span>
            <%--非空--%>
            <input class="ipt" id="userName" type="text" name="userName" placeholder="请输入用户名" required="true" />
        </P>
        <P style="position: relative;">
            <span class="p_logo"></span>
            <input class="ipt" id="password" type="password" name="password" placeholder="请输入密码" required="true"/>
        </P>
        <P style="margin: 10px 0px;position: relative;">
            <span class="p_logo"></span>
            <input class="ipt" id="passwordConfirm" type="password" name="passwordConfirm" placeholder="请确认密码" required="true"/>
        </P>
        <P style="position: relative;text-align: left;">
            <input class="rememberMe" type="checkbox" name="rememberMe" value="1" checked style="vertical-align:middle;margin-left:40px;height:20px;"/> 记住密码
        </P>
        <div style="height: 50px; line-height: 50px; margin-top: 10px;border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <span class="info">${msg}</span>
                <span style="float: right;">
                    <a style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" href="javascript:;" onclick="registerForm()">注册</a>
                    <a style="color: rgb(204, 204, 204); margin-right: 10px;" href="javascript:;" onclick="">登录</a>
                </span>
            </P>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/view/commons/basejs.jsp" %>
<script>
    function submitForm(){
        $('#signinform').submit();
    }
    function clearForm(){
        $('#signinform').form('clear');
    }
    function registerForm() {

        if($('#password').val()!=$('#passwordConfirm').val()){
            alert('前后密码不一致!!!');
        }else{
            $('#signinform').submit();
        }
    }
    //回车登录
    function enterlogin(){
        if (event.keyCode == 13){
            event.returnValue=false;
            event.cancel = true;
            $('#signinform').submit();
        }
    }
</script>
</body>
</html>

