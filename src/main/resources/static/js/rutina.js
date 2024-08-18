//Carga un archivo imagen en memoria y lo presenta en pantalla

function readURL(input){
    if(input.files && input.files[0]){
        var reader = new FileReader();
        reader.onload = function (e){
            $('#blah')
                        .attr('src',e.target.result)
                        .height(200);
            
            
        };
        reader.readAsDataURL(input.files[0]);
    }
}

function addCart(formulario) {
    var idProducto = formulario.elements[0].value;
    var existencias = formulario.elements[1].value;
    if (existencias > 0) {
        var url = "/carrito/agregar/" + idProducto;
        $("#resultsBlock").load(url);
    }
}