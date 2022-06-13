/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
/* global fetch */

function Enviar() {
    var nomeInput = document.getElementById("nomeId");

    if (nomeInput.value === "") {
        alert("Insira um nome válido");
    }

    let form = document.getElementById("registerTeamForm");
    let formdata = new FormData(form);

    fetch('/registarEquipa', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Equipa inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação da Equipa!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

