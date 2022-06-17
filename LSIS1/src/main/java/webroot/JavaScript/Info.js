/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global fetch */

function botaoTeamInfo() {
    var xH = document.getElementById("h2TeamInfo");
    var xP = document.getElementById("pTeamInfo");
    var xI = document.getElementById("tTeamInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }

    fetch('/obterEquipas', {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderEquipasId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idEquipa + '</td><td>' + data[i].nomeEquipa + '</td></tr>';
                    }
                    document.getElementById("listaEquipas").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

function botaoRobotInfo() {
    var xH = document.getElementById("h2RobotInfo");
    var xP = document.getElementById("pRobotInfo");
    var xI = document.getElementById("tRobotInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    fetch('/obterRobots', {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderRobotsId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idRobot + '</td><td>' + data[i].idEquipa + '</td><td>' +
                                data[i].nomeRobot + '</td><td>' + data[i].macAddress + '</td></tr>';
                    }
                    document.getElementById("listaRobots").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

function botaoTeamDetails() {
    var xH = document.getElementById("h2TeamDetails");
    var xP = document.getElementById("pTeamDetails");
    var xI = document.getElementById("fTeamDetails");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }

    fetch('/obterEquipas', {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderEquipasId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idEquipa + '</td><td>' + data[i].nomeEquipa + '</td></tr>';
                    }
                    document.getElementById("listaEquipas").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

function botaoRobotDetails() {
    var xH = document.getElementById("h2RobotDetails");
    var xP = document.getElementById("pRobotDetails");
    var xI = document.getElementById("fRobotDetails");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }

    fetch('/obterEquipas', { //alterar fetch (comment by joaoFerreira : 18/06/22
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("tHeaderEquipasId").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idEquipa + '</td><td>' + data[i].nomeEquipa + '</td></tr>';
                    }
                    document.getElementById("listaEquipas").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}