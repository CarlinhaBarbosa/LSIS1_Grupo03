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
