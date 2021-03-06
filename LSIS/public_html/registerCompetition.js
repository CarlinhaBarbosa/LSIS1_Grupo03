/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


/* global fetch */

function Enviar() {
    var nomeInput = document.getElementById("nomeId");
    var dataCriacaoInput = document.getElementById("dataCriacaoId");

    if (nomeInput.value === "") {
        alert("Insira um nome válido");
    }
    var filterData = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
    if (!filterData.test(dataCriacaoInput.value)) {
        alert("Insira uma data válida");
        dataCriacaoInput.focus;
        return false;
    }

    let form = document.getElementById("registerCompetitionForm");
    let formdata = new FormData(form);

    fetch('/registarCompeticao', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Competição inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação da Competição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}


