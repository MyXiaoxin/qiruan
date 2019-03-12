<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<script type="text/javascript">
    function jumpPage(pages){
        var pageForm = document.getElementById( "pageForm" );
        document.getElementById("num").value=pages;
        pageForm.action="RepairerFenyeServlet";
        pageForm.method="post";
        pageForm.submit();
        parent.window.location.reload();
    }
</script>
<div class="btn-group" style="float: left;">
    共
    <font color="green">${repairerPager.pageSum}</font>
    页 当前第
    <font color="red">${(repairerPager.currentPage)}</font>
    页
</div>
<form target="_self" id="pageForm">
    <input type="hidden" name="num" id="num">
    <div class="btn-group" style="float: right;">
        <button onclick="jumpPage(1)" class="btn btn-white">首页</button>
        <button onclick="jumpPage(${(repairerPager.currentPage-1<1)?1:(repairerPager.currentPage-1)})" class="btn btn-white">上一页</button>
        <button onclick="jumpPage(${(repairerPager.currentPage+1>repairerPager.pageSum)?repairerPager.pageSum:(repairerPager.currentPage+1)})" class="btn btn-white">下一页</button>
        <button onclick="jumpPage(${repairerPager.pageSum})" class="btn btn-white">尾页</button>
    </div>
</form>
</div>