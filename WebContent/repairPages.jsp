<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript">
    function jumpPage(pp){
        var pageForm = document.getElementById("pageform" );
        document.getElementById("current").value=pp;
        pageForm.action="FenyeServlet";
        pageForm.method="post";
        pageForm.submit();
        parent.location.reload()
    }
</script>
<div class="btn-group" style="float: left;">
    共
    <font color="green">${pages.paeSize }</font>
    页 当前第
    <font color="red">${pages.currentPage}</font>
    页
</div>
<form target="_self" id="pageform">
    <input type="hidden" name="current" id="current">
    <div class="btn-group" style="float: right;">
        <button onclick="jumpPage(1)" class="btn btn-white">首页</button>
        <button onclick="jumpPage(${(pages.currentPage-1<1)?1:(pages.currentPage-1)})" class="btn btn-white">上一页</button>
        <button onclick="jumpPage(${(pages.currentPage+1>pages.paeSize)?pages.paeSize:(pages.currentPage+1)})" class="btn btn-white">下一页</button>
        <button onclick="jumpPage(${pages.paeSize})" class="btn btn-white">尾页</button>
    </div>
</form>
</div>