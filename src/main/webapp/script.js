//http requests
async function doGet(){
    var url = "/roomChat";
    var roomServletUrl = "/room";

    submitPopup();


    var roomName = document.getElementById("chatName").value;
    var maxMembers = document.getElementById("maxMembers").value;

    console.log(roomName + maxMembers);

    var fullUrl = url + roomServletUrl + "?name=" + roomName + "&maxMembers=" + maxMembers;

    var response = await fetch(fullUrl, {
        method: "GET",
        mode: 'cors'
    });
    
    if(response.ok){
        alert("room chat" + roomName + "has been created");
    }

    console.log("response: " + response);

    createChatroomDiv();

    var chatroomHeader = document.getElementById("header-name").value;
    chatroomHeader.value = roomName;


    roomName.value = "";
}

async function doPost(){

}

async function doPut(){

}

async function doDelete(){

}

//functions for html
function createChatroomDiv(){
    var roomName = document.getElementById("chatName").value;
    var maxMembers = document.getElementById("maxMembers").value;

    var div = document.getElementById("chatRooms");

    div.innerHTML += '<div class="chatroom">';
    div.innerHTML += '<button>Join room</button>';
    div.innerHTML += '<label>' + roomName + '</label>';
    div.innerHTML += '<label name="currentMembers">1</label>';
    div.innerHTML += '<label>/</label>';
    div.innerHTML += '<label name="maxMembers">' + maxMembers + '</label>';
    div.innerHTML += '</div>';
}

function setUpRoomChat(){
    var roomName = document.getElementById("chatName").value;
    var maxMembers = document.getElementById("maxMembers").value;

}

function openPopup(){
    let popup = document.getElementById("popup");
    popup.classList.add("open-popup");

    var div = document.getElementById("chatRooms");
    div.style.visibility = "hidden";
}

function submitPopup(){
    let popup = document.getElementById("popup");
    popup.classList.remove("open-popup");

    var div = document.getElementById("chatRooms");
    div.style.visibility = "visible";
}

function closePopup(){
    let popup = document.getElementById("popup");
    popup.classList.remove("open-popup");
    var text = document.getElementById("chatName");
    text.value = "";

    var div = document.getElementById("chatRooms");
    div.style.visibility = "visible";
}

