<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("path", path);
    pageContext.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="entity.RepairPerson" %>
<%@ page import="dao.RepairForm" %>
<%@ page import="java.util.List" %>
<!DOCTYPE HTML>
<html>
    <head>

    <base href="${basePath}">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>报修信息修改</title>
 
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet">
    <base target="_blank">

	</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <%
                    
	                    RepairForm rf= new RepairForm();
	                    List<RepairPerson> list = rf.repairPerson();
                    %>
                    <div class="ibox-content">
                        <form target="_self" class="form-horizontal m-t"  id="addForm" action="UpdateBaoxiudan" enctype="multipart/form-data">
                            <input type="hidden" id="id" value="<%=request.getParameter("id") %>" name="id">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">维修人员：<%=request.getParameter("id") %></label>
                                <div class="col-sm-8">
                                    <select id="worker_id" name="c" class="input-sm form-control input-s-sm inline">
                                        <option value="0" selected="selected">请选择</option>
                                          
                                        <%
                                        for(int i=0; i<list.size();i++){
                                        	RepairPerson rp = list.get(i);
                                        %>
                                        
                                        <option value="<%=rp.getId()%>"><%=rp.getName()%></option>
                                            
                                       <% }%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">维修结果：</label>
                                <div class="col-sm-8">
                                    <input id="result" name="result" value="正在处理"  type="text" class="form-control" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">报修状态：</label>
                                <div class="col-sm-8">
                                    <select id="status" name="statu" class="input-sm form-control input-s-sm inline">
                                            <option value="1">未受理</option>
                                            <option value="2">正在处理</option>
                                            <option value="3">已完成</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <input class="btn btn-primary" type="submit" value="提交">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                
            </div><!--  -->
            
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/validate/jquery.validate.min.js"></script>
    <script src="js/plugins/validate/messages_zh.min.js"></script>
    <script src="js/demo/form-validate-demo.min.js"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>