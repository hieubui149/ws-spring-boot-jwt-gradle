<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Starter</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../images/favicon.ico" type="image/ico" />

    <%@ include file="../include/import-stylesheet.jspf" %>
</head>
<body class="nav-md">
    <div class="container body">
        <div class="main_container">

            <%@ include file="../include/SideNavigationBar.jspf" %>
            <%@ include file="../include/TopNavigationBar.jspf" %>

            <!-- multiple tabs -->
            <div class="right_col">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist" id="tablist">
                </ul>

                <!-- Tab panes -->
                <div class="tab-content" id="tab_contents">
                </div>

            </div>
            <!-- /multiple tabs -->

            <!-- index -->
            <div class="right_col">
                <iframe frameborder="0"
                    class="iframe_container"
                    style="width: 100%; height: 100%; border: margin: 0px;"
                    id="framex" name="framex" scrolling="yes"
                    src="index">
                </iframe>
            </div>
            <!-- /index -->

            <!-- footer content -->
            <%@ include file="../include/footer.jspf" %>
            <!-- /footer content -->
        </div>
    </div>

    <%@ include file="../include/import-script.jspf" %>
</body>
</html>