/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
/* global fetch */

function Enviar() {

    let form = document.getElementById("registerRoundFormId");
    let formData = new FormData(form);

//    for (var pair of formData.entries()) {
//        console.log(pair[0] + ', ' + pair[1]);
//    }

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