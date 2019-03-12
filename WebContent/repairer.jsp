<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
	<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>用户列表</title>


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
    	        title: '添加用户',
    	        url:'addRepairer.jsp',
    	        onclose:function(){
    	        	window.location.reload();
    	        }
    	    });
    		addDialog.showModal();
    	})
    	
    })

    function update(user_id){
        var addDialog = top.dialog({
            title: '修改信息',
            url:'updateRepairer.jsp?id='+user_id,
            onclose:function(){
                window.location.reload();
            }
        });
        addDialog.showModal();
    }
    function deleted(user_id){
    	var addDialog = dialog({
    	    title: '删除',
    	    content: '确认删除？',
    	    okValue: '确定',
    	    ok: function () {
    	    	var addDialog = top.dialog({
    	            url:'DelRepairerServlet?user_id='+user_id,
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
                        <h5>用户列表</h5>
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
                                <form target="_self" action="list">
                                                                        姓名：<input type="text" name="user_name" value="" placeholder="请输入姓名">
                                                                        账号：<input type="text" name="account" value="" placeholder="请输入账号">                                 
                                            <button class="btn btn-sm btn-primary"> 搜索</button>
                                </form>
                                </div>
                          <!--   </div> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th><input name="" type="checkbox" value=""></th>
                                        <th>姓名</th>
                                        <th>账号</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${repairerPager.list}" var="user" >
                                        <tr>
                                            <td><input name="user_id" type="checkbox" value="${user.id }"></td>
                                            <td>${user.name}</td>
                                            <td>${user.id }</td>
                                            <td>
                                                <a id="update" target="_self" class="btn btn-outline btn-success" onclick="update(${user.id})">修改</a> 
                                                <a id="deleted" target="_self" class="btn btn-outline btn-danger" onclick="deleted(${user.id})">删除</a>
                                            </td>
                                        </tr>
                                    </c:forEach> 
                               
                                </tbody>
                            </table>
                            <jsp:include page="repairerPages.jsp"></jsp:include>
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
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>