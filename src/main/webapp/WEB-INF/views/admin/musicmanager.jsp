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
    /resources/admin/
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
                    <li> <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Manager<span class="fa arrow"></span></a>
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
                        <h1 class="page-header">Music Manager</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div>
                                    <button class="btn btn-outline btn-danger" data-toggle="modal"
                                        data-target="#addNewAdmin">Demo 1</button>
                                    <button class="btn btn-outline btn-success" data-toggle="modal"
                                        data-target="#newsongModal">Add New a Song</button>
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover"
                                        id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Logo Song</th>
                                                <th>Song name</th>
                                                <th style="width: 185px">Singer name</th>
                                                <th>Path Song</th>
                                                <th>Deleted</th>
                                                <th>Count Listens</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach var="song" items="${listSong}">
                                                <tr class="odd gradeX">
                                                    <td><c:out value="${song.id}"/></td>
                                                    <td><img src="<c:out value='${song.logoPath}'/>" alt="" height="70" width="70" style="padding:3px" ></td>
                                                    <td style="width: 200px"><c:out value="${song.songName}"/></td>
                                                    <td><c:out value="${song.singerName}"/></td>
                                                    <td><c:out value="${song.songPath}"/></td>
                                                    <c:choose>
                                                        <c:when test="${song.deleted==true}">
                                                            <td> <button style="width:2px;height: 2px; text-align: center;margin-left: 20px; margin-right: 20px"
                                                                         class= "btn  btn-success" </button> </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td> <button style="width:2px;height: 2px; text-align: center;margin-left: 20px; margin-right: 20px"
                                                                         class="btn  btn-danger"
                                                            ></button> </td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <td><c:out value="${song.countListens}"/></td>

                                                    <td>
                                                        <button class="btn btn-outline btn-primary" data-toggle="modal"
                                                                data-target="#editModal" onclick="editsong(${song.id},'${song.songName}','${song.singerName}')" >Edit</button>
                                                    </td>
                                                    <td style="text-align: center">
                                                        <button class="btn btn-outline btn-danger" data-toggle="modal"
                                                                data-target="#deleteModal" onclick="deleteSong(${song.id})">Delete</button>
                                                    </td>
                                                </tr>

                                            </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                                <!-- jQuery -->
                                <!-- Litst Modal ssssss -->
                                <!-- Modal -->
                                <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                                    aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                    aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">Edit Information Song</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-md-12 mx-auto">
                                                        <form action="/song?action=editSong" method="post">
                                                            <div class="row">
                                                                <div class="col-md-12 mx-auto">
                                                                        <div class="form-group row">
                                                                            <div class="col-sm-6">
                                                                                <%--@declare id="inputsongname"--%><label for="inputSongname">Song name</label>
                                                                                <input type="text" class="form-control"
                                                                                    id="inputEditSongname" name="inputEditSongname" placeholder="Song name" required>
                                                                            </div>
                                                                            <div class="col-sm-6">
                                                                                <%--@declare id="inputsingername"--%><label for="inputSingerName">Singer Name</label>
                                                                                <input type="text" class="form-control"
                                                                                    id="inputEditSingerName" name="inputEditSingerName" placeholder="Singer Name" required>
                                                                            </div>
                                                                        </div>
                                                                    <input type="text" hidden
                                                                           id="editId" name="editId" required>
                                                                        <div class="form-group row">
                                                                            <div class="col-sm-6">
                                                                                <label for="statusselect" >Select Status</label>
                                                                                <br>
                                                                               <select  name="statusselect" id="statusselect">
                                                                                <option id="optionAlivai"  value="alivaible">ALIVAIBLE</option>
                                                                                <option  id="optionDisab" value="disabled">DISABLED</option>
                                                                               </select>
                                                                            </div>
                                                                     </div>
                                                                </div>
                                                            </div>
                                                            <!-- Modal footer -->
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal">Close</button>
                                                                <button type="submit" class="btn btn-primary"
                                                                    id="savechangesbtn">Save</button>
                                                            </div>
                                                      </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->


                            <div id="deleteModal" class="modal fade">
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
                                            <p style="margin-left: 60px;">Do you really want to delete this song? This
                                                process cannot be undone.</p>
                                        </div>
                                        <form action="/song?action=deleteSong" method="post">
                                            <input type="text" name="deleteid" id="deleteid" hidden>
                                            <div class="modal-footer justify-content-center">
                                                <button type="button" class="btn btn-secondary"
                                                        data-dismiss="modal">Cancel</button>
                                                <button type="submit" class="btn btn-danger">Delete</button>
                                            </div>
                                        </form>

                                    </div>
                                </div>
                            </div>


                            <!-- Modal -->
                            <div class="modal fade" id="newsongModal" tabindex="-1" role="dialog"
                                aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">ADD NEW SONG</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-md-12 mx-auto">
                                                    <form action="/song?action=upNewSong" method="post" enctype='multipart/form-data'>
                                                        <div class="row">
                                                            <div class="col-md-12 mx-auto">
                                                                    </div>
                                                                <div style="margin-left: 15px" class="form-group row">
                                                                    <div class="col-sm-6">
                                                                        <label for="upFilemp3">Up Song File</label>
                                                                        <input id="upFilemp3" accept=".mp3" type="file" name="songFile" required>
                                                                    </div>
                                                                    <div class="col-sm-6">
                                                                        <label for="upFileimg">Up Logo Song File</label>
                                                                        <input id="upFileimg" accept=".jpg, .png" type="file" name="logoFile" required>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                        <!-- Modal footer -->
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default"
                                                                data-dismiss="modal">Close</button>
                                                            <button type="submit" class="btn btn-primary"
                                                                id="addnewadminbtn">Add</button>
                                                        </div>
                                                </div>
                                                </form>
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


                            function editsong(id,songName,singerName){
                                document.getElementById("editId").value = id;
                                document.getElementById("inputEditSongname").value = songName;
                                document.getElementById("inputEditSingerName").value = singerName;
                            }
                            function deleteSong(id){
                                document.getElementById("deleteid").value = id;
                            }
                        </script>

</body>

</html>