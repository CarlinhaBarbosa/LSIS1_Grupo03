/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
/* global fetch */

function botaoCompetitionList() {
    var xH = document.getElementById("h2CompetitionTableInfo");
    var xP = document.getElementById("pCompetitionTableInfo");
    var xI = document.getElementById("tCompetitionTableInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }

    fetch('/selecionarRobot?id=' + idAEnviar, {
        method: 'GET',
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
//                let li = '<tr><th>Nome</th><th>Data de Nascimento</th><th>Número Fiscal</th><th>Telefone</th><th>E-mail</th><th>Morada</th></tr>';
//                li = li + '<tr><td>' + data.nome + '</td><td>' + data.dataNas + '</td><td>' +
//                        data.nrFiscal + '</td><td>' + data.telefone + '</td><td>' + data.email + '</td> <td>' + data.morada + '</td></tr>';
//                document.getElementById("tClientInfoDB").innerHTML = li;
                document.getElementById("robotId").value = data.idRobot;
                document.getElementById("teamNameId").value = data.idEquipa;
                document.getElementById("robotNameId").value = data.nomeRobot;
                document.getElementById("macAddressId").value = data.macAddress;
            })
            .catch((err) => console.log(err));
}
function Enviar() {
    
    let form = document.getElementById("registerRoundFormId");
    let formData = new FormData(form);
    
    for (var pair of formData.entries()) {
    console.log(pair[0]+ ', ' + pair[1]); 
}

    fetch('/registarRonda', {
        method: 'POST',
        body: formData
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Ronda inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na criação da Ronda!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}