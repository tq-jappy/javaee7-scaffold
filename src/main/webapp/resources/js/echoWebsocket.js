/**
 * 
 */
console.log("load.");
var url = "ws://" + location.host + "/" + location.pathname.split("/")[1]
        + "/echo";
var ws = new WebSocket(url);

ws.onopen = function(event) {
    ws.send("hello");
}

ws.onmessage = function(event) {
    $("#messages").append("received: " + event.data + "<br />");
}

$(document).ready(function() {
    $("#send").click(function() {
        ws.send($("#msg").val());
    });
});
