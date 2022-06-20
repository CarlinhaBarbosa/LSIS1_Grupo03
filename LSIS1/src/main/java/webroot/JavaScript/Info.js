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
                                data[i].nomeRobot + '</td><td>' + data[i].macAdress + '</td></tr>';
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
    var idAEnviar = document.getElementById("inputTeamId").value;
    fetch('/selecionarEquipa?id=' + idAEnviar, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("teamId").value = data.idEquipa;
                document.getElementById("teamNameId").value = data.nomeEquipa;
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
    var idAEnviar = document.getElementById("inputRobotId").value;
    
    fetch('/selecionarRobot?id=' + idAEnviar, {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                document.getElementById("robotId").value = data.idRobot;
                document.getElementById("teamNameRobotId").value = data.idEquipa;
                document.getElementById("robotNameId").value = data.nomeRobot;
                document.getElementById("macAddressId").value = data.macAdress;

            })
            .catch((err) => console.log(err));
}
function botaoDeleteTeamOfSistem() {
    var idAEnviar = document.getElementById("inputIdTeam").value;

    fetch('/eliminarEquipa?id=' + idAEnviar, {
        method: 'POST'
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Equipa  eliminada do sistema com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na eliminação da equipa do sistema!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}
function botaoDeleteRobotOfSystem() {
    var idAEnviar = document.getElementById("inputRobotId").value;

    fetch('/eliminarRobot?id=' + idAEnviar, {
        method: 'POST'
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Robô  eliminado do sistema com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na eliminação do robô do sistema!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}