<%@ page import="cn.stock.bean.User" %>
<%@page pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/login/login">Main Menu v1.0</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <%--<li class="dropdown">--%>
            <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                <%--<i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>--%>
            <%--</a>--%>
            <%--<ul class="dropdown-menu dropdown-messages">--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<strong>John Smith</strong>--%>
                            <%--<span class="pull-right text-muted">--%>
                                        <%--<em>//time</em>--%>
                                    <%--</span>--%>
                        <%--</div>--%>
                        <%--<div>//msg</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<strong>John Smith</strong>--%>
                            <%--<span class="pull-right text-muted">--%>
                                        <%--<em>Yesterday</em>--%>
                                    <%--</span>--%>
                        <%--</div>--%>
                        <%--<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<strong>John Smith</strong>--%>
                            <%--<span class="pull-right text-muted">--%>
                                        <%--<em>Yesterday</em>--%>
                                    <%--</span>--%>
                        <%--</div>--%>
                        <%--<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a class="text-center" href="#">--%>
                        <%--<strong>Read All Messages</strong>--%>
                        <%--<i class="fa fa-angle-right"></i>--%>
                    <%--</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<!-- /.dropdown-messages -->--%>
        <%--</li>--%>
        <!-- /.dropdown -->
        <%--<li class="dropdown">--%>
            <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                <%--<i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>--%>
            <%--</a>--%>
            <%--<ul class="dropdown-menu dropdown-tasks">--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<p>--%>
                                <%--<strong>Task 1</strong>--%>
                                <%--<span class="pull-right text-muted">40% Complete</span>--%>
                            <%--</p>--%>
                            <%--<div class="progress progress-striped active">--%>
                                <%--<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">--%>
                                    <%--<span class="sr-only">40% Complete (success)</span>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<p>--%>
                                <%--<strong>Task 2</strong>--%>
                                <%--<span class="pull-right text-muted">20% Complete</span>--%>
                            <%--</p>--%>
                            <%--<div class="progress progress-striped active">--%>
                                <%--<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">--%>
                                    <%--<span class="sr-only">20% Complete</span>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<p>--%>
                                <%--<strong>Task 3</strong>--%>
                                <%--<span class="pull-right text-muted">60% Complete</span>--%>
                            <%--</p>--%>
                            <%--<div class="progress progress-striped active">--%>
                                <%--<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">--%>
                                    <%--<span class="sr-only">60% Complete (warning)</span>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<p>--%>
                                <%--<strong>Task 4</strong>--%>
                                <%--<span class="pull-right text-muted">80% Complete</span>--%>
                            <%--</p>--%>
                            <%--<div class="progress progress-striped active">--%>
                                <%--<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">--%>
                                    <%--<span class="sr-only">80% Complete (danger)</span>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a class="text-center" href="#">--%>
                        <%--<strong>See All Tasks</strong>--%>
                        <%--<i class="fa fa-angle-right"></i>--%>
                    <%--</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<!-- /.dropdown-tasks -->--%>
        <%--</li>--%>
        <!-- /.dropdown -->
        <%--<li class="dropdown">--%>
            <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                <%--<i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>--%>
            <%--</a>--%>
            <%--<ul class="dropdown-menu dropdown-alerts">--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<i class="fa fa-comment fa-fw"></i> New Comment--%>
                            <%--<span class="pull-right text-muted small">4 minutes ago</span>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<i class="fa fa-twitter fa-fw"></i> 3 New Followers--%>
                            <%--<span class="pull-right text-muted small">12 minutes ago</span>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<i class="fa fa-envelope fa-fw"></i> Message Sent--%>
                            <%--<span class="pull-right text-muted small">4 minutes ago</span>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<i class="fa fa-tasks fa-fw"></i> New Task--%>
                            <%--<span class="pull-right text-muted small">4 minutes ago</span>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a href="#">--%>
                        <%--<div>--%>
                            <%--<i class="fa fa-upload fa-fw"></i> Server Rebooted--%>
                            <%--<span class="pull-right text-muted small">4 minutes ago</span>--%>
                        <%--</div>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li>--%>
                    <%--<a class="text-center" href="#">--%>
                        <%--<strong>See All Alerts</strong>--%>
                        <%--<i class="fa fa-angle-right"></i>--%>
                    <%--</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<!-- /.dropdown-alerts -->--%>
        <%--</li>--%>
        <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <%--<a href="#">--%>
                            <div style="padding-left: 20px;font-size: 15px">
                                <i class="fa fa-hand-o-right fa-fw"></i><span style="padding-left: 10px">Welcome</span>
                                <%User user = (User)request.getSession().getAttribute("user");%>
                                <span style="color: #9C9C9C;padding-right: 20px;float: right">
                                <%=user.getUserName()%></span>
                            </div>
                        <%--</a>--%>
                    </li>
                    <li>
                        <a class="text-center" href="/login/logout">
                            <strong>Log Out</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-alerts -->
            </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="/login/"><i class="fa fa-dashboard fa-fw"></i> 系统面板
                    </a>
                </li>
                <li>
                    <a href="/user/"><i class="fa fa-users fa-fw"></i> 用户</a>
                </li>
                <li>
                    <a href="/stock/"><i class="fa fa-table fa-fw"></i> 库存总览</a>
                </li>
                <li>
                    <a href="/logs/"><i class="fa fa-list-ul fa-fw"></i> 库存日志</a>
                </li>
                <li>
                    <a href="/unit/"><i class="fa fa-bank fa-fw"></i> 单位管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/unit/add/"> 新增单位</a>
                        </li>
                        <li>
                            <a href="/unit/"> 查看单位</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>

                <li>
                    <a href="/goods/"><i class="fa fa-cubes fa-fw"></i> 物料管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/goods/add/"> 新增物料</a>
                        </li>
                        <li>
                            <a href="/goods/"> 查看物料</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="/wv/"><i class="fa fa-file-text fa-fw"></i> 入库单<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/wv/add/"> 新增入库单</a>
                        </li>
                        <%--<li>--%>
                            <%--<a href="/wv/update/"> 修改入库单</a>--%>
                        <%--</li>--%>
                        <li>
                            <%--先弹框输id，再显示入库单具体信息--%>
                            <a href="/wv/"> 查询入库单</a>
                        </li>
                        <%--<li>--%>
                            <%--&lt;%&ndash;id未写&ndash;%&gt;--%>
                            <%--<a href="/wv/delete/"> 删除入库单</a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">Third Level <span class="fa arrow"></span></a>--%>
                            <%--<ul class="nav nav-third-level">--%>
                                <%--<li>--%>
                                    <%--<a href="#">Third Level Item</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="#">Third Level Item</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                            <%--<!-- /.nav-third-level -->--%>
                        <%--</li>--%>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="/dv/"><i class="fa fa-file-text-o fa-fw"></i> 出库单<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/dv/add/"> 新增出库单</a>
                        </li>
                        <li>
                            <a href="/dv/"> 查询出库单</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>