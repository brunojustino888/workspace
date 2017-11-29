window.onload = function () {
    setInterval(apresentarHoras, 1000);
}

function apresentarHoras() {
    agora = new Date();
    horas = agora.getHours() + ":" + agora.getMinutes() + ":" + agora.getSeconds();
    document.getElementById("relogio").innerHTML = horas;
}