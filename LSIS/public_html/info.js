/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


/* global fetch */

function botaoClientInfo() {
    var xH = document.getElementById("h2TeamInfo");
    var xP = document.getElementById("pTeamInfo");
    var xI = document.getElementById("fTeamInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputIdCliente").value;

    fetch('/selecionarCliente?id=' + idAEnviar, {
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
                document.getElementById("nomeId").value = data.nome;
                document.getElementById("dataNascId").value = data.dataNas;
                document.getElementById("numeroFiscalId").value = data.nrFiscal;
                document.getElementById("numeroTelefoneId").value = data.telefone;
                document.getElementById("emailId").value = data.email;
                document.getElementById("moradaId").value = data.morada;
            })
            .catch((err) => console.log(err));
}

function botaoRobotInfo() {
    var xH = document.getElementById("h2RobotInfo");
    var xP = document.getElementById("pRobotInfo");
    var xI = document.getElementById("fRobotInfo");
    if (xH.style.display === "none" && xP.style.display === "none" && xI.style.display === "none") {
        xH.style.display = "block";
        xP.style.display = "block";
        xI.style.display = "block";
    } else {
        xH.style.display = "none";
        xP.style.display = "none";
        xI.style.display = "none";
    }
    var idAEnviar = document.getElementById("inputIdRobot").value;

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

function botaoClientBillInfo() {
    var xH = document.getElementById("h2ClientBillInfo");
    var xP = document.getElementById("pClientBillInfo");
    var xI = document.getElementById("fClientBillInfo");
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
function botaoParkInfo() {
    var xH = document.getElementById("h2ParkInfo");
    var xP = document.getElementById("pParkInfo");
    var xI = document.getElementById("tParkInfo");
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

function alterarDados() {

    let nomeInput = document.getElementById("nomeId");
    let dataNascInput = document.getElementById("dataNascId");
    let telefoneInput = document.getElementById("numeroTelefoneId");
    let emailInput = document.getElementById("emailId");
    let numeroFiscalInput = document.getElementById("numeroFiscalId");
    let matricula1Input = document.getElementById("matricula1Id");
    let matricula2Input = document.getElementById("matriculaId2");


    var filterPlate = /^([A-Z]{2}|\d\d)-([A-Z]{2}|\d\d)-([A-Z]{2}|\d\d)$/;
    if (!filterPlate.test(matricula1Input.value) && matricula2Input.style.display === "none") {
        alert("Insira um endereço de matrícula válido");
        matricula1Input.focus;
        return false;
    } else if (!filterPlate.test(matricula1Input.value) && filterPlate.test(matricula2Input.value)) {
        alert("Insira um endereço de matrícula da 1ª viatura válido");
        matricula2Input.focus;
        return false;
    } else if (filterPlate.test(matricula1Input.value) && !filterPlate.test(matricula2Input.value)) {
        alert("Insira um endereço de matrícula da 2ª viatura válido");
        matricula2Input.focus;
        return false;
    }

    if (nomeInput.value === "") {
        alert("Insira um nome válido");
    }
    var filterData = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
    if (!filterData.test(dataNascInput.value)) {
        alert("Insira uma data válida");
        dataNascInput.focus;
        return false;

    }
    if (telefoneInput.length !== 9 || numeroFiscalInput.length !== 9) {
        alert("Insira um número com 9 dígitos");

    }
    var filter = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!filter.test(emailInput.value)) {
        alert("Insira um endereço de email válido");
        emailInput.focus;
        return false;
    }

    let form = document.getElementById('fClientInfo');
    let formdata = new FormData(form);
    fetch('/updateCliente', {
        method: 'POST',
        body: formdata
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .catch((err) => console.log(err));
}