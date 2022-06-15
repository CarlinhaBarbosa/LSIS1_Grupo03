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

    fetch('/obterCompeticoes', {
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
                        li += '<tr><td>' + data[i].idCompeticao + '</td><td>' + data[i].nomeCompeticao + '</td><td>' +
                                data[i].dataCriacaoString + '</td></tr>';
                    }
                    document.getElementById("listaCompeticoes").innerHTML = li;
                }


            })
            .catch((err) => console.log(err));
}

function botaoCompetitionSubscribe() {
    var xH = document.getElementById("h2CompetitionSubscribe");
    var xP = document.getElementById("pCompetitionSubscribe");
    var xI = document.getElementById("fCompetitionSubscription");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
}
function submeterDados() {
    let form = document.getElementById("fCompetitionSubscription");
    let formData = new FormData(form);

    for (var pair of formData.entries()) {
        console.log(pair[0] + ', ' + pair[1]);
    }

    fetch('/inscreverEquipaCompeticao', {
        method: 'POST',
        body: formData
    })
            .then((res) => {
                if (res.status === 200) {
                    var infoPanel = document.getElementById("infoPanel");
                    infoPanel.innerHTML = "<div>Inscrição inserida com sucesso!</div>";
                    return res.json();
                } else {
                    infoPanel.innerHTML = "<div>Ocorreu um erro na inscrição!</div>";
                    return res.json();
                }
            })
            .catch((err) => console.log(err));
}

