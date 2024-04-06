//http requests
var url = "/roomChat";
var roomServletUrl = "/room";

async function doGet(){
    var roomName = document.getElementById("chatName").value;
    var maxMembers = document.getElementById("maxMembers").value;

    if(roomName = ""){
        alert("Room name is empty");

    } else {
    var url = url + roomServletUrl + "?name=" + roomName + "&maxMembers=" + maxMembers;

    var response = await fetch(url, {
        method: "GET"
    });
    
    if(response.ok){
        alert("room chat" + roomName + "has been created");
    }

    console.log("response: " + response);

    submitPopup();
    }
}

async function doPost(){

}

async function doPut(){

}

async function doDelete(){

}

//functions for html
function openPopup(){
    let popup = document.getElementById("popup");
    popup.classList.add("open-popup");
}

function submitPopup(){
    var text = document.getElementById("chatName");

    text.value = "";

    let popup = document.getElementById("popup");
    popup.classList.remove("open-popup");
}

function closePopup(){
    let popup = document.getElementById("popup");
    popup.classList.remove("open-popup");
    var text = document.getElementById("chatName");
    text.value = "";
}