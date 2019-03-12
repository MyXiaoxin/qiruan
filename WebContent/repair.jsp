<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("path", path);
    pageContext.setAttribute("basePath", basePath);
%>
<%@ page import="dao.RepairForm" %>
<%@ page import="entity.Baoxiudan" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
    <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>报修信息管理</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <script src="artDialog/lib/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="artDialog/css/ui-dialog.css">
    <script src="artDialog/dist/dialog-plus.js"></script>
    <script type="text/javascript">
    $(function(){
        
        $("#add").click(function(){
            var addDialog = top.dialog({
                title: '添加报修信息',
                url:'addRepair.jsp',
                onclose:function(){
                    window.location.reload();
                }
            });
            addDialog.showModal();
        })
        
    })
    
    function update(id){
        var addDialog = top.dialog({
            title: '修改报修信息',
            url:'updateRepair.jsp?id='+id,
            onclose:function(){
                window.location.reload();
            }
        });
        addDialog.showModal();
    }
    function deleted(id){
        var addDialog = dialog({
            title: '删除信息',
            content: '确认删除？',
            okValue: '确定',
            ok: function () {
                var addDialog = top.dialog({
                    url:'DelBaoxiudanServlet?id='+id,
                    onclose:function(){
                        window.location.reload();
                    }
                });
                addDialog.showModal();
            },
            cancelValue: '取消',
            cancel: function () {}
        });
        addDialog.showModal();
    }
    
    function detail(id){
        var addDialog = top.dialog({
            title: '查看评价',
            url:'CommServlet?id='+id,
            onclose:function(){
               
            }
        });
        addDialog.showModal();
    }
   
    </script>
</head>
<%-- <%
System.out.print(request.getParameter("userList"));
%> --%>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>报修列表</h5>
                        <div class="ibox-tools">
                        
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_basic.html#">选项1</a>
                                </li>
                                <li><a href="table_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                             <div class="col-sm-5 m-b-xs">
                                <a id="add" class="btn btn-outline btn-primary">添加</a>
                             </div> 
                           <!--  <div class="col-sm-3"> -->
                                <div class="input-group" style="float: right;">
                                <form target="_self" action="repairList">
                                                                        地点：<input type="text" name="location" value="${repair.location }" placeholder="请输入">
                                            <button class="btn btn-sm btn-primary"> 搜索</button>
                                </form>
                                </div>
                          <!--   </div> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>报修人</th>
                                        <th>地点</th>
                                        <th>损坏物</th>
                                        <th>情况描述</th>
                                        <th>报修状态</th>
                                        <th>维修人员</th>
                                        <th>维修结果</th>
                                        <th>报修时间</th>
                                        <th>评价</th>
                                        <th>操作${requestScope.pages.currentPage}</th>
                                    </tr>
                                </thead>
                                <tbody>
                                   <c:forEach items="${pages.data}" var="temp">
                                        <tr>
                                           <td>${temp.bx_stu}</td>
                                            <td>${temp.place}</td>
                                            <td>${temp.thing}</td> 
                                            <td>${temp.description}</td>
                                            <td>
                                            <c:if test="${temp.status==0}"> <font color="black">未处理</font> </c:if>
                                            <c:if test="${temp.status==1}"> <font color="red">未受理</font> </c:if>
                                            <c:if test="${temp.status==2}"> <font color="blue">正在处理</font> </c:if>
                                            <c:if test="${temp.status==3}"> <font color="green">修理完毕</font> </c:if>
                                            </td>
                                            <td>${temp.wx_person}</td> 
                                            <td>${temp.wx_result}</td>
                                            <td>${temp.bx_time }</td>
                                            <td><a id="detail" onclick="detail(${temp.id})">评价</a></td>
                                            <td>
                                                <a id="update" target="_self" class="btn btn-outline btn-success" onclick="update(${temp.id})">修改</a> 
                                                <a id="delete" target="_self" class="btn btn-outline btn-danger" onclick="deleted(${temp.id})">删除</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                               
                                </tbody>
                            </table>
                            <jsp:include page="repairPages.jsp"></jsp:include>
                         </div> 
                    </div>
                </div>
            </div>

        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/plugins/peity/jquery.peity.min.js"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script src="js/demo/peity-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>