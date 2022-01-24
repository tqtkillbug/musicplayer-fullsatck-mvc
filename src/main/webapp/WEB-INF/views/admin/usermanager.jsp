<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TQT Music Admin</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/admin/css/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="/resources/admin/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/admin/css/startmin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/resources/admin/css/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="/pages?action=dashboard">TQT Admin</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <ul class="nav navbar-nav navbar-left navbar-top-links">
            <li><a href="#"><i class="fa fa-home fa-fw"></i> Website</a></li>
        </ul>

        <ul class="nav navbar-right navbar-top-links">
            <li class="dropdown navbar-inverse">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-comment fa-fw"></i> New Comment
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                <span class="pull-right text-muted small">12 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-envelope fa-fw"></i> Message Sent
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-tasks fa-fw"></i> New Task
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> ${admin.fullName}<b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/login?action=logOut"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="/pages?action=dashboard" class="active"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Manager<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/pages?action=usermanager">Users</a>
                            </li>
                            <li>
                                <a href="/song?action=musicmanager">Musics</a>
                            </li>
                        </ul>
                    </li>
                    <!--          Chỉnh sửa table ở đây>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
-->

                </ul>
            </div>
        </div>
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <table>
                        <tr>
                            <td>
                                <h1 class="page-header">User Manager</h1>
                            </td>

                        </tr>
                    </table>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div>
                                <button class="btn btn-outline btn-success" data-toggle="modal"
                                        data-target="#newAdminModal">Add New Admin
                                </button>

                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Full Name</th>
                                        <th>Email Address</th>
                                        <th>Role</th>
                                        <th>Status</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${listUser}">
                                        <tr class="odd gradeX">
                                            <td><c:out value="${user.id}"/></td>
                                            <td><c:out value="${user.fullName}"/></td>
                                            <td><c:out value="${user.email}"/></td>
                                            <td><c:out value="${user.role}"/></td>
                                            <c:choose>
                                                <c:when test="${user.deleted==0}">
                                                    <td>
                                                        <button style="width:2px;height: 2px; text-align: center;margin-left: 20px"
                                                                class="btn  btn-success"
                                                        </button> </td>
                                                </c:when>

                                                <c:otherwise>
                                                    <td>
                                                        <button style="width:2px;height: 2px; text-align: center;margin-left: 20px"
                                                                class="btn  btn-danger"
                                                        ></button>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>

                                            <c:choose>
                                                <%-- Khi tham số color == 'red' --%>
                                                <c:when test="${user.status==0}">
                                                    <td style="text-align: center">
                                                        <button style="width:80px"
                                                                class="btn btn-outline btn-danger"
                                                                data-toggle="modal"
                                                                data-target="#blockModal"
                                                                onclick="blockuser(${user.id})">
                                                            Block
                                                        </button>
                                                    </td>
                                                </c:when>
                                                <%-- Các trường hợp khác --%>
                                                <c:otherwise>
                                                    <td style="text-align: center">
                                                        <button style="width: 80px"
                                                                class="btn btn-outline btn-success"
                                                                data-toggle="modal"
                                                                data-target="#blockModal"
                                                                onclick="acviveuser(${user.id})">
                                                            ACTIVE
                                                        </button>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>


                                            <td style="text-align: center">
                                                <button class="btn btn-outline btn-primary" data-toggle="modal"
                                                        data-target="#sendmailModal"
                                                        onclick="sendmailtouser('<c:out
                                                                value='${user.email}'/>','${admin.username}')">
                                                    Send
                                                    Mail
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    <%-- BOSS------------------------------------------- --%>

                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                            <!-- jQuery -->
                            <!-- Litst Modal ssssss -->
                            <!-- Modal -->
                            <div class="modal fade" id="sendmailModal" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"
                                                    aria-hidden="true">&times;
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-md-12 mx-auto">
                                                    <form action="pages?action=sendmailtouser" method="post">
                                                        <div class="col-sm-10">

                                                            <label for="inputTitleMail">Title Mail</label>
                                                            <input type="text" class="form-control"
                                                                   id="inputTitleMail" name="titleEmail"
                                                                   placeholder="Title mail"
                                                                   required>
                                                            <label for="inputContentMail">Content Mail</label>
                                                            <textarea class="form-control" id="inputContentMail"
                                                                      cols="30" rows="10" name="contentMail"
                                                                      required></textarea>
                                                        </div>
                                                        <input type="text" class="form-control"
                                                               id="emailuser" name="emailuser" style="display: none">
                                                        <input type="text" class="form-control"
                                                               id="inputFromAdmin"
                                                               name="inputFromAdmin" style="display:none">
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal" style="margin-top: 80px">Close
                                                            </button>
                                                            <button type="submit" class="btn btn-primary"
                                                                    id="sendmailbtn" style="margin-top: 20px">Send
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>

                                            </div>

                                        </div>
                                    </div>

                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->


                        <div id="blockModal" class="modal fade">
                            <div class="modal-dialog modal-confirm">
                                <div class="modal-content">
                                    <div class=" flex-column" style="margin-left: 240px; margin-top: 10px;">
                                        <h4 class="modal-title w-100">Are you sure?</h4>
                                        <div class="icon-box"
                                             style="font-size: 40px; margin-left: 35px; margin-top: 10px;">
                                            <i class="fa fa-info-circle"></i>
                                        </div>
                                    </div>
                                    <div class="modal-body">
                                        <p style="margin-left: 60px;" id="modalBlockContent">Do you really want to Block
                                            these user? This
                                            process cannot be undone.</p>
                                        <input type="text"
                                               id="iduserinput"
                                               required style="display: none">
                                        <div class="modal-footer justify-content-center">
                                            <button type="button" class="btn btn-secondary"
                                                    data-dismiss="modal">Cancel
                                            </button>
                                            <a href="#" id="blockbtn" class="btn btn-danger">Block</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- Modal -->
                        <div class="modal fade" id="newAdminModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;
                                        </button>
                                        <h4 class="modal-title" >ADD NEW ADMIN</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-md-12 mx-auto">
                                                <form action="pages?action=addnewadmin" method="post">
                                                    <div class="form-group row">
                                                        <div class="col-sm-6">
                                                            <label for="inputFullname">Full name</label>
                                                            <input type="text" class="form-control"
                                                                   id="inputFullname" name="inputFullname"
                                                                   placeholder="Full name" required>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="inputUsername">Username</label>
                                                            <input type="text" class="form-control"
                                                                   id="inputUsername" name="inputUsername"
                                                                   placeholder="Username" required>
                                                        </div>
                                                        <input type="text" class="form-control"
                                                               id="adminNameform" name="adminNameform"
                                                               value="${admin.username}" style="display:none">
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-sm-6">
                                                            <label for="inputEmail">Email</label>
                                                            <input type="text" class="form-control" id="inputEmail"
                                                                   name="inputEmail" placeholder="Email" required
                                                                   pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label for="inputPassword">Password</label>
                                                            <input type="password" class="form-control"
                                                                   id="inputPassword" name="inputPassword"
                                                                   placeholder="Password" required>
                                                        </div>

                                                    </div>
                                                    <!-- Modal footer -->
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default"
                                                                data-dismiss="modal">Close
                                                        </button>
                                                        <button type="submit" class="btn btn-primary"
                                                                id="addnewadminbtn">Add
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->


                    <!-- MODALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLl -->


                    <script src="/resources/admin/js/jquery.min.js"></script>

                    <!-- Bootstrap Core JavaScript -->
                    <script src="/resources/admin/js/bootstrap.min.js"></script>

                    <!-- Metis Menu Plugin JavaScript -->
                    <script src="/resources/admin/js/metisMenu.min.js"></script>

                    <!-- DataTables JavaScript -->
                    <script src="/resources/admin/js/dataTables/jquery.dataTables.min.js"></script>
                    <script src="/resources/admin/js/dataTables/dataTables.bootstrap.min.js"></script>

                    <!-- Custom Theme JavaScript -->
                    <script src="/resources/admin/js/startmin.js"></script>

                    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
                    <script>
                        $(document).ready(function () {
                            $('#dataTables-example').DataTable({
                                responsive: true
                            });
                        });

                        function checkmatchpassword() {
                            let pass = document.getElementById("inputPassword").value
                            let confirmPassword = document.getElementById("inputRe-Password").value;
                            if (pass !== confirmPassword) {
                                document.getElementById("labelpassmatch").innerHTML = "Password Not Match!!";
                                // document.getElementById("addnewadminbtn").disabled = true;
                            } else {
                            }
                            // document.getElementById("addnewadminbtn").disabled = true;
                        }

                        function blockuser(id) {
                            document.getElementById("modalBlockContent").innerText = "Do you really want to Block these user? This process cannot be undone";
                            let block = document.getElementById("blockbtn");
                            document.getElementById("blockbtn").innerText = "BLOCK";
                            block.href = "/pages?action=block&id=" + id;
                        }

                        function acviveuser(id) {
                            document.getElementById("modalBlockContent").innerText = "Are you sure to activate this user? This process cannot be undone";
                            document.getElementById("blockbtn").innerText = "ACTIVE";
                            let block = document.getElementById("blockbtn");
                            block.href = "/pages?action=active&id=" + id;
                        }


                        function sendmailtouser(email, fromadmin) {
                            document.getElementById("emailuser").value = email;
                            document.getElementById("inputFromAdmin").value = fromadmin;
                        }

                        setTimeout(hideelment, 4000)

                        function hideelment() {
                            document.getElementById("message").classList.add("hide");
                        }

                    </script>

</body>

</html>