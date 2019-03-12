<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript">
    function jumpPage(pages){
        var pageForm = document.getElementById( "pageForm" );
        document.getElementById("pages").value=pages;
        pageForm.action="${url}";
        pageForm.method="post";
        pageForm.submit();
        
    }
</script>
<div class="btn-group" style="float: left;">
    共
    <font color="green">sumPage</font>
    页 当前第
    <font color="red">pages</font>
    页
</div>
<form target="_self" id="pageform">
    <c:if test="${user.user_name!=null }">
        <input type="hidden" name="user_name" value="${user.user_name }">
    </c:if>
    <c:if test="${user.account!=null }">
        <input type="hidden" name="account" value="${user.account }">
    </c:if>
    <input type="hidden" name="pages" id="pages">
    <div class="btn-group" style="float: right;">
        <button onclick="jumpPage(1)" class="btn btn-white">首页</button>
        <button onclick="jumpPage(${(pages-1<1)?1:(pages-1)})" class="btn btn-white">上一页</button>
        <button onclick="jumpPage(${(pages+1>sumPage)?sumPage:(pages+1)})" class="btn btn-white">下一页</button>
        <button onclick="jumpPage(${sumPage })" class="btn btn-white">尾页</button>
    </div>
</form>
</div>