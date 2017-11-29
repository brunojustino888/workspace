<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Default.aspx.vb" Inherits="Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<title>WebCam - MedGest</title>
<link rel="stylesheet" type="text/css" href="css/Default.css" media="all"/>
<script type="text/javascript" src="webcam_js/Relogio.js"></script>
<script type="text/javascript" src="webcam_js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="webcam_js/Webcam_Plugin/jquery.webcam.min.js"></script>
<script type="text/javascript">

    function Capture() {
        webcam.capture();
        return false;
    }

    var pageUrl = '<%=ResolveUrl("~/Default.aspx") %>';
    $(function () {
        jQuery("#webcam").webcam({
            width: 320,
            height: 240,
            mode: "save",
            swffile: "webcam_js/Webcam_Plugin/jscam.swf",
            debug: function (type, status) {
                $('#camStatus').append(type + ": " + status + '<br /><br />');
            },
            onSave: function () {
                $.ajax({
                    type: "POST",
                    url: pageUrl + "/GetCapturedImage",
                    data: '',
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (r) {
                        $("[id*=imgCapture]").css("visibility", "visible");
                        $("[id*=imgCapture]").attr("src", r.d);
                    },
                    failure: function (response) {
                        alert(response.d);
                    }
                });
            },
            onCapture: function () {
                webcam.save(pageUrl);
            }
        });
    });

</script>
</head>

<body>
    

<h3>   <img src="img/LogoMsit8.png"/></h3> <hr/>

    <div id="div_css_principal">    
    
    <form id="form1" runat="server">

        <div id="webcam">   <h5>WebCam</h5>     </div>
        

        <div id="div_css_webcam_left">  <h5>Imagem Obtida</h5>
             <asp:Image ID="imgCapture" runat="server" Style="visibility: hidden; width: 320px; height: 240px" />
        </div>
        

        <div id="div_css_webcam_both">
        
            <br /> <br /><hr /><br />
        
            <p><asp:Button ID="btnCapture" Text="Tirar Foto" runat="server" OnClientClick="return Capture(8);" /></p>
            
            <br /><hr />
        
        </div>

        <!-- <span id="camStatus"></span> -->
  
    </form>

    </div>
    
    <div id="tiempo">
        <img id="ampulheta" src="img/ampulheta_mini.png"/>
        <h1 id="relogio">0:0:0</h1>
    </div>
</body>
</html>