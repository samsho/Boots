<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 2016/8/3
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Uediter</title>
    <meta charset="utf-8">
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>/uediter/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>/uediter/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>/uediter/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<form>
    <script id="edit" type="text/plain">
        输入文字

    </script>
</form>

<script type="text/javascript">
    var editor = UE.getEditor("edit");
</script>

</body>
</html>
