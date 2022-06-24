/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global fetch */

function Enviar() {

    var idEquipaInput = document.getElementById("idEquipaId");
    var nomeInput = document.getElementById("nomeId");
    var macAddressInput = document.getElementById("macAddressId");

    if (isNaN(idEquipaInput.value) || idEquipaInput.value === "") {
        alert("Insira um ID válido");
    }

    if (nomeInput.value === "") {
        alert("Insira um nome válido");
    }

    var filterMacAddress = /^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$/i;
    if (!filterMacAddress.test(macAddressInput.value)) {
        alert("Insira um Mac Address válido");
        macAddressInput.focus;
    }

    let form = document.getElementById("registerRobotForm");
    let formdata = new FormData(form);

    fetch('/registarRobot', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Robô inserido com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação do Robô!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

function botaoTeamTableInfo() {
    var xH = document.getElementById("h2TeamTableInfo");
    var xP = document.getElementById("pTeamTableInfo");
    var xI = document.getElementById("tTeamTableInfo");
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
                    document.getElementById("tHeaderId").style.display = 'flex';
                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idEquipa + '</td><td>' + data[i].nomeEquipa + '</td><tr>';
                    }
                    document.getElementById("listaEquipas").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}

