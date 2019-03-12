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

		<base href="${basePath}">
		<meta charset="UTF-8">
		<title>Create Account</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css"> 
        
        <script type="text/javascript">
        function provinceChange(){
            var province=document.getElementById("province");
            var index = province.selectedIndex; // 选中索引
            var pr_id = province.options[index].value; 
            
             $.ajax({     
                type: 'post',     
                url: "user/selCity",     
                cache: false,     
                data: {"pr_id":pr_id},     
                dataType: 'json',     
                success: function(data){     
                    var str='';
                    jQuery.each(data, function(i,item){     
                        alert(i+","+item);   
                        str+='<option value="'+i+'">'+item+'</option>';
                    });     
                    jQuery("#city").append(str);
                },     
                error: function(){     
                    return;     
                }     
            });    
        }
        
        function cityChange(){
            var city=document.getElementById("city");
            var index = city.selectedIndex; // 选中索引
            var ci_id = city.options[index].value; 
             $.ajax({     
                type: 'post',     
                url: "user/selSchool",     
                cache: false,     
                data: {"ci_id":ci_id},     
                dataType: 'json',     
                success: function(data){     
                    var str='';
                    jQuery.each(data, function(i,item){     
                        alert(i+","+item);    
                        str+='<option value="'+item+'">'+item+'</option>';
                    });     
                    jQuery("#school").append(str);
                },     
                error: function(){     
                    return;     
                }     
            });   
            var pro=$("#province option:selected").html();
            var cit=$("#city  option:selected").html();
            alert(pro+"  "+cit)
            jQuery("#form").append("<input type='hidden' name='addresser' value='"+pro+city+"'></input>");
        }
        </script>
    </head>
    <body class="templatemo-bg-gray">
        <h1 class="margin-bottom-15">Create Account</h1>
        <div class="container">
            <div class="col-md-12">         
                <form id="form" class="form-horizontal templatemo-create-account templatemo-container" role="form" action="user/addClients" method="post">
                    <div class="form-inner">
                        <div class="form-group">
                          <div class="col-md-6">                    
                            <label for="first_name" class="control-label">Account</label>
                            <input name="account" type="text" class="form-control" id="first_name" placeholder="">                                                         
                          </div>  
                          <div class="col-md-6">                    
                            <label for="last_name" class="control-label">Name</label>
                            <input name="client_name" type="text" class="form-control" id="last_name" placeholder="">                                                          
                          </div>             
                        </div>
                        <div class="form-group">
                          <div class="col-md-12">                   
                            <label for="username" class="control-label">Age</label>
                            <input name="age" type="text" class="form-control" id="age" placeholder="">                                                         
                          </div>              
                          <div class="col-md-6 templatemo-radio-group">
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="optionsRadios1" value="0"> Male
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="optionsRadios2" value="1"> Female
                            </label>
                          </div>             
                        </div>
                        <div class="form-group">
                          <div class="col-md-6">
                            <label for="password" class="control-label">Password</label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="">
                          </div>
                          <div class="col-md-6">
                            <label for="password" class="control-label">Confirm Password</label>
                            <input type="password" class="form-control" id="password_confirm" placeholder="">
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-md-12">                    
                            <label for="first_name" class="control-label">Tel</label>
                            <input name="tel" type="tel" class="form-control" id="tel" placeholder="">                                                         
                          </div>  
                          <div class="col-md-6">                    
                            <label for="last_name" class="control-label">Location</label> 
                            <div>
                            <div style="float:left;width:200px;">
                                    <select id="province" name="pr_id" onchange="provinceChange()" style="width:50;" class="input-sm form-control input-s-sm inline">
                                        <option value="0">请选择</option>
                                        <c:forEach items="${provinceList }" var="province">
                                            <option value="${province.pr_id }">${province.pr_province }</option>
                                        </c:forEach>
                                    </select>
                                </div float="left">
                                <div style="float:left;width:50px;">&nbsp;<input type="hidden"></div>
                                <div style="float:left;width:200px;">
                                    <select id="city" name="ci_id" onchange="cityChange()" style="width:50;" onchange="cityChange()" class="input-sm form-control input-s-sm inline">
                                        <option value="0">请选择</option>
                                    </select>
                                </div>
                            </div> 
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-md-6">
                            <label for="password" class="control-label">School</label>
                            <select id="school" name="school" class="input-sm form-control input-s-sm inline">
                                    <option value="0">请选择</option>
                            </select>
                          </div>
                          <div class="col-md-6">
                            <label for="" class="control-label">student ID</label>
                            <input type="text" name="student_id" class="form-control" id="student_id" placeholder="">
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="col-md-12">
                            <input type="submit" value="Create account" class="btn btn-info">
                          </div>
                        </div>  
                    </div>                      
                  </form>             
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
              </div>
              <div class="modal-body">
                <p>This form is provided by <a rel="nofollow" href="http://www.cssmoban.com/page/1">Free HTML5 Templates</a> that can be used for your websites. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>