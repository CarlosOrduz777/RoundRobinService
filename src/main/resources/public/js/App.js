function loadRequest(){
    var cadena = document.getElementById("cadena").value
    var url = "/round?cadena="+cadena
    axios.get(url)
    .then(response => {
        // Obtenemos los datos
        document.getElementById("responseData").innerHTML = JSON.stringify(response.data);
    })
    .catch(e => {
        alert("An error ocurred");
    })
}