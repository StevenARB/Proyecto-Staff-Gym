let botaoCalcular = document.getElementById(btn_calcular);
function calculandoIMC(){
     let nombre = document.getElementById("nombre").value;
    let peso = document.getElementById("peso").value;
    let altura = document.getElementById("altura").value/100;
    let resultado = document.getElementById("resultado")
    if(altura !== "" && peso !==""){
        let imc = (peso / (altura*altura)).toFixed();
        let message = "";
        if(imc >= 0 && 18.5 < imc ){
            message = "Bajo de Peso"
           
        }else if(imc >=18.5 && imc < 24.9){
          message = "Saludable"
        }else if(imc >=25 && imc < 29.9){
            message = "Sobrepeso"
        }else if(imc >=30.1 && imc < 34.9){
            message = "Obesidad Grado I"
            }else if(imc >=35 && imc < 39.9){
           message = "Obesidad Grado II"
        }else if(imc >40){
           message = "Cuidado! Obesidad grado III"
        
        }
        resultado.textContent = `Su IMC es ${imc} ${message}`;      
    }else{
        resultado.textContent = "Complete todos los campos"
    }
}
btn_calcular.addEventListener('click', calculandoIMC);


