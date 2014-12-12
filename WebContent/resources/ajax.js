var req;

function submitRequest( assignment_id,  course_id) {
    var url = "AssignmentServlet?assignment_id="+assignment_id+"&course_id="+course_id;
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.open("POST",url,true);
    req.onreadystatechange = callback;
    req.send(null);
    }

function callback() {
    if (req.readyState==4) {
        if (req.status == 200) {
            alert("Upload Count:"+req.responseText);
        }
    }
}