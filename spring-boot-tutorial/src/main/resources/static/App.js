function onPlay() {
    let errorFlag = false;
    if (document.querySelector('[id="player1"]').value==""){
        alert("Enter name of Player 1");
        errorFlag = true;
    }
    else if (document.querySelector('[id="player2"]').value=="") {
        alert("Enter name of Player 2");
        errorFlag = true;
    }

    if (errorFlag==true) return;

    $.getJSON('http://localhost:8080/refreshrepository', function (data) { });
    document.getElementById("login").style.display = "none";
    document.getElementById("displayPlayer1").innerHTML=document.querySelector('[id="player1"]').value;
    document.getElementById("displayPlayer2").innerHTML=document.querySelector('[id="player2"]').value;
    document.getElementById("outerFrame").style.display = "";
    setTimeout(function() { },1000);
}

addPots();
addEventListenerPot();
initialBeadCount();
setTitle();

function addPots() {
    let beadsTemplate;
    beadsTemplate = document.getElementsByTagName("template")[1].content.querySelector("div");
    let nodeId;
    for (let i = 1; i <= 6; i++) {
        nodeId = beadsTemplate.cloneNode();
        nodeId.id = "pt" + i;
        document.getElementById('potsTop').appendChild(nodeId);
        nodeId = beadsTemplate.cloneNode();
        nodeId.id = "pb" + i;
        document.getElementById('potsBottom').appendChild(nodeId);
    }
}

function addEventListenerPot() {
    for (let i = 1; i <= 6; i++) {
        document.getElementById('pb' + i).addEventListener("click", clickPot);
        document.getElementById('pt' + i).addEventListener("click", clickPot);
    }
}

function initialBeadCount() {
    let beadsTemplate;
    beadsTemplate = document.getElementsByTagName("template")[0].content.querySelector("div");
    let beadCount = getCurrentCount();
    setTimeout(function() {
        beadCount = JSON.parse(beadCount.responseText);
        for (let j = 1; j <= 6; j++) {
            potId = "pb"+j;
            for (let i = 0; i < beadCount[potId]; i++) document.getElementById('pb' + j).appendChild(beadsTemplate.cloneNode());
            potId = "pt"+j;
            for (let i = 0; i < beadCount[potId]; i++) document.getElementById('pt' + j).appendChild(beadsTemplate.cloneNode());
        }
        for (let i = 0; i < beadCount["m1"]; i++) document.getElementById('mt').appendChild(beadsTemplate.cloneNode());
        for (let i = 0; i < beadCount["m2"]; i++) document.getElementById('mb').appendChild(beadsTemplate.cloneNode());
        positionBeads();
    }, 3000);
}

function getCurrentCount() {
    let beadCount = $.getJSON('http://localhost:8080/beadcount', function (data) {
        return data;
    });
    return beadCount;
}

function setTitle() {
    let beadCount = getCurrentCount();
    setTimeout(function() {
        if (beadCount.responseText!="null") {
            for (let i = 0; i < document.querySelectorAll('[id^="pt"]').length; i++) {
                document.querySelectorAll('[id^="pt"]')[i].title = JSON.parse(beadCount.responseText)[document.querySelectorAll('[id^="pt"]')[i].id];
            }
            for (let i = 0; i < document.querySelectorAll('[id^="pb"]').length; i++) {
                document.querySelectorAll('[id^="pb"]')[i].title = JSON.parse(beadCount.responseText)[document.querySelectorAll('[id^="pb"]')[i].id];
            }
        }
    }, 3000);
}

function positionBeads() {
    let abc = 0;
    let beadCount = 0;
    let closestId = "";
    for (let i = 0; i < document.querySelectorAll('.bead').length; i++) {
        if (closestId != document.querySelectorAll('.bead')[i].parentNode.id) {
            abc = 0;
            beadCount = 0;
            closestId = document.querySelectorAll('.bead')[i].parentNode.id
        }
        if (beadCount < 5) {
            document.querySelectorAll('.bead')[i].style = "transform: rotate(" + abc + "deg) translate(150%)";
            document.querySelectorAll('.bead')[i].style.background = "white";
            abc += 72;
        } else if (beadCount < 15) {
            document.querySelectorAll('.bead')[i].style = "transform: rotate(" + abc + "deg) translate(300%)";
            document.querySelectorAll('.bead')[i].style.backgroundColor = "black";
            abc += 36;
        } else if (beadCount == 15) {
            document.querySelectorAll('.bead')[i].style = "transform: rotate(0deg) translate(0%)";
            document.querySelectorAll('.bead')[i].style.backgroundColor = "yellow";
        } else {
            document.querySelectorAll('.bead')[i].style.display = "none"
        }
        beadCount++;
    }
}

function clickPot() {
    var clickedPotId = "";
    clickedPotId = event.target.id;
    if (event.target.id == "") {
        clickedPotId = event.target.parentNode.id;
    }
    alert(clickedPotId);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", 'http://localhost:8080/gameaction', true);

    //Send the proper header information along with the request
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xhr.onreadystatechange = function() { // Call a function when the state changes.
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        }
    }
    xhr.send("cupId=pt2");

    setTimeout(function() {
        let beadCount = getCurrentCount();
        setTimeout(function() {
            let beadsTemplate;
            beadsTemplate = document.getElementsByTagName("template")[0].content.querySelector("div");
            for (let i = 0; i < document.querySelectorAll('[id^="pt"]').length; i++) {
                document.querySelectorAll('[id^="pt"]')[i].innerHTML = '';
                for (let j = 1; j <= JSON.parse(beadCount.responseText)[document.querySelectorAll('[id^="pt"]')[i].id]; j++) {
                    document.querySelectorAll('[id^="pt"]')[i].appendChild(beadsTemplate.cloneNode());
                }
            }
            for (let i = 0; i < document.querySelectorAll('[id^="pb"]').length; i++) {
                document.querySelectorAll('[id^="pb"]')[i].innerHTML = '';
                for (let j = 1; j <= JSON.parse(beadCount.responseText)[document.querySelectorAll('[id^="pb"]')[i].id]; j++) {
                    document.querySelectorAll('[id^="pb"]')[i].appendChild(beadsTemplate.cloneNode());
                }
            }
            for (let i = 0; i < JSON.parse(beadCount.responseText)["m1"]; i++) document.getElementById('mt').appendChild(beadsTemplate.cloneNode());
            for (let i = 0; i < JSON.parse(beadCount.responseText)["m2"]; i++) document.getElementById('mb').appendChild(beadsTemplate.cloneNode());
            positionBeads();
            setTitle();
        }, 3000);
    }, 3000);
}