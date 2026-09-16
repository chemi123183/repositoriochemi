console.log("Hola, mundo!");
//comentario 
const name = "Chemi";
console.log(name);

let age = 25;
var age2 = 25;
console.log(age , age2);

console.log(`Mi nombre es ${name} y tengo ${age} años.`);

const text = "hola"; //String
console.log(text);


const isActive = true; //Boolean

const empty = null;

let notassigned; //Undefined

const student = {name: "Chemi",age: 25}; //Crear un objeto

console.log(`Hola, me llamo ${student.name} y tengo ${student.age} años.`); //Acceder a las propiedades del objeto

const colors = ["rojo", "azul", "negro"]; //Crear un array
console.log(colors [0]); //Acceder a los elementos del array


function greet (student){
    console.log(`Hola, ${student.name}!`);
}

greet(student);

let selectedPhoto = null;
console.log(selectedPhoto);

selectedPhoto = "foto1.jpg"
console.log(selectedPhoto);