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

    document.getElementById("login").style.display = "none";
    document.getElementById("displayPlayer1").innerHTML=document.querySelector('[id="player1"]').value;
    document.getElementById("displayPlayer2").innerHTML=document.querySelector('[id="player2"]').value;
    document.getElementById("outerFrame").style.display = "";
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
    for (let i = 0; i < 16; i++) {
        for (let j = 1; j <= 6; j++) {
            document.getElementById('pb' + j).appendChild(beadsTemplate.cloneNode());
            document.getElementById('pt' + j).appendChild(beadsTemplate.cloneNode());
        }
    }
    positionBeads();
}

function getCurrentCount() {
    let beadCount;
    setTimeout(function() {
        beadCount = $.getJSON('http://localhost:8080/beadcount', function (data) {
            return data;
        });
    }, 3000);
    return beadCount;
}

function setTitle() {
    let beadCount = $.getJSON('http://localhost:8080/beadcount', function (data) {
        return data;
    });
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
    function handleErrors(response) {
        if (!response.ok) {
            throw Error(response.statusText);
        }
        return response;
    }
    fetch("http://localhost:8080/exception", {
        method:"GET",
    }).then(handleErrors)
        .then(response => console.log("ok") )
        .catch(error => console.log(error) );

    // fetch("http://localhost:8080/testmongoadd", {
    //     method:"POST",
    //     body: JSON.stringify({
    //         first: "Deska"
    //     })
    // }).then(handleErrors)
    //     .then(response => console.log("ok") )
    //     .catch(error => console.log(error) );
    //
    // b = $.getJSON('http://localhost:8080/testmongo',function(data) {
    //     // debugger;
    //     return data;
    // });

    var clickedPotId = "";
    clickedPotId = event.target.id;
    if (event.target.id == "") {
        clickedPotId = event.target.parentNode.id;
    }
    alert(clickedPotId);

    let beadCount = $.getJSON('http://localhost:8080/beadcount', function (data) {
        return data;
    });

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
        positionBeads();
        setTitle();
    }, 3000);
}