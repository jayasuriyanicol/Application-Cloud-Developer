import{API_KEY,SECRET_KEY} from "./util.js"
console.log(util.API_KEY);
console.log(util.SECRET_KEY);


console.log("Nicol")

for(let i=0;i<4;i++){

    console.log(i)
}




const arr1 =[1,2,3];
let [a,b] = arr1;

console.log(a,b);

console.log(arr1,...arr1);

const arr2=[...arr1];

const arr3=[...arr1,...arr2] 
console.log(arr3);




arr1.push(4);
arr2.unshift(0);
console.log(arr1,arr2);



//Notazione Litteral
const prof={
    nome: "Nicol",
    cognome:"Jayasuriya",
    eta:21,
    indirizzo:{
        via: "VIA CESARE PAVESE",
        citta: "ROMA", 
        nazione: "ITALIA"
    }
}

let {nome,cognome} = prof
console.log(nome,cognome);


//-------------------  SPIEGAZIONE COMPILAZIONE DAIT   ----------------------------

console.log(prof.indirizzo.via);
console.log(prof["cognome"])


const prof2= new Object();
prof2.nome="Cristiano"
prof2.cognome= "Coccia"

console.log(prof2)

function persona(nome='', cognome=''){
    this.nome=nome
    this.cognome=cognome


} 


const NicolJayasuriya= new persona ("Nicol", "Jayasuriya");
const CristianoCoccia= new persona ("Cristiano","Coccia");

CristianoCoccia.telefono="+39 3529284094";

NicolJayasuriya.CalcolaCodiceFiscale= function(){
    return "Codice Fiscale"
}


console.log(NicolJayasuriya,CristianoCoccia);
console.log(NicolJayasuriya.CalcolaCodiceFiscale());
console.log(CristianoCoccia.CalcolaCodiceFiscale());
